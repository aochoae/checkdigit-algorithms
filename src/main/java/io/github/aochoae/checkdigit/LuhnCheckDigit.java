/*
 * Copyright 2020-2023 Luis A. Ochoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.aochoae.checkdigit;

import java.util.Arrays;

/**
 * Luhn algorithm.
 *
 * @author Luis A. Ochoa
 * @version 1.0.0
 */
public final class LuhnCheckDigit implements CheckDigit {

    /**
     * Gives the substitute for each digit.
     *
     * <pre>
     * 4 * 2 = 8
     * 8 * 2 = 16 => 1 + 6 = 7
     * </pre>
     *
     * <pre>
     * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
     * 0, 2, 4, 6, 8, 1, 3, 5, 7, 9
     * </pre>
     */
    private static final int[] SUBSTITUTE = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };

    @Override
    public String generate(String sequence) {
        return compute(toDigits(sequence));
    }

    @Override
    public boolean isValid(String sequence) {

        String subSequence = sequence.substring(0, sequence.length() - 1);

        return sequence.equals(compute(toDigits(subSequence)));
    }

    /**
     * Luhn algorithm.
     */
    private String compute(final int[] sequence) {

        int[] newSequence = Arrays.copyOf(sequence, sequence.length);

        for (int i = (sequence.length - 1); i >= 0; i -= 2) {
            newSequence[i] = SUBSTITUTE[sequence[i]];
        }

        int summation = Arrays.stream(newSequence).sum();

        int lastDigit = (summation * 9) % 10;

        return toString(sequence, lastDigit);
    }
}
