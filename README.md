# Conway's Game of Life – Kotlin Implementation

[![Build Status](https://travis-ci.org/kiwijuice/cgol.svg?branch=master)](https://travis-ci.org/kiwijuice/cgol)

## Introduction
This project is a simple [Kotlin](https://kotlinlang.org) implementation for [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).
This project is built with maven. To run the project clone the repo, and run the following maven command:
```
mvn package exec:java
```

## Game Visualization
The current implementation uses the console to print the cells (using `print` and `println`).