/*
 * Copyright 2020 Luis A. Ochoa
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

package dev.luisalberto.checkdigit.luhn;

import java.util.Arrays;

import dev.luisalberto.checkdigit.CheckDigit;

/**
 * @author Luis A. Ochoa
 */
public class LuhnCheckDigit implements CheckDigit {

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
    private static final int[] SUBTITUTE = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };

    @Override
    public String generate(String sequence) {
        return compute(toDigits(sequence));
    }

    @Override
    public boolean isValid(String sequence) {

        String subSequense = sequence.substring(0, sequence.length() - 1);

        return sequence.equals(compute(toDigits(subSequense)));
    }

    /**
     * Computes a check digit or verify numbers that already have a check digit
     * appended.
     * 
     * @param rawSequence
     * @param length
     * @return
     */
    private String compute(final int[] sequence) {

        int[] newSequence = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            newSequence[i] = (i % 2 == 0) ? SUBTITUTE[sequence[i]] : sequence[i];
        }

        int summation = Arrays.stream(newSequence).sum();

        int lastDigit = (summation * 9) % 10;

        return toString(sequence, lastDigit);
    }
}
