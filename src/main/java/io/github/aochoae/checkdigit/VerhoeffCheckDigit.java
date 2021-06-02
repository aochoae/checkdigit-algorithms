/*
 * Copyright 2020-2021 Luis A. Ochoa
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
import java.util.stream.IntStream;

/**
 * @author Luis A. Ochoa
 */
public class VerhoeffCheckDigit implements CheckDigit {

    private static final int[][] P = {
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 5, 7, 6, 2, 8, 3, 0, 9, 4 },
        { 5, 8, 0, 3, 7, 9, 6, 1, 4, 2 },
        { 8, 9, 1, 6, 0, 4, 3, 5, 2, 7 },
        { 9, 4, 5, 3, 1, 2, 6, 8, 7, 0 },
        { 4, 2, 8, 6, 5, 7, 3, 9, 0, 1 },
        { 2, 7, 9, 3, 8, 0, 6, 4, 1, 5 },
        { 7, 0, 4, 6, 9, 1, 3, 2, 5, 8 }
    };

    private static final int[][] D = {
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        { 1, 2, 3, 4, 0, 6, 7, 8, 9, 5 },
        { 2, 3, 4, 0, 1, 7, 8, 9, 5, 6 },
        { 3, 4, 0, 1, 2, 8, 9, 5, 6, 7 },
        { 4, 0, 1, 2, 3, 9, 5, 6, 7, 8 },
        { 5, 9, 8, 7, 6, 0, 4, 3, 2, 1 },
        { 6, 5, 9, 8, 7, 1, 0, 4, 3, 2 },
        { 7, 6, 5, 9, 8, 2, 1, 0, 4, 3 },
        { 8, 7, 6, 5, 9, 3, 2, 1, 0, 4 },
        { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }
    };

    private static final int[] INV = { 0, 4, 3, 2, 1, 5, 6, 7, 8, 9 };

    @Override
    public String generate(String sequence) {
        return compute(toDigits(sequence));
    }

    @Override
    public boolean isValid(String sequence) {

        int[] revert = revert(toDigits(sequence));

        return (getLastDigit(revert) == 0);
    }

    private String compute(final int[] sequence) {

        int[] newSequence = Arrays.copyOf(sequence, sequence.length + 1);

        newSequence[sequence.length] = 0;

        int[] revert = revert(newSequence);

        int lastDigit = INV[getLastDigit(revert)];

        return toString(sequence, lastDigit);
    }

    private int getLastDigit(int[] sequence) {

        int c = 0;

        for (int i = 0; i < sequence.length; i++) {
            c = D[c][P[i % 8][sequence[i]]];
        }

        return c;
    }

    private int[] revert(int[] rawSequence) {

        int[] revert = IntStream.range(0, rawSequence.length)
            .map(i -> rawSequence[rawSequence.length - i - 1])
            .toArray();

        return revert;
    }
}
