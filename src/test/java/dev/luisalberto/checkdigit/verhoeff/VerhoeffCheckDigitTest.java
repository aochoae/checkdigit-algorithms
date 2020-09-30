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

package dev.luisalberto.checkdigit.verhoeff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VerhoeffCheckDigitTest {

    private final VerhoeffCheckDigit verhoeffCheckDigit = new VerhoeffCheckDigit();

    @Test
    public void generate() {
        assertEquals("0262533057", verhoeffCheckDigit.generate("026253305"));
    }

    @Test
    public void isValid() {
        assertTrue(verhoeffCheckDigit.isValid("0262533057"));
    }

    @Test
    public void isNotValid() {
        assertFalse(verhoeffCheckDigit.isValid("0262533056"));
    }

    @Test
    public void digits() {

        assertThrows(IllegalArgumentException.class, () -> {
            verhoeffCheckDigit.generate("123e-10");
        });
    }
}
