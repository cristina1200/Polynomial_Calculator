package org.example;

import Logic.OperationImplementation;
import Model.Polynomial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PolynomialTest {
    @Test
    public void addTesti() {
        String s1 = "x^3 - 2x + 16";
        String s2 = "x^2 + 19x+120";
        Polynomial polinom1 = new Polynomial(s1);
        Polynomial polinom2 = new Polynomial(s2);

        Polynomial expectedResult = new Polynomial("x^3 + x^2 +17x +136");
        Polynomial realResult = new OperationImplementation().addition(polinom1, polinom2);

        assertEquals(realResult.toString(), expectedResult.toString());

        Polynomial wrongResult = new Polynomial("x+10");

        assertEquals(realResult.toString(), wrongResult.toString());
    }

    @Test
    public void addTest() {
        String s1 = "+x^3-2x^2+6x^1-5";
        String s2 = "+x^2-1";
        Polynomial pol1 = new Polynomial(s1);
        Polynomial pol2 = new Polynomial(s2);

        Polynomial expectedResult = new Polynomial("+x^3-x^2+6x^1-6");
        Polynomial actualResult = new OperationImplementation().addition(pol1, pol2);

        assertEquals(expectedResult.toString(), actualResult.toString());

        Polynomial wrongResult = new Polynomial("+x^3-x^2+6x^1");
        assertNotEquals(wrongResult.toString(), actualResult.toString());
    }


    @Test
    public void subtractTest() {
        String s1 = "+x^3-2x^2+6x^1-5";
        String s2 = "+x^2-1";
        Polynomial pol1 = new Polynomial(s1);
        Polynomial pol2 = new Polynomial(s2);

        Polynomial expectedResult = new Polynomial("+x^3-3x^2+6x^1-4");
        Polynomial actualResult = new OperationImplementation().subtraction(pol1, pol2);

        assertEquals(expectedResult.toString(), actualResult.toString());

        Polynomial wrongResult = new Polynomial("+3x^3-3x^2+6x^1-4");
        assertNotEquals(wrongResult.toString(), actualResult.toString());
    }


    @Test
    public void subtractTesti() {
        String s1 = "x^3 - 2x + 16";
        String s2 = "x^2 + 19x+120";
        Polynomial polinom1 = new Polynomial(s1);
        Polynomial polinom2 = new Polynomial(s2);

        Polynomial expectedResult = new Polynomial("x^3 + x^2 +17x +136");
        Polynomial realResult = new OperationImplementation().subtraction(polinom1, polinom2);

        assertEquals(realResult.toString(), expectedResult.toString());

        Polynomial wrongResult = new Polynomial("x+10");

        assertEquals(realResult.toString(), wrongResult.toString());
    }


    @Test
    public void multiplyTest() {
        String s1 = "+x^3-2x^2+6x^1-5";
        String s2 = "+x^2-1";
        Polynomial pol1 = new Polynomial(s1);
        Polynomial pol2 = new Polynomial(s2);

        Polynomial expectedResult = new Polynomial("+x^5-2x^4+5x^3-3x^2-6x^1+5");
        Polynomial actualResult = new OperationImplementation().multiplication(pol1, pol2);

        assertEquals(expectedResult.toString(), actualResult.toString());

        Polynomial wrongResult = new Polynomial("+x^5-2x^4+2x^3-3x^2-6x^2+1");
        assertNotEquals(wrongResult.toString(), actualResult.toString());
    }

    @Test
    public void multiplyTesti() {
        String s1 = "x^3 - 2x + 16";
        String s2 = "x^2 + 19x+120";
        Polynomial polinom1 = new Polynomial(s1);
        Polynomial polinom2 = new Polynomial(s2);

        Polynomial expectedResult = new Polynomial("x^3 + x^2 +17x +136");
        Polynomial realResult = new OperationImplementation().multiplication(polinom1, polinom2);

        assertEquals(realResult.toString(), expectedResult.toString());

        Polynomial wrongResult = new Polynomial("x+10");

        assertEquals(realResult.toString(), wrongResult.toString());
    }
    @Test
    public void derivativeTest() {
        String s1 = "+x^3-2x^2+6x^1-5";
        Polynomial pol1 = new Polynomial(s1);

        Polynomial expectedResult = new Polynomial("+3x^2-4x^1+6");
        Polynomial actualResult = new OperationImplementation().derivative(pol1);

        assertEquals(expectedResult.toString(), actualResult.toString());

        Polynomial wrongResult = new Polynomial("+6x^2-4x^1+3");
        assertNotEquals(wrongResult.toString(), actualResult.toString());
    }
    @Test
    public void derivativeTesti() {
        String s1 = "x^3 - 2x + 16";
        Polynomial polinom1 = new Polynomial(s1);

        Polynomial expectedResult = new Polynomial("x^3 + x^2 +17x +136");
        Polynomial realResult = new OperationImplementation().derivative(polinom1);

        assertEquals(realResult.toString(), expectedResult.toString());

        Polynomial wrongResult = new Polynomial("x+10");

        assertEquals(realResult.toString(), wrongResult.toString());
    }

    @Test
    public void integrateTest() {
        String s1 = "+4x^3-6x^2+6x^1-5";
        Polynomial pol1 = new Polynomial(s1);
        String result = "x^4-2.0*x^3+3.0*x^2-5.0*x";

        Polynomial expectedResult = new Polynomial("x^4-2.0*x^3+3.0*x^2-5.0*x");
        Polynomial actualResult = new OperationImplementation().integration(pol1);

        assertEquals(expectedResult.toString(), actualResult.toString());

        Polynomial wrongResult = new Polynomial("x^4-2.0*x^3+3.0*x^2-5.0*x");
        assertNotEquals(wrongResult.toString(), actualResult.toString());
    }
    @Test
    public void integrationTesti() {
        String s1 = "x^3 - 2x + 16";

        Polynomial polinom1 = new Polynomial(s1);


        Polynomial expectedResult = new Polynomial("x^3 + x^2 +17x +136");
        Polynomial realResult = new OperationImplementation().integration(polinom1);

        assertEquals(realResult.toString(), expectedResult.toString());

        Polynomial wrongResult = new Polynomial("x+10");

        assertEquals(realResult.toString(), wrongResult.toString());
    }
}