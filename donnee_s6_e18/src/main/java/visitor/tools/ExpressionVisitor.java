package visitor.tools;

import visitor.syntax.AdditionExpression;
import visitor.syntax.Constant;
import visitor.syntax.DivisionExpression;
import visitor.syntax.MultiplicationExpression;
import visitor.syntax.SubtractionExpression;


public interface ExpressionVisitor {

	/**
	 * The visitor accesses the constant
	 * @param e
	 */
	void visitConstant(Constant e);

	/**
	 * The visitor accesses the addition expression
	 * @param e
	 */
	void visitAdditionExpression(AdditionExpression e);

	/**
	 * The visitor accesses the subtraction expression
	 * @param e
	 */
	void visitSubtractionExpression(SubtractionExpression e);

	/**
	 * The visitor accesses the multiplication expression
	 * @param e
	 */
	void visitMultiplicationExpression(MultiplicationExpression e);

	/**
	 * The visitor accesses the division expression
	 * @param e
	 */
	void visitDivisionExpression(DivisionExpression e);

}
