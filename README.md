# Check digit algorithms

Algorithms:

* Damm algorithm
* Luhn algorithm
* Verhoeff algorithm

## Getting started

We need to create a Java file to contain the following code:

    package demo;

    import dev.luisalberto.checkdigit.CheckDigit;
    import dev.luisalberto.checkdigit.luhn.LuhnCheckDigit;

    public class App {
    
        public static void main(String args[]) {
 
            CheckDigit checkDigit = new LuhnCheckDigit();

            System.out.println(checkDigit.generate("4872148"));

        }
    }


## Declare dependencies

Add the following dependency to your project:

### Gradle

    dependencies {
        implementation 'dev.luisalberto.checkdigit:checkdigit-algorithms:1.0.0'
    }

    repositories {
        maven {
            url  "https://dl.bintray.com/luisalberto/mvn" 
        }
    }

## Building from Source

Check digit algorithms requires Java 8 or above. To build, use the `package`
task:

    ./mvnw clean package -Dmaven.test.skip=true

## License

Copyright 2020 Luis A. Ochoa

This project is licensed under the Apache License, Version 2.0.
See [LICENSE](LICENSE) for the full license text.