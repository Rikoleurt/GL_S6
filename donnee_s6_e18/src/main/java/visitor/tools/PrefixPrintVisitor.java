package visitor.tools;

import visitor.syntax.*;

/**
 * {@code PrefixPrintVisitor} implements the {@code ExpressionVisitor} interface and generates
 * a string representation of an arithmetic expression in prefix notation. The visitor traverses
 * the expression tree and prints each operation with its operands in the prefix format.
 * <p>
 * For binary expressions, the operator is placed before its operands. For example, an addition
 * expression will be printed as "< + A B >".
 */
public class PrefixPrintVisitor implements ExpressionVisitor {

    protected StringBuffer result = new StringBuffer();

    /**
     * Returns the generated string representation of the expression in prefix notation.
     *
     * @return the prefix notation of the expression
     */
    public String getResult() {
        return result.toString();
    }

    /**
     * Visits a {@code Constant} expression and appends its value to the result string.
     *
     * @param e the constant expression
     */
    @Override
    public void visitConstant(Constant e) {
        result.append(e.getValue());
    }

    /**
     * Visits an {@code AdditionExpression} and appends its representation in prefix notation.
     *
     * @param e the addition expression
     */
    @Override
    public void visitAdditionExpression(AdditionExpression e) {
        result.append("< + ");
        e.getLeft().accept(this);
        result.append(" ");
        e.getRight().accept(this);
        result.append(" >");
    }

    /**
     * Visits a {@code SubtractionExpression} and appends its representation in prefix notation.
     *
     * @param e the subtraction expression
     */
    @Override
    public void visitSubtractionExpression(SubtractionExpression e) {
        result.append("< - ");
        e.getLeft().accept(this);
        result.append(" ");
        e.getRight().accept(this);
        result.append(" >");
    }

    /**
     * Visits a {@code MultiplicationExpression} and appends its representation in prefix notation.
     *
     * @param e the multiplication expression
     */
    @Override
    public void visitMultiplicationExpression(MultiplicationExpression e) {
        result.append("< * ");
        e.getLeft().accept(this);
        result.append(" ");
        e.getRight().accept(this);
        result.append(" >");
    }

    /**
     * Visits a {@code DivisionExpression} and appends its representation in prefix notation.
     *
     * @param e the division expression
     */
    @Override
    public void visitDivisionExpression(DivisionExpression e) {
        result.append("< : ");
        e.getLeft().accept(this);
        result.append(" ");
        e.getRight().accept(this);
        result.append(" >");
    }
}
