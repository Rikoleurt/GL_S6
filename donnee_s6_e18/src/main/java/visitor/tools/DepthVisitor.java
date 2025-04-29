package visitor.tools;

import visitor.syntax.*;

/**
 * {@code DepthVisitor} implements the {@code ExpressionVisitor} interface and calculates
 * the depth of an arithmetic expression. The depth is defined as the maximum number of
 * nested operations in the expression.
 * <p>
 * This visitor traverses the left and right sub-expressions of binary expressions and
 * calculates their respective depths, returning the maximum depth plus one for the current operation.
 */
public class DepthVisitor implements ExpressionVisitor {

    protected int result;

    /**
     * Returns the calculated depth of the expression.
     *
     * @return the depth of the expression
     */
    public int getResult() {
        return result;
    }

    /**
     * Visits a {@code Constant} expression and sets its depth to 1.
     *
     * @param e the constant expression
     */
    @Override
    public void visitConstant(Constant e) {
        result = 1;
    }

    /**
     * Visits an {@code AdditionExpression} and calculates the depth by visiting its operands.
     *
     * @param e the addition expression
     */
    @Override
    public void visitAdditionExpression(AdditionExpression e) {
        visitBinaryExpression(e);
    }

    /**
     * Visits a {@code SubtractionExpression} and calculates the depth by visiting its operands.
     *
     * @param e the subtraction expression
     */
    @Override
    public void visitSubtractionExpression(SubtractionExpression e) {
        visitBinaryExpression(e);
    }

    /**
     * Visits a {@code MultiplicationExpression} and calculates the depth by visiting its operands.
     *
     * @param e the multiplication expression
     */
    @Override
    public void visitMultiplicationExpression(MultiplicationExpression e) {
        visitBinaryExpression(e);
    }

    /**
     * Visits a {@code DivisionExpression} and calculates the depth by visiting its operands.
     *
     * @param e the division expression
     */
    @Override
    public void visitDivisionExpression(DivisionExpression e) {
        visitBinaryExpression(e);
    }

    /**
     * Helper method to visit binary expressions (those with left and right operands) and
     * calculate their depth by visiting both operands.
     *
     * @param e the binary arithmetic expression
     */
    private void visitBinaryExpression(ArithmeticExpression e) {
        DepthVisitor leftVisitor = new DepthVisitor();
        DepthVisitor rightVisitor = new DepthVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        result = 1 + Math.max(leftVisitor.getResult(), rightVisitor.getResult());
    }
}
