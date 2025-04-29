# GL_S6 - Condrea Jason, Roellinger Alexandre

# Visitor Pattern - Arithmetic Expressions

## Project Overview

This project demonstrates the use of the **Visitor Design Pattern** to operate on **arithmetic expressions** without modifying their class structures. The goal is to separate the representation of expressions from the operations performed on them, such as printing, calculating values, and measuring their depth.

## Implemented Design Patterns

- **Visitor Pattern**: Enables adding new operations (like pretty-printing, calculation, etc.) to expression classes without altering their internal structure.

## Key Features Implemented

- **Expression Classes**:
    - `ArithmeticExpression`: An abstract class representing binary operations with a left and right operand.
    - Concrete classes:
        - `AdditionExpression`
        - `SubtractionExpression`
        - `MultiplicationExpression`
        - `DivisionExpression`
        - `Constant` (represents a constant value)

Each expression implements an `accept(ExpressionVisitor v)` method to allow visitors to perform operations on them.

- **Visitor Classes**:
    - `PrettyPrintVisitor`: Produces a readable infix representation of the expression, with parentheses.
    - `PrefixPrintVisitor`: Produces a prefix notation  of the expression.
    - `CalculationVisitor`: Evaluates the numerical result of the expression, handling arithmetic operations and division by zero.
    - `DepthVisitor`: Calculates the depth of the expression tree, where depth means the number of nested operations.
    - `BuildTreeVisitor`: Constructs a `DefaultMutableTreeNode` structure representing the expression, allowing it to be displayed graphically as a tree using a `JTree`.

## How It Works

Each concrete expression class implements the `accept` method, which calls the corresponding `visit` method of the visitor. Visitors encapsulate operations applied to the expressions:

- The visitors traverse the expression tree recursively.
- For binary expressions (addition, subtraction, etc.), visitors first process the left and right sub-expressions.
- The visitors combine the results (either by string concatenation, numeric computation, or depth measurement).


# Iterator Pattern - Matrix Traversal

## Project Overview

This project demonstrates the use of the **Iterator Design Pattern** to traverse a two-dimensional matrix in different orders without exposing its internal structure. The project implements two different iterators: one traversing row by row, and one column by column.

## Key Features Implemented

- **Concrete Iterators**:
    - `RowColumnIterator`:
        - Traverses the matrix row by row.
        - `next()` increments the current column index.
        - If the end of a row is reached, it resets the column index to 0 and moves to the next row.
        - `isDone()` returns true if the current position is outside the matrix bounds.
        - `currentItem()` returns the current element at `[currentRow][currentColumn]`.

    - `ColumnRowIterator`:
        - Traverses the matrix column by column.
        - `next()` increments the current row index.
        - If the end of a column is reached, it resets the row index to 0 and moves to the next column.
        - `isDone()` returns true if the current row or column is outside the matrix bounds.
        - `currentItem()` returns the current element at `[currentRow][currentColumn]`.

## How It Works

Each iterator maintains two indices (`currentRow` and `currentColumn`) and updates them according to the desired traversal order.

