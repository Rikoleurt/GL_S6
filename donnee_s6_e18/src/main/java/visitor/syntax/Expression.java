package visitor.syntax;

import visitor.tools.ExpressionVisitor;

public interface Expression {

	/**
	 * Accepts the visitor v to access the data
	 * @param v
	 */
	public void accept(ExpressionVisitor v);

}
