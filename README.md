# Java to LEGv8 Assembly Compiler

## Project Overview

This project implements a basic compiler that reads a Java source code file and translates it into LEGv8 assembly instructions. The program processes Java code line by line and converts arithmetic operations, conditional statements, and loops into their corresponding assembly equivalents. The generated assembly code is printed to the console.

---

## Features

- **Arithmetic Operations**: Translates simple Java operations like addition and subtraction into LEGv8 assembly instructions (e.g., `ADD`, `ADDI`, `SUB`, `SUBI`).
- **Conditional Statements**: Converts `if`, `if-else` statements to assembly instructions using conditional branches like `B.GE`, `B.LE`, `B.EQ`, etc.
- **Loops**: Translates `for` and `while` loops into their equivalent assembly instructions with appropriate branch and loop constructs.
- **Comment Handling**: Retains comments from the Java code and appends them to the generated assembly instructions.
- **Error Handling**: Detects and handles missing input files with an appropriate error message.
  
