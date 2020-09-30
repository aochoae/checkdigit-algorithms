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

package dev.luisalberto.checkdigit;

/**
 * @author Luis A. Ochoa
 */
public interface CheckDigit {

    /**
     * Appends the check digit to a given digit sequence.
     * 
     * @param sequence
     * @return
     */
    String generate(String sequence);

    /**
     * Verifies whether a digit sequence is valid.
     * 
     * @param sequence
     * @return
     */
    boolean isValid(String sequence);

    /**
     * Retrieves an array containing the digit sequence.
     * 
     * @param sequence
     * @return
     */
    default int[] toDigits(String sequence) {

        if (!sequence.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        String[] characters = sequence.split("");

        int[] digits = new int[characters.length];

        for (int i = 0; i < digits.length; i++) {
            digits[i] = Integer.parseInt(characters[i]);
        }

        return digits;
    }

    /**
     * Retrieves a string containing the digit sequence with the check digit.
     * 
     * @param sequence
     * @param digit
     * @return
     */
    default String toString(int[] sequence, int digit) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sequence.length; i++) {
            stringBuilder.append(sequence[i]);
        }

        stringBuilder.append(digit);

        return stringBuilder.toString();
    }
}
