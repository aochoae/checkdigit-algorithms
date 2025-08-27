# Check digit algorithms

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=aochoae_checkdigit-algorithms&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=aochoae_checkdigit-algorithms)

A check digit algorithm works by adding an extra digit, called the check digit, which is calculated from the other digits in the number using a mathematical formula. These algorithms help catch common mistakes like mistyped, missing, or transposed digits.

Algorithms:

* Damm algorithm
* Luhn algorithm
* Verhoeff algorithm

## Getting started

We need to create a Java file to contain the following code:

    package demo;

    import io.github.aochoae.checkdigit.LuhnCheckDigit;

    public class App {

        public static void main(String args[]) {

            LuhnCheckDigit checkDigit = new LuhnCheckDigit();

            System.out.println(checkDigit.generate("4872148"));

        }
    }

The output must be

    48721484

## Declare dependencies

Add the following dependency to your project:

### Gradle

    dependencies {
        implementation 'io.github.aochoae:checkdigit-algorithms:2.1.2'
    }

### Maven

    <dependencies>
        <dependency>
            <groupId>io.github.aochoae</groupId>
            <artifactId>checkdigit-algorithms</artifactId>
            <version>2.1.2</version>
        </dependency>
    </dependencies>

## License

Copyright 2020- Luis A. Ochoa

This project is licensed under the Apache License, Version 2.0.
See [LICENSE](LICENSE) for the full license text.
