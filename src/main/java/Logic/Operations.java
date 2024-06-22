package Logic;
import Model.Polynomial;

import java.util.Map;

public interface Operations {
    public Polynomial addition(Polynomial P, Polynomial Q);
    public Polynomial subtraction(Polynomial P, Polynomial Q);
    public Polynomial multiplication(Polynomial P, Polynomial Q);
    // public Polynomial division(Polynomial P, Polynomial Q);
    public Polynomial derivative(Polynomial P);
    public Polynomial integration(Polynomial P);
    // public Polinom[] impartire(Polinom P,Polinom Q) throws ArithmeticException;

}
