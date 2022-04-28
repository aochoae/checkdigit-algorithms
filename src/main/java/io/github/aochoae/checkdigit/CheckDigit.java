/*
 * Copyright 2020-2022 Luis A. Ochoa
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
import java.util.stream.Collectors;

/**
 * Check Digit interface.
 *
 * @author Luis A. Ochoa
 * @version 1.0.0
 */
public interface CheckDigit {

    /**
     * Appends the check digit to a given digit sequence.
     *
     * @param sequence Digit sequence.
     * @return The sequence of digits with the calculated check digit.
     */
    String generate(String sequence);

    /**
     * Verifies whether a digit sequence is valid.
     *
     * @param sequence Digit sequence.
     * @return <code>true</code> if the check digit is correct; <code>false</code> otherwise.
     */
    boolean isValid(String sequence);

    /**
     * Retrieves an array containing the digit sequence.
     *
     * @param sequence Digit sequence to be computed.
     * @throws CheckDigitException Indicates that the sequence is incorrect.
     * @return An array containing all the digits in this sequence.
     */
    default int[] toDigits(String sequence) {

        if (!sequence.matches("\\d+")) {
            throw new CheckDigitException();
        }

        String[] characters = sequence.split("");

        return Arrays.stream(characters)
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    /**
     * Retrieves a string containing the digit sequence with the check digit.
     *
     * @param sequence Digit sequence.
     * @param digit Check digit.
     * @return The sequence of digits with the calculated check digit.
     */
    default String toString(int[] sequence, int digit) {

        // Current length
        int last = sequence.length;

        // Add new digit
        int[] newSequence = Arrays.copyOf(sequence, last + 1);

        newSequence[last] = digit;

        // To String
        return Arrays.stream(newSequence)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(""));
    }
}
