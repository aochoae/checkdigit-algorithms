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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * <a href="https://www.bincodes.com/random-creditcard-generator/">Credit Card Number Generator</a>
 */
class LuhnCheckDigitTest {

    LuhnCheckDigit luhnCheckDigit = new LuhnCheckDigit();

    @Test
    void generate() {
        assertEquals("48721484", luhnCheckDigit.generate("4872148"));
        assertEquals("371850480102358", luhnCheckDigit.generate("37185048010235"));
    }

    @Test
    void isValid() {
        assertTrue(luhnCheckDigit.isValid("48721484"));
        assertTrue(luhnCheckDigit.isValid("371850480102358"));
    }

    @Test
    void isNotValid() {
        assertFalse(luhnCheckDigit.isValid("48721489"));
        assertFalse(luhnCheckDigit.isValid("371850480102350"));
    }
}
