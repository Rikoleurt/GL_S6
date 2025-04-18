package visitor.tools;

import visitor.syntax.*;

public class CalculationVisitor implements ExpressionVisitor {

    protected int result;
    public int getResult() {
        return result;
    }

    @Override
    public void visitConstant(Constant e) {
        result = e.getValue();
    }

    @Override
    public void visitAdditionExpression(AdditionExpression e) {

    }

    @Override
    public void visitSubtractionExpression(SubtractionExpression e) {

    }

    @Override
    public void visitMultiplicationExpression(MultiplicationExpression e) {

    }

    @Override
    public void visitDivisionExpression(DivisionExpression e) {

    }
    
}
