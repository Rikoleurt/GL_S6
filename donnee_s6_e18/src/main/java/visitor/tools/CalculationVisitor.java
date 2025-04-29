package visitor.tools;

import visitor.syntax.*;

/**
 * {@code CalculationVisitor} implements the {@code ExpressionVisitor} interface and calculates
 * the result of an arithmetic expression. It traverses the expression tree and computes the
 * value based on the operations (addition, subtraction, multiplication, division).
 * <p>
 * This visitor evaluates the expression by recursively visiting the left and right operands
 * of binary expressions, applying the corresponding operation (e.g., addition, subtraction).
 */
public class CalculationVisitor implements ExpressionVisitor {

    protected int result;

    /**
     * Returns the total result of the given expression.
     *
     * @return the result of the expression
     */
    public int getResult() {
        return result;
    }

    /**
     * Visits a {@code Constant} expression and retrieves its value.
     *
     * @param e the constant expression
     */
    @Override
    public void visitConstant(Constant e) {
        result = e.getValue();
    }

    /**
     * Visits an {@code AdditionExpression} and calculates the result by visiting its operands.
     *
     * @param e the addition expression
     */
    @Override
    public void visitAdditionExpression(AdditionExpression e) {
        CalculationVisitor leftVisitor = new CalculationVisitor();
        CalculationVisitor rightVisitor = new CalculationVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        result = leftVisitor.getResult() + rightVisitor.getResult();
    }

    /**
     * Visits a {@code SubtractionExpression} and calculates the result by visiting its operands.
     *
     * @param e the subtraction expression
     */
    @Override
    public void visitSubtractionExpression(SubtractionExpression e) {
        CalculationVisitor leftVisitor = new CalculationVisitor();
        CalculationVisitor rightVisitor = new CalculationVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        result = leftVisitor.getResult() - rightVisitor.getResult();
    }

    /**
     * Visits a {@code MultiplicationExpression} and calculates the result by visiting its operands.
     *
     * @param e the multiplication expression
     */
    @Override
    public void visitMultiplicationExpression(MultiplicationExpression e) {
        CalculationVisitor leftVisitor = new CalculationVisitor();
        CalculationVisitor rightVisitor = new CalculationVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        result = leftVisitor.getResult() * rightVisitor.getResult();
    }

    /**
     * Visits a {@code DivisionExpression} and calculates the result by visiting its operands.
     * If the divisor is zero, an {@code ArithmeticException} is thrown.
     *
     * @param e the division expression
     * @throws ArithmeticException if division by zero occurs
     */
    @Override
    public void visitDivisionExpression(DivisionExpression e) {
        CalculationVisitor leftVisitor = new CalculationVisitor();
        CalculationVisitor rightVisitor = new CalculationVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        if(rightVisitor.getResult() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        result = leftVisitor.getResult() / rightVisitor.getResult();
    }
}
