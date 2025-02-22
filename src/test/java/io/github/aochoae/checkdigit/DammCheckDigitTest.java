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

class DammCheckDigitTest {

    private final DammCheckDigit dammCheckDigit = new DammCheckDigit();

    @ParameterizedTest
    @CsvFileSource(resources = "/Damm_generate.csv")
    void testGenerate(String input, String expected) {
        assertEquals(expected, dammCheckDigit.generate(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Damm_isValid.csv")
    void testIsValid(boolean expected, String input) {
        assertEquals(expected, dammCheckDigit.isValid(input));
    }
}
