package pt.ipbeja;

/**
 * Multiplication is a binary operation
 * 
 * @author Joao Paulo Barros
 * @version 2005/04/30
 */
public class Multiplication extends BinaryOperation
{
	public Multiplication(Expression left, Expression right)
	{
	    super(left, right);
	}
	
	public double evaluate()
	{
		return this.getLeft().evaluate() * this.getRight().evaluate();
	}
}
