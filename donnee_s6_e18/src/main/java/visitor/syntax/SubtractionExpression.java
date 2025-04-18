package visitor.syntax;

import visitor.tools.ExpressionVisitor;

public class SubtractionExpression extends ArithmeticExpression {
	
	public SubtractionExpression(Expression left, Expression right) {
		super(left, right);
	}
	
	public void accept(ExpressionVisitor v) {
		v.visitSubtractionExpression(this);
	}

}
