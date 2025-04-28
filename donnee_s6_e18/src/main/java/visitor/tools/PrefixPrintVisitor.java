package visitor.tools;

import visitor.syntax.*;

import java.beans.Expression;

public class PrefixPrintVisitor implements ExpressionVisitor {

    protected StringBuffer result = new StringBuffer();

    public String getResult() {
        return result.toString();
    }


    @Override
    public void visitConstant(Constant e) {
        result.append(e.getValue());
    }

    @Override
    public void visitAdditionExpression(AdditionExpression e) {
        result.append("< + ");
        e.getLeft().accept(this);
        result.append(" ");
        e.getRight().accept(this);
        result.append(" >");
    }

    @Override
    public void visitSubtractionExpression(SubtractionExpression e) {
        result.append("< - ");
        e.getLeft().accept(this);
        result.append(" ");
        e.getRight().accept(this);
        result.append(" >");
    }

    @Override
    public void visitMultiplicationExpression(MultiplicationExpression e) {
        result.append("< * ");
        e.getLeft().accept(this);
        result.append(" ");
        e.getRight().accept(this);
        result.append(" >");
    }

    @Override
    public void visitDivisionExpression(DivisionExpression e) {
        result.append("< : ");
        e.getLeft().accept(this);
        result.append(" ");
        e.getRight().accept(this);
        result.append(" >");
    }
}
