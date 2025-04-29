package visitor.tools.tree;

import visitor.syntax.*;
import visitor.tools.ExpressionVisitor;

import javax.swing.tree.DefaultMutableTreeNode;

public class BuildTreeVisitor implements ExpressionVisitor {

    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode current;

    public DefaultMutableTreeNode getTree() {
        return root;
    }

    @Override
    public void visitConstant(Constant e) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Constant: " + e.getValue());
        current.add(node);
    }

    @Override
    public void visitAdditionExpression(AdditionExpression e) {
        visitBinaryExpression("Addition", e);
    }

    @Override
    public void visitSubtractionExpression(SubtractionExpression e) {
        visitBinaryExpression("Subtraction", e);
    }

    @Override
    public void visitMultiplicationExpression(MultiplicationExpression e) {
        visitBinaryExpression("Multiplication", e);
    }

    @Override
    public void visitDivisionExpression(DivisionExpression e) {
        visitBinaryExpression("Division", e);
    }

    /**
     * Creates a new parent node for a binary arithmetic expression
     * and recursively visits its left and right operands.
     *
     * @param label the label for the parent node (e.g., "Addition", "Multiplication")
     * @param e the arithmetic expression to visit
     */
    private void visitBinaryExpression(String label, ArithmeticExpression e) {
        DefaultMutableTreeNode parent = new DefaultMutableTreeNode(label);
        if (root == null) {
            root = parent;
        } else {
            current.add(parent);
        }

        DefaultMutableTreeNode prev = current;
        current = parent;
        e.getLeft().accept(this);
        e.getRight().accept(this);
        current = prev;
    }
}
