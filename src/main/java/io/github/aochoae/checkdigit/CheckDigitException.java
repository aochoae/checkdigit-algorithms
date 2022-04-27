package io.github.aochoae.checkdigit;

/**
 * Check Digit Exception.
 *
 * @author Luis A. Ochoa
 * @version 2.1.0
 */
public class CheckDigitException extends IllegalArgumentException {

    public CheckDigitException() {
        super("The sequence can only contain digits.");
    }
}
