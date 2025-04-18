package visitor.tools;

import visitor.syntax.AdditionExpression;
import visitor.syntax.Constant;
import visitor.syntax.DivisionExpression;
import visitor.syntax.MultiplicationExpression;
import visitor.syntax.SubtractionExpression;


public interface ExpressionVisitor {
	
	void visitConstant(Constant e);
	
	void visitAdditionExpression(AdditionExpression e);
	
	void visitSubtractionExpression(SubtractionExpression e);
	
	void visitMultiplicationExpression(MultiplicationExpression e);
	
	void visitDivisionExpression(DivisionExpression e);

}
