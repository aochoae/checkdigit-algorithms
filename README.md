# Check digit algorithms

Algorithms:

* Damm algorithm
* Luhn algorithm
* Verhoeff algorithm

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

Check digit algorithms requires Java 8 or above. To build everything, use the
`package` task:

    ./mvnw clean package -Dmaven.test.skip=true

## License

Copyright 2020 Luis A. Ochoa

This project is licensed under the Apache License, Version 2.0.
See [LICENSE](LICENSE) for the full license text.