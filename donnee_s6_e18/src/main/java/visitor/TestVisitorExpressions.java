package visitor;

import visitor.syntax.AdditionExpression;
import visitor.syntax.Constant;
import visitor.syntax.DivisionExpression;
import visitor.syntax.Expression;
import visitor.syntax.MultiplicationExpression;
import visitor.syntax.SubtractionExpression;
import visitor.tools.*;
import visitor.tools.tree.BuildTreeViewer;
import visitor.tools.tree.BuildTreeVisitor;

import java.util.logging.*;

public class TestVisitorExpressions {
	
	private static Logger loggingService = Logger.getLogger("VisitorTest");

	public static void main(String[] args) {
		
		Expression mye1 = new SubtractionExpression(
				new Constant(10),
				new Constant(6));
		
		Expression mye2 = new AdditionExpression(
				new DivisionExpression(
						new Constant(50),
						new Constant(2)),
				new SubtractionExpression(
						new MultiplicationExpression(
								new Constant(2),
								mye1),
						new Constant(17)));
		
		Expression mye3 = new SubtractionExpression(
				new MultiplicationExpression(
						new Constant(3),
						new Constant(7)),
				new MultiplicationExpression(
						new Constant(5),
						mye2));
		
		Expression mye4 = new DivisionExpression(
				new DivisionExpression(
						new Constant(16),
						new Constant(2)),
				new Constant(4));
		
		Expression myExample1 = new AdditionExpression(
				mye3,
				mye4);
		
		Expression myExample2 = new DivisionExpression(
				new Constant(12),
				new SubtractionExpression(
						new AdditionExpression(
								new Constant(5),
								new Constant(2)),
						new MultiplicationExpression(
								new Constant(2),
								new Constant(2))));
		
		PrettyPrintVisitor v1 = new PrettyPrintVisitor();
		PrefixPrintVisitor v2 = new PrefixPrintVisitor();
		CalculationVisitor v3 = new CalculationVisitor();
		DepthVisitor v4 = new DepthVisitor();
		
		// myExample1
		myExample1.accept(v1);
		myExample1.accept(v2);
		myExample1.accept(v3);
		myExample1.accept(v4);
		
		loggingService.info("---------------------------- Example 1 ----------------------------");

		loggingService.info(v1.getResult());
		loggingService.info(v2.getResult());
		loggingService.info("Result : " + v3.getResult());
		loggingService.info("Depth : " + v4.getResult());

		// myExample2
                // It is necessary to create a new visitor because of its string buffer,
                // which still contains the previous result. This step is only needed for the 
                // PrettyPrintVisitor and PrefixPrintVisitor.
                v1 = new PrettyPrintVisitor();
				v2 = new PrefixPrintVisitor();
		myExample2.accept(v1);
		myExample2.accept(v2);
		myExample2.accept(v3);
		myExample2.accept(v4);

		loggingService.info("---------------------------- Example 2 ----------------------------");

		loggingService.info(v1.getResult());
		loggingService.info(v2.getResult());
		loggingService.info("Result : " + v3.getResult());
		loggingService.info("Depth : " + v4.getResult());


		BuildTreeVisitor bt1 = new BuildTreeVisitor();
		myExample1.accept(bt1);

		BuildTreeVisitor bt2 = new BuildTreeVisitor();
		myExample2.accept(bt2);

		BuildTreeViewer.displayTrees(bt1.getTree(), bt2.getTree());


	}

}
