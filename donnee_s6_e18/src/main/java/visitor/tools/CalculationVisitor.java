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
        CalculationVisitor leftVisitor = new CalculationVisitor();
        CalculationVisitor rightVisitor = new CalculationVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        result = leftVisitor.getResult() + rightVisitor.getResult();
    }

    @Override
    public void visitSubtractionExpression(SubtractionExpression e) {
        CalculationVisitor leftVisitor = new CalculationVisitor();
        CalculationVisitor rightVisitor = new CalculationVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        result = leftVisitor.getResult() - rightVisitor.getResult();
    }

    @Override
    public void visitMultiplicationExpression(MultiplicationExpression e) {
        CalculationVisitor leftVisitor = new CalculationVisitor();
        CalculationVisitor rightVisitor = new CalculationVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        result = leftVisitor.getResult() * rightVisitor.getResult();
    }

    @Override
    public void visitDivisionExpression(DivisionExpression e) {
        CalculationVisitor leftVisitor = new CalculationVisitor();
        CalculationVisitor rightVisitor = new CalculationVisitor();

        e.getLeft().accept(leftVisitor);
        e.getRight().accept(rightVisitor);

        if(rightVisitor.getResult() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        result = leftVisitor.getResult() / rightVisitor.getResult();
    }

}
