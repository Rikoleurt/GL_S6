package visitor.syntax;

import visitor.tools.ExpressionVisitor;

/**
 * {@code ArithmeticExpression} is an abstract class representing an arithmetic expression
 * consisting of two operands (left and right). This class is the base for concrete
 * arithmetic expressions such as addition, subtraction, multiplication, and division.
 * <p>
 * It contains two operands and provides getter methods to access them. The class also defines
 * the {@code accept} method for the Visitor design pattern, allowing visitors to perform
 * operations on the expression.
 */
public abstract class ArithmeticExpression implements Expression {

	private Expression left;

	private Expression right;

	/**
	 * An arithmetic expression (addition, subtraction, division, multiplication)
	 * @param left the left operand
	 * @param right the right operand
	 */
	protected ArithmeticExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	/**
	 * Getter method that returns the left operand.
	 * @return the left operand
	 */
	public Expression getLeft() {
		return left;
	}

	/**
	 * Getter method that returns the right operand.
	 * @return the right operand
	 */
	public Expression getRight() {
		return right;
	}

	/**
	 * Accepts a visitor v and allows it to access the data.
	 * @param v the expression visitor
	 */
	public abstract void accept(ExpressionVisitor v);

}
