package tests.cfgCreation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import astnodes.ASTNode;
import cfg.CFG;
import cfg.nodes.ASTNodeContainer;
import cfg.nodes.CFGNode;

public class AssignmentTests extends CFGCreatorTest
{
	@Test
	public void testSingleAssignmentBlockNumber()
	{
		String input = "x = y;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 2);
	}

	@Test
	public void testAssignmentASTLink()
	{
		String input = "x = 10;";
		CFG cfg = getCFGForCode(input);
		CFGNode statement = cfg.getVertices().get(0);
		ASTNode astNode = ((ASTNodeContainer) statement).getASTNode();
		assertTrue(astNode != null);
		System.out.println(astNode.getClass().getSimpleName());
	}

	@Test
	public void testAssignmentInDecl()
	{
		String input = "int x = 10;";
		CFG cfg = getCFGForCode(input);
		assertTrue(cfg.size() == 2);
	}

}
