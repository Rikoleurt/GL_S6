package visitor.syntax;

import visitor.tools.ExpressionVisitor;

public interface Expression {

	/**
	 * Accepts the visitor v and allows it to access the data
	 * @param v the expression visitor
	 */
	public void accept(ExpressionVisitor v);

}
