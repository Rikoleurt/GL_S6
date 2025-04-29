package visitor.tools.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class BuildTreeViewer {

    public static void displayTrees(DefaultMutableTreeNode tree1, DefaultMutableTreeNode tree2) {
        JFrame frame = new JFrame("Visitor Expression Trees");

        JTree jTree1 = new JTree(tree1);
        JTree jTree2 = new JTree(tree2);

        JScrollPane scrollPane1 = new JScrollPane(jTree1);
        JScrollPane scrollPane2 = new JScrollPane(jTree2);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1, scrollPane2);
        splitPane.setResizeWeight(0.5);

        frame.add(splitPane);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
