package visitor.tools;

import visitor.syntax.AdditionExpression;
import visitor.syntax.Constant;
import visitor.syntax.DivisionExpression;
import visitor.syntax.MultiplicationExpression;
import visitor.syntax.SubtractionExpression;

/**
 * {@code PrettyPrintVisitor} implements the {@code ExpressionVisitor} interface and generates
 * a string representation of an arithmetic expression in the infix notation. The visitor
 * traverses the expression tree and prints each operation with its operands in an infix format,
 * enclosed in parentheses.
 * <p>
 * For binary expressions, the operands are printed with the operator in between. For example,
 * an addition expression will be printed as "( A + B )".
 */
public class PrettyPrintVisitor implements ExpressionVisitor {

	protected StringBuffer result = new StringBuffer();

	/**
	 * Returns the generated string representation of the expression in the infix notation.
	 *
	 * @return a string representing the expression
	 */
	public String getResult() {
		return result.toString();
	}

	/**
	 * Visits a {@code Constant} expression and appends its value to the result string.
	 *
	 * @param e the constant expression
	 */
	public void visitConstant(Constant e) {
		result.append(e.getValue());
	}

	/**
	 * Visits an {@code AdditionExpression} and appends its representation in the infix notation.
	 *
	 * @param e the addition expression
	 */
	public void visitAdditionExpression(AdditionExpression e) {
		result.append("( ");
		e.getLeft().accept(this);
		result.append(" + ");
		e.getRight().accept(this);
		result.append(" )");
	}

	/**
	 * Visits a {@code SubtractionExpression} and appends its representation in the infix notation.
	 *
	 * @param e the subtraction expression
	 */
	public void visitSubtractionExpression(SubtractionExpression e) {
		result.append("( ");
		e.getLeft().accept(this);
		result.append(" - ");
		e.getRight().accept(this);
		result.append(" )");
	}

	/**
	 * Visits a {@code MultiplicationExpression} and appends its representation in the infix notation.
	 *
	 * @param e the multiplication expression
	 */
	public void visitMultiplicationExpression(MultiplicationExpression e) {
		result.append("( ");
		e.getLeft().accept(this);
		result.append(" x ");
		e.getRight().accept(this);
		result.append(" )");
	}

	/**
	 * Visits a {@code DivisionExpression} and appends its representation in the infix notation.
	 *
	 * @param e the division expression
	 */
	public void visitDivisionExpression(DivisionExpression e) {
		result.append("( ");
		e.getLeft().accept(this);
		result.append(" : ");
		e.getRight().accept(this);
		result.append(" )");
	}
}
