# Check digit algorithms

Algorithms:

* Damm algorithm
* Luhn algorithm
* Verhoeff algorithm

## Getting started

We need to create a Java file to contain the following code:

    package demo;

    import io.github.aochoae.checkdigit.CheckDigit;
    import io.github.aochoae.checkdigit.LuhnCheckDigit;

    public class App {
    
        public static void main(String args[]) {
 
            CheckDigit checkDigit = new LuhnCheckDigit();

            System.out.println(checkDigit.generate("4872148"));

        }
    }

The output must be

    48721484

## Declare dependencies

Add the following dependency to your project:

### Gradle

    dependencies {
        implementation 'io.github.aochoae.checkdigit:checkdigit-algorithms:1.0.0'
    }

    repositories {
        mavenLocal()
    }

## Maven local repository

    ./mvnw install -Dmaven.test.skip=true

## Building from Source

Check digit algorithms requires Java 8 or above. To build, use the `package`
task:

    ./mvnw clean package -Dmaven.test.skip=true

## License

Copyright 2020-2021 Luis A. Ochoa

This project is licensed under the Apache License, Version 2.0.
See [LICENSE](LICENSE) for the full license text.
