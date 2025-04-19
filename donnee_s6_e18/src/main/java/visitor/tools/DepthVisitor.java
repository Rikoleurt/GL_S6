package visitor.tools;

import visitor.syntax.*;

public class DepthVisitor implements ExpressionVisitor {

    protected int result;

    public int getResult() {
        return result;
    }

    @Override
    public void visitConstant(Constant e) {
        result = 1;
    }

    @Override
    public void visitAdditionExpression(AdditionExpression e) {
        visitBinaryExpression(e);
    }

    @Override
    public void visitSubtractionExpression(SubtractionExpression e) {
        visitBinaryExpression(e);
    }

    @Override
    public void visitMultiplicationExpression(MultiplicationExpression e) {
        visitBinaryExpression(e);
    }

    @Override
    public void visitDivisionExpression(DivisionExpression e) {
        visitBinaryExpression(e);
    }

    private void visitBinaryExpression(ArithmeticExpression e) {
        DepthVisitor leftVisitor = new DepthVisitor();
        DepthVisitor rightVisitor = new DepthVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        result = 1 + Math.max(leftVisitor.getResult(), rightVisitor.getResult());
    }
}
