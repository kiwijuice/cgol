# Conway's Game of Life – Kotlin Implementation

[![Build Status](https://travis-ci.org/kiwijuice/cgol.svg?branch=master)](https://travis-ci.org/kiwijuice/cgol)

## Introduction
This project is a simple [Kotlin](https://kotlinlang.org) implementation for [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).
This project is built with maven. 

To build the project, just run the maven package command.
```
mvn package
```

The project is configured to be packages with dependencies. To run the game run the following command:
```
java -jar target/cgol-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Or just run the project with the exec plugin for maven:
```
mvn package exec:java
```

## Game Visualization
The current implementation uses the console to print the cells (using `print` and `println`).

## Stopping the Game
Once the game started, the cells evolve until you stop the game manually.
To stop the game just click on the `Enter` key.