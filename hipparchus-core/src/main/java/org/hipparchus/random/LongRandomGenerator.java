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

package org.hipparchus.random;

import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalArgumentException;

/**
 * Base class for all {@code long}-based (64-bit) random generator
 * implementations.
 */
abstract class LongRandomGenerator extends BaseRandomGenerator {

    /** Bitmask for the high bits of a double value. */
    private static final long DOUBLE_HIGH_BITS = 0x3ffL << 52;

    /** {@inheritDoc} */
    @Override
    public abstract long nextLong();

    /** {@inheritDoc} */
    @Override
    public int nextInt() {
        final long v = nextLong();
        return ((int) (v >>> 32)) ^ (int) v;
    }

    /** {@inheritDoc} */
    @Override
    public double nextDouble() {
        // http://xorshift.di.unimi.it
        return Double.longBitsToDouble(DOUBLE_HIGH_BITS | nextLong() >>> 12) - 1d;
    }

    /** {@inheritDoc} */
    @Override
    public boolean nextBoolean() {
        return (nextLong() >>> 63) != 0;
    }

    /** {@inheritDoc} */
    @Override
    public float nextFloat() {
        return (nextInt() >>> 9) * 0x1.0p-23f;
    }

    /** {@inheritDoc} */
    @Override
    public void nextBytes(byte[] bytes) {
        nextBytesFill(bytes, 0, bytes.length);
    }

    /** {@inheritDoc} */
    @Override
    public void nextBytes(byte[] bytes, int start, int len) {
        if (start < 0 ||
            start >= bytes.length) {
            throw new MathIllegalArgumentException(LocalizedCoreFormats.OUT_OF_RANGE_SIMPLE,
                                                   start, 0, bytes.length);
        }
        if (len < 0 ||
            len > bytes.length - start) {
            throw new MathIllegalArgumentException(LocalizedCoreFormats.OUT_OF_RANGE_SIMPLE,
                                                   len, 0, bytes.length - start);
        }

        nextBytesFill(bytes, start, len);
    }

    /**
     * Generates random bytes and places them into a user-supplied array.
     *
     * @see #nextBytes(byte[], int, int)
     *
     * @param bytes the non-null byte array in which to put the random bytes
     * @param offset the starting index for inserting the generated bytes into
     * the array
     * @param len the number of bytes to generate
     * @throws MathIllegalArgumentException if {@code offset < 0} or
     * {@code offset + len >= bytes.length}
     */
    private void nextBytesFill(byte[] bytes, int offset, int len) {
        int index = offset; // Index of first insertion.

        // Index of first insertion plus multiple of 8 part of length
        // (i.e. length with 3 least significant bits unset).
        final int indexLoopLimit = index + (len & 0x7ffffff8);

        // Start filling in the byte array, 8 bytes at a time.
        while (index < indexLoopLimit) {
            final long random = nextLong();
            bytes[index++] = (byte) random;
            bytes[index++] = (byte) (random >>> 8);
            bytes[index++] = (byte) (random >>> 16);
            bytes[index++] = (byte) (random >>> 24);
            bytes[index++] = (byte) (random >>> 32);
            bytes[index++] = (byte) (random >>> 40);
            bytes[index++] = (byte) (random >>> 48);
            bytes[index++] = (byte) (random >>> 56);
        }

        final int indexLimit = offset + len; // Index of last insertion + 1.

        // Fill in the remaining bytes.
        if (index < indexLimit) {
            long random = nextLong();
            while (true) {
                bytes[index++] = (byte) random;
                if (index < indexLimit) {
                    random >>>= 8;
                } else {
                    break;
                }
            }
        }
    }
}
