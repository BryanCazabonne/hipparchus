/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.math.ode;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.IOException;

/** This class is a step interpolator that does nothing.
 *
 * <p>This class is used when the {@link StepHandler "step handler"}
 * set up by the user does not need step interpolation. It does not
 * recompute the state when {@link AbstractStepInterpolator#setInterpolatedTime
 * setInterpolatedTime} is called. This implies the interpolated state
 * is always the state at the end of the current step.</p>
 *
 * @see StepHandler
 *
 * @version $Revision$ $Date$
 *
 */

public class DummyStepInterpolator
  extends AbstractStepInterpolator {

  /** Simple constructor.
   * This constructor builds an instance that is not usable yet, the
   * <code>AbstractStepInterpolator.reinitialize</code> protected method
   * should be called before using the instance in order to initialize
   * the internal arrays. This constructor is used only in order to delay
   * the initialization in some cases. As an example, the {@link
   * EmbeddedRungeKuttaIntegrator} uses the prototyping design pattern
   * to create the step interpolators by cloning an uninitialized
   * model and latter initializing the copy.
   */
  public DummyStepInterpolator() {
    super();
  }

  /** Simple constructor.
   * @param y reference to the integrator array holding the state at
   * the end of the step
   * @param forward integration direction indicator
   */
  protected DummyStepInterpolator(double[] y, boolean forward) {
    super(y, forward);
  }

  /** Copy constructor.
   * @param interpolator interpolator to copy from. The copy is a deep
   * copy: its arrays are separated from the original arrays of the
   * instance
   */
  public DummyStepInterpolator(DummyStepInterpolator interpolator) {
    super(interpolator);
  }

  /** Really copy the finalized instance.
   */
  protected StepInterpolator doCopy() {
    return new DummyStepInterpolator(this);
  }

  /** Compute the state at the interpolated time.
   * In this class, this method does nothing: the interpolated state
   * is always the state at the end of the current step.
   * @param theta normalized interpolation abscissa within the step
   * (theta is zero at the previous time step and one at the current time step)
   * @param oneMinusThetaH time gap between the interpolated time and
   * the current time
   * @throws DerivativeException this exception is propagated to the caller if the
   * underlying user function triggers one
   */
  protected void computeInterpolatedState(double theta, double oneMinusThetaH)
    throws DerivativeException {
      System.arraycopy(currentState, 0, interpolatedState, 0, currentState.length);
  }
    
  public void writeExternal(ObjectOutput out)
    throws IOException {
    // save the state of the base class
    writeBaseExternal(out);
  }

  public void readExternal(ObjectInput in)
    throws IOException {

    // read the base class 
    double t = readBaseExternal(in);

    try {
      // we can now set the interpolated time and state
      setInterpolatedTime(t);
    } catch (DerivativeException e) {
      throw new IOException(e.getMessage());
    }

  }

  private static final long serialVersionUID = 1708010296707839488L;

}
