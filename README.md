# Exercise 11 - BiCardSource Unit Testing

This project implements Exercise 11 from *Introduction to Software Design with Java* (Chapter 5 practice exercises).

## Goal

Write JUnit 5 tests for every public method of `BiCardSource`, use stubs to isolate the UUT, and obtain 100% branch coverage.

## Important observation about the exercise code

The code printed in the exercise contains a logic mismatch in `draw()`:

- Contract: draw from source 1 when source 1 is not empty; otherwise draw from source 2.
- Printed implementation: calls source 2 in the first branch and source 1 in the `else` branch.

The compiled `BiCardSource.java` in this project contains the corrected implementation. The original version is preserved in `docs/BiCardSourceOriginal.java.txt` for explanation/reporting.

## Project structure

```text
Exercise11-BiCardSource/
├─ pom.xml
├─ README.md
├─ docs/
│  └─ BiCardSourceOriginal.java.txt
├─ scripts/
│  └─ verify-main.ps1
└─ src/
   ├─ main/java/exercise11/
   │  ├─ Card.java
   │  ├─ CardSource.java
   │  └─ BiCardSource.java
   └─ test/java/exercise11/
      ├─ StubCardSource.java
      └─ BiCardSourceTest.java
```

## Run tests

Requirements: JDK 21 and Maven 3.9+.

```powershell
cd "Exercise11-BiCardSource"
mvn clean test
```

Expected: **5 tests, 0 failures**.

## Generate and enforce coverage

```powershell
mvn clean verify
start target\site\jacoco\index.html
```

The JaCoCo rule is configured so the build fails unless `exercise11.BiCardSource` reaches **100% branch coverage** and **100% line coverage**.

## Why five tests?

`draw()` needs both outcomes of `if (!aSource1.isEmpty())`.

`isEmpty()` uses `aSource1.isEmpty() && aSource2.isEmpty()`. Because Java short-circuits `&&`, three situations are needed:

1. source 1 is not empty -> first condition is false; source 2 is not evaluated.
2. source 1 is empty, source 2 is not empty -> second condition is false.
3. both sources are empty -> second condition is true.

Together, the five tests exercise every relevant branch while the stubs keep the test independent from any real deck implementation.
