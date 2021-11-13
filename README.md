# Amigo

The CSC207 Course project created by the Super Turtle Hackers.

To find the UML file and updated Design Document, navigate to the folder 'phase1' and click on the required file. 

To find the specifications, CRC model, scenario walk-through and progress report, navigate to the folder 'phase0' and click on the required file.

This program has only been tested with JDK 11 (recommended) and 13. It is not guaranteed that any other Java versions will work properly with it.

## Installation
Clone the repository into Android Studio. As of right now, the program can only be run from from the command line (and _not_ from the Android Studio GUI). To run it, set your working directory to the root directory, and type:

`./gradlew run -q --console=plain`

On Windows, simply delete the `./` or change it into `.\` (yeah Windows).

It may take a little longer to run the program for the first time, as the Gradle wrapper needs to download the Gradle distribution and compile the entire project. Subsequent runs should be much faster.
