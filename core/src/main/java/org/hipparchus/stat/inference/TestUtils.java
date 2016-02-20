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
package org.hipparchus.stat.inference;

import java.util.Collection;

import org.hipparchus.distribution.RealDistribution;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.exception.MathIllegalStateException;
import org.hipparchus.exception.MaxCountExceededException;
import org.hipparchus.exception.NoDataException;
import org.hipparchus.exception.NullArgumentException;
import org.hipparchus.exception.NumberIsTooSmallException;
import org.hipparchus.exception.OutOfRangeException;
import org.hipparchus.exception.ZeroException;
import org.hipparchus.stat.descriptive.StatisticalSummary;

/**
 * A collection of static methods to create inference test instances or to
 * perform inference tests.
 *
 * @since 1.1
 */
public class TestUtils  {

    /** Singleton TTest instance. */
    private static final TTest T_TEST = new TTest();

    /** Singleton ChiSquareTest instance. */
    private static final ChiSquareTest CHI_SQUARE_TEST = new ChiSquareTest();

    /** Singleton OneWayAnova instance. */
    private static final OneWayAnova ONE_WAY_ANANOVA = new OneWayAnova();

    /** Singleton G-Test instance. */
    private static final GTest G_TEST = new GTest();

    /** Singleton K-S test instance */
    private static final KolmogorovSmirnovTest KS_TEST = new KolmogorovSmirnovTest();

    /**
     * Prevent instantiation.
     */
    private TestUtils() {
        super();
    }

    // CHECKSTYLE: stop JavadocMethodCheck

    /**
     * @see org.hipparchus.stat.inference.TTest#homoscedasticT(double[], double[])
     */
    public static double homoscedasticT(final double[] sample1, final double[] sample2)
        throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.homoscedasticT(sample1, sample2);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#homoscedasticT(org.hipparchus.stat.descriptive.StatisticalSummary, org.hipparchus.stat.descriptive.StatisticalSummary)
     */
    public static double homoscedasticT(final StatisticalSummary sampleStats1,
                                        final StatisticalSummary sampleStats2)
        throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.homoscedasticT(sampleStats1, sampleStats2);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#homoscedasticTTest(double[], double[], double)
     */
    public static boolean homoscedasticTTest(final double[] sample1, final double[] sample2,
                                             final double alpha)
        throws NullArgumentException, NumberIsTooSmallException,
        OutOfRangeException, MaxCountExceededException {
        return T_TEST.homoscedasticTTest(sample1, sample2, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#homoscedasticTTest(double[], double[])
     */
    public static double homoscedasticTTest(final double[] sample1, final double[] sample2)
        throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.homoscedasticTTest(sample1, sample2);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#homoscedasticTTest(org.hipparchus.stat.descriptive.StatisticalSummary, org.hipparchus.stat.descriptive.StatisticalSummary)
     */
    public static double homoscedasticTTest(final StatisticalSummary sampleStats1,
                                            final StatisticalSummary sampleStats2)
        throws NullArgumentException, NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.homoscedasticTTest(sampleStats1, sampleStats2);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#pairedT(double[], double[])
     */
    public static double pairedT(final double[] sample1, final double[] sample2)
        throws NullArgumentException, NoDataException,
        MathIllegalArgumentException, NumberIsTooSmallException {
        return T_TEST.pairedT(sample1, sample2);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#pairedTTest(double[], double[], double)
     */
    public static boolean pairedTTest(final double[] sample1, final double[] sample2,
                                      final double alpha)
        throws NullArgumentException, NoDataException, MathIllegalArgumentException,
        NumberIsTooSmallException, OutOfRangeException, MaxCountExceededException {
        return T_TEST.pairedTTest(sample1, sample2, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#pairedTTest(double[], double[])
     */
    public static double pairedTTest(final double[] sample1, final double[] sample2)
        throws NullArgumentException, NoDataException, MathIllegalArgumentException,
        NumberIsTooSmallException, MaxCountExceededException {
        return T_TEST.pairedTTest(sample1, sample2);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#t(double, double[])
     */
    public static double t(final double mu, final double[] observed)
        throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.t(mu, observed);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#t(double, org.hipparchus.stat.descriptive.StatisticalSummary)
     */
    public static double t(final double mu, final StatisticalSummary sampleStats)
        throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.t(mu, sampleStats);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#t(double[], double[])
     */
    public static double t(final double[] sample1, final double[] sample2)
        throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.t(sample1, sample2);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#t(org.hipparchus.stat.descriptive.StatisticalSummary, org.hipparchus.stat.descriptive.StatisticalSummary)
     */
    public static double t(final StatisticalSummary sampleStats1,
                           final StatisticalSummary sampleStats2)
        throws NullArgumentException, NumberIsTooSmallException {
        return T_TEST.t(sampleStats1, sampleStats2);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#tTest(double, double[], double)
     */
    public static boolean tTest(final double mu, final double[] sample, final double alpha)
        throws NullArgumentException, NumberIsTooSmallException,
        OutOfRangeException, MaxCountExceededException {
        return T_TEST.tTest(mu, sample, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#tTest(double, double[])
     */
    public static double tTest(final double mu, final double[] sample)
        throws NullArgumentException, NumberIsTooSmallException,
        MaxCountExceededException {
        return T_TEST.tTest(mu, sample);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#tTest(double, org.hipparchus.stat.descriptive.StatisticalSummary, double)
     */
    public static boolean tTest(final double mu, final StatisticalSummary sampleStats,
                                final double alpha)
        throws NullArgumentException, NumberIsTooSmallException,
        OutOfRangeException, MaxCountExceededException {
        return T_TEST.tTest(mu, sampleStats, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#tTest(double, org.hipparchus.stat.descriptive.StatisticalSummary)
     */
    public static double tTest(final double mu, final StatisticalSummary sampleStats)
        throws NullArgumentException, NumberIsTooSmallException,
        MaxCountExceededException {
        return T_TEST.tTest(mu, sampleStats);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#tTest(double[], double[], double)
     */
    public static boolean tTest(final double[] sample1, final double[] sample2,
                                final double alpha)
        throws NullArgumentException, NumberIsTooSmallException,
        OutOfRangeException, MaxCountExceededException {
        return T_TEST.tTest(sample1, sample2, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#tTest(double[], double[])
     */
    public static double tTest(final double[] sample1, final double[] sample2)
        throws NullArgumentException, NumberIsTooSmallException,
        MaxCountExceededException {
        return T_TEST.tTest(sample1, sample2);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#tTest(org.hipparchus.stat.descriptive.StatisticalSummary, org.hipparchus.stat.descriptive.StatisticalSummary, double)
     */
    public static boolean tTest(final StatisticalSummary sampleStats1,
                                final StatisticalSummary sampleStats2,
                                final double alpha)
        throws NullArgumentException, NumberIsTooSmallException,
        OutOfRangeException, MaxCountExceededException {
        return T_TEST.tTest(sampleStats1, sampleStats2, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.TTest#tTest(org.hipparchus.stat.descriptive.StatisticalSummary, org.hipparchus.stat.descriptive.StatisticalSummary)
     */
    public static double tTest(final StatisticalSummary sampleStats1,
                               final StatisticalSummary sampleStats2)
        throws NullArgumentException, NumberIsTooSmallException,
        MaxCountExceededException {
        return T_TEST.tTest(sampleStats1, sampleStats2);
    }

    /**
     * @see org.hipparchus.stat.inference.ChiSquareTest#chiSquare(double[], long[])
     */
    public static double chiSquare(final double[] expected, final long[] observed)
        throws MathIllegalArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException {
        return CHI_SQUARE_TEST.chiSquare(expected, observed);
    }

    /**
     * @see org.hipparchus.stat.inference.ChiSquareTest#chiSquare(long[][])
     */
    public static double chiSquare(final long[][] counts)
        throws NullArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException {
        return CHI_SQUARE_TEST.chiSquare(counts);
    }

    /**
     * @see org.hipparchus.stat.inference.ChiSquareTest#chiSquareTest(double[], long[], double)
     */
    public static boolean chiSquareTest(final double[] expected, final long[] observed,
                                        final double alpha)
        throws MathIllegalArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException, OutOfRangeException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(expected, observed, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.ChiSquareTest#chiSquareTest(double[], long[])
     */
    public static double chiSquareTest(final double[] expected, final long[] observed)
        throws MathIllegalArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(expected, observed);
    }

    /**
     * @see org.hipparchus.stat.inference.ChiSquareTest#chiSquareTest(long[][], double)
     */
    public static boolean chiSquareTest(final long[][] counts, final double alpha)
        throws NullArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException, OutOfRangeException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(counts, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.ChiSquareTest#chiSquareTest(long[][])
     */
    public static double chiSquareTest(final long[][] counts)
        throws NullArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTest(counts);
    }

    /**
     * @see org.hipparchus.stat.inference.ChiSquareTest#chiSquareDataSetsComparison(long[], long[])
     *
     * @since 1.2
     */
    public static double chiSquareDataSetsComparison(final long[] observed1,
                                                     final long[] observed2)
        throws MathIllegalArgumentException, MathIllegalArgumentException, ZeroException {
        return CHI_SQUARE_TEST.chiSquareDataSetsComparison(observed1, observed2);
    }

    /**
     * @see org.hipparchus.stat.inference.ChiSquareTest#chiSquareTestDataSetsComparison(long[], long[])
     *
     * @since 1.2
     */
    public static double chiSquareTestDataSetsComparison(final long[] observed1,
                                                         final long[] observed2)
        throws MathIllegalArgumentException, MathIllegalArgumentException, ZeroException,
        MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTestDataSetsComparison(observed1, observed2);
    }

    /**
     * @see org.hipparchus.stat.inference.ChiSquareTest#chiSquareTestDataSetsComparison(long[], long[], double)
     *
     * @since 1.2
     */
    public static boolean chiSquareTestDataSetsComparison(final long[] observed1,
                                                          final long[] observed2,
                                                          final double alpha)
        throws MathIllegalArgumentException, MathIllegalArgumentException,
        ZeroException, OutOfRangeException, MaxCountExceededException {
        return CHI_SQUARE_TEST.chiSquareTestDataSetsComparison(observed1, observed2, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.OneWayAnova#anovaFValue(Collection)
     *
     * @since 1.2
     */
    public static double oneWayAnovaFValue(final Collection<double[]> categoryData)
        throws NullArgumentException, MathIllegalArgumentException {
        return ONE_WAY_ANANOVA.anovaFValue(categoryData);
    }

    /**
     * @see org.hipparchus.stat.inference.OneWayAnova#anovaPValue(Collection)
     *
     * @since 1.2
     */
    public static double oneWayAnovaPValue(final Collection<double[]> categoryData)
        throws NullArgumentException, MathIllegalArgumentException,
        MathIllegalStateException, MaxCountExceededException {
        return ONE_WAY_ANANOVA.anovaPValue(categoryData);
    }

    /**
     * @see org.hipparchus.stat.inference.OneWayAnova#anovaTest(Collection,double)
     *
     * @since 1.2
     */
    public static boolean oneWayAnovaTest(final Collection<double[]> categoryData,
                                          final double alpha)
        throws NullArgumentException, MathIllegalArgumentException,
        OutOfRangeException, MathIllegalStateException, MaxCountExceededException {
        return ONE_WAY_ANANOVA.anovaTest(categoryData, alpha);
    }

     /**
     * @see org.hipparchus.stat.inference.GTest#g(double[], long[])
     * @since 3.1
     */
    public static double g(final double[] expected, final long[] observed)
        throws MathIllegalArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException {
        return G_TEST.g(expected, observed);
    }

    /**
     * @see org.hipparchus.stat.inference.GTest#gTest( double[],  long[] )
     * @since 3.1
     */
    public static double gTest(final double[] expected, final long[] observed)
        throws MathIllegalArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException, MaxCountExceededException {
        return G_TEST.gTest(expected, observed);
    }

    /**
     * @see org.hipparchus.stat.inference.GTest#gTestIntrinsic(double[], long[] )
     * @since 3.1
     */
    public static double gTestIntrinsic(final double[] expected, final long[] observed)
        throws MathIllegalArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException, MaxCountExceededException {
        return G_TEST.gTestIntrinsic(expected, observed);
    }

     /**
     * @see org.hipparchus.stat.inference.GTest#gTest( double[],long[],double)
     * @since 3.1
     */
    public static boolean gTest(final double[] expected, final long[] observed,
                                final double alpha)
        throws MathIllegalArgumentException, MathIllegalArgumentException,
        MathIllegalArgumentException, OutOfRangeException, MaxCountExceededException {
        return G_TEST.gTest(expected, observed, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.GTest#gDataSetsComparison(long[], long[])
     * @since 3.1
     */
    public static double gDataSetsComparison(final long[] observed1,
                                                  final long[] observed2)
        throws MathIllegalArgumentException, MathIllegalArgumentException, ZeroException {
        return G_TEST.gDataSetsComparison(observed1, observed2);
    }

    /**
     * @see org.hipparchus.stat.inference.GTest#rootLogLikelihoodRatio(long, long, long, long)
     * @since 3.1
     */
    public static double rootLogLikelihoodRatio(final long k11, final long k12, final long k21, final long k22)
        throws MathIllegalArgumentException, MathIllegalArgumentException, ZeroException {
        return G_TEST.rootLogLikelihoodRatio(k11, k12, k21, k22);
    }


    /**
     * @see org.hipparchus.stat.inference.GTest#gTestDataSetsComparison(long[], long[])
     * @since 3.1
     */
    public static double gTestDataSetsComparison(final long[] observed1,
                                                        final long[] observed2)
        throws MathIllegalArgumentException, MathIllegalArgumentException, ZeroException,
        MaxCountExceededException {
        return G_TEST.gTestDataSetsComparison(observed1, observed2);
    }

    /**
     * @see org.hipparchus.stat.inference.GTest#gTestDataSetsComparison(long[],long[],double)
     * @since 3.1
     */
    public static boolean gTestDataSetsComparison(final long[] observed1,
                                                  final long[] observed2,
                                                  final double alpha)
        throws MathIllegalArgumentException, MathIllegalArgumentException,
        ZeroException, OutOfRangeException, MaxCountExceededException {
        return G_TEST.gTestDataSetsComparison(observed1, observed2, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#kolmogorovSmirnovStatistic(RealDistribution, double[])
     * @since 3.3
     */
    public static double kolmogorovSmirnovStatistic(RealDistribution dist, double[] data)
            throws MathIllegalArgumentException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovStatistic(dist, data);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#kolmogorovSmirnovTest(RealDistribution, double[])
     * @since 3.3
     */
    public static double kolmogorovSmirnovTest(RealDistribution dist, double[] data)
            throws MathIllegalArgumentException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovTest(dist, data);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#kolmogorovSmirnovTest(RealDistribution, double[], boolean)
     * @since 3.3
     */
    public static double kolmogorovSmirnovTest(RealDistribution dist, double[] data, boolean strict)
            throws MathIllegalArgumentException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovTest(dist, data, strict);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#kolmogorovSmirnovTest(RealDistribution, double[], double)
     * @since 3.3
     */
    public static boolean kolmogorovSmirnovTest(RealDistribution dist, double[] data, double alpha)
            throws MathIllegalArgumentException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovTest(dist, data, alpha);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#kolmogorovSmirnovStatistic(double[], double[])
     * @since 3.3
     */
    public static double kolmogorovSmirnovStatistic(double[] x, double[] y)
            throws MathIllegalArgumentException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovStatistic(x, y);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#kolmogorovSmirnovTest(double[], double[])
     * @since 3.3
     */
    public static double kolmogorovSmirnovTest(double[] x, double[] y)
            throws MathIllegalArgumentException, NullArgumentException {
        return KS_TEST.kolmogorovSmirnovTest(x, y);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#kolmogorovSmirnovTest(double[], double[], boolean)
     * @since 3.3
     */
    public static double kolmogorovSmirnovTest(double[] x, double[] y, boolean strict)
            throws MathIllegalArgumentException, NullArgumentException  {
        return KS_TEST.kolmogorovSmirnovTest(x, y, strict);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#exactP(double, int, int, boolean)
     * @since 3.3
     */
    public static double exactP(double d, int m, int n, boolean strict) {
        return KS_TEST.exactP(d, n, m, strict);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#approximateP(double, int, int)
     * @since 3.3
     */
    public static double approximateP(double d, int n, int m) {
        return KS_TEST.approximateP(d, n, m);
    }

    /**
     * @see org.hipparchus.stat.inference.KolmogorovSmirnovTest#monteCarloP(double, int, int, boolean, int)
     * @since 3.3
     */
    public static double monteCarloP(double d, int n, int m, boolean strict, int iterations) {
        return KS_TEST.monteCarloP(d, n, m, strict, iterations);
    }


    // CHECKSTYLE: resume JavadocMethodCheck

}
