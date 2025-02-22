# Check digit algorithms

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=aochoae_checkdigit-algorithms&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=aochoae_checkdigit-algorithms)

Algorithms:

* Damm algorithm
* Luhn algorithm
* Verhoeff algorithm

Documentation

* [Wiki](https://github.com/aochoae/checkdigit-algorithms/wiki)

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
