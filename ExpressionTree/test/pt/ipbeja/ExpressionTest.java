package pt.ipbeja;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {
    @Test
    void name() {
        Expression sum = new Addition(new Value(2.0), new Value(3.0));
        System.out.println(sum.evaluate());

        Expression value = new Value(3.0);
        System.out.println(value.evaluate());



        /* 2 + 4 * 5
                 +
                / \
               2   *
                  / \
                 4   5
        */
        Expression tree = new Addition(new Value(2.0),
                new Multiplication(new Value(4.0),
                        new Value(5.0)
                )
        );

        double result = tree.evaluate();
        assertEquals(22.0, result, 0.00001);
        System.out.println(result);

//        (2+3) * 8 / sqrt(20-4)
        Expression bigExpression = new Division(
                new Multiplication(
                        new Addition(new Value(2.0), new Value(3.0)),
                        new Value(8.0)
                ),
                new Sqrt(
                        new Subtraction(new Value(20.0), new Value(4.0))
                )
        );

        Expression bigExpressionFix = new Multiplication(
                new Addition(
                        new Value(2.0), new Value(3.0)
                ),
                new Division(
                        new Value(8.0), new Sqrt(new Subtraction(new Value(20.0), new Value(4.0)))
                )
        );

        assertEquals(10.0, bigExpression.evaluate(), 0.00001);

        System.out.println(bigExpression.evaluate());
    }
}