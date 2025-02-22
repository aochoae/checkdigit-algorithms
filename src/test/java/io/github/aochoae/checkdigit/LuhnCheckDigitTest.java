/*
 * Copyright 2020-2025 Luis A. Ochoa
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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * <a href="https://www.bincodes.com/random-creditcard-generator/">Credit Card Number Generator</a>
 */
class LuhnCheckDigitTest {

    LuhnCheckDigit luhnCheckDigit = new LuhnCheckDigit();

    @ParameterizedTest
    @CsvFileSource(resources = "/Luhn_generate.csv")
    void testGenerate(String input, String expected) {
        assertEquals(expected, luhnCheckDigit.generate(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Luhn_isValid.csv")
    void testIsValid(boolean expected, String input) {
        assertEquals(expected, luhnCheckDigit.isValid(input));
    }
}
