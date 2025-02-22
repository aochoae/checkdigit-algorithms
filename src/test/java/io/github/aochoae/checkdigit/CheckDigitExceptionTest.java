/*
 * Copyright 2022-2025 Luis A. Ochoa
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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckDigitExceptionTest {

    @Test
    void assertThrowsCheckDigitException() {

        LuhnCheckDigit luhnCheckDigit = new LuhnCheckDigit();

        assertThrows(CheckDigitException.class, () -> {
            luhnCheckDigit.generate("123 456 789");
        });
    }

    @Test
    void assertThrowsIllegalArgumentException() {

        VerhoeffCheckDigit verhoeffCheckDigit = new VerhoeffCheckDigit();

        assertThrows(IllegalArgumentException.class, () -> {
            verhoeffCheckDigit.generate("123e-10");
        });
    }

    @Test
    void digits() {

        DammCheckDigit dammCheckDigit = new DammCheckDigit();

        assertThrows(IllegalArgumentException.class, () -> {
            dammCheckDigit.generate("0123456789ABCDEF");
        });
    }
}
