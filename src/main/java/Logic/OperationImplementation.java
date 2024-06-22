package Logic;

import Model.Monomial;
import Model.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class OperationImplementation implements Operations {

    //----------------------ADDITION (+) ---------------------------

    @Override
    public Polynomial addition(Polynomial P, Polynomial Q) {
        Map<Integer, Monomial> addResult = new HashMap<>();

        // Adding monomials from Polynomial P
        for (Monomial monom : P.getMonomials().values()) {
            addResult.put(monom.getPower(), new Monomial(monom.getCoef(), monom.getPower()));
        }

        // Adding monomials from Polynomial Q
        for (Monomial monom : Q.getMonomials().values()) {
            int searchingPower = monom.getPower();
            if (addResult.containsKey(searchingPower)) {
                double sum = addResult.get(searchingPower).getCoef() + monom.getCoef();
                addResult.get(searchingPower).setCoef(sum);
            } else {
                addResult.put(monom.getPower(), new Monomial(monom.getCoef(), monom.getPower()));
            }
        }

        // Creating the result Polynomial
        Polynomial result = new Polynomial(addResult);

        return result;
    }

    //-------------------------SUBTRACTION (-) ----------------------------
    @Override
    public Polynomial subtraction(Polynomial P, Polynomial Q) {
        // Initialize a map to store the result of subtraction
        Map<Integer, Monomial> subtractResult = new HashMap<>();

        // Adding monomials from Polynomial P to the subtractResult map
        for (Monomial monom : P.getMonomials().values()) {
            subtractResult.put(monom.getPower(), new Monomial(monom.getCoef(), monom.getPower()));
        }

        // Subtracting monomials from Polynomial Q
        for (Monomial monom : Q.getMonomials().values()) {
            int searchingPower = monom.getPower();
            // If monomial with the same power exists in P, subtract the coefficient
            if (subtractResult.containsKey(searchingPower)) {
                double difference = subtractResult.get(searchingPower).getCoef() - monom.getCoef();
                subtractResult.get(searchingPower).setCoef(difference);
            } else { // If monomial with the same power doesn't exist in P, add with negated coefficient
                subtractResult.put(monom.getPower(), new Monomial(-monom.getCoef(), monom.getPower()));
            }
        }

        // Create a new Polynomial using the subtractResult map
        Polynomial result = new Polynomial(subtractResult);

        // Return the result Polynomial
        return result;
    }

    //----------------------------MULTIPLICATION (*)------------------------------
    @Override
    public Polynomial multiplication(Polynomial P, Polynomial Q) {
        Map<Integer, Monomial> multiplicationResult = new HashMap<>();

        for (Monomial monomialP : P.getMonomials().values()) {
            for (Monomial monomialQ : Q.getMonomials().values()) {
                int power = monomialP.getPower() + monomialQ.getPower();
                double coefficient = monomialP.getCoef() * monomialQ.getCoef();

                // If the power exists already in multiplicationResult, add to the existing coefficient
                if (multiplicationResult.containsKey(power)) {
                    coefficient += multiplicationResult.get(power).getCoef();
                }
                multiplicationResult.put(power, new Monomial(coefficient, power));
            }
        }
        Polynomial result = new Polynomial(multiplicationResult);
        return result;
    }

    //-------------------------DERIVATIVE (dv/dx)-----------------------------------
    @Override
    public Polynomial derivative(Polynomial P) {
        Map<Integer, Monomial> derivativeResult = new HashMap<>();

        for (Map.Entry<Integer, Monomial> entry : P.getMonomials().entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();

            // Calculate the derivative of the current monomial
            double derivativeCoefficient = monomial.getCoef() * exponent;
            int derivativeExponent = exponent - 1;

            // If the derivative coefficient is not zero, add it to the result
            if (derivativeCoefficient != 0) {
                derivativeResult.put(derivativeExponent, new Monomial(derivativeCoefficient, derivativeExponent));
            }
        }

        return new Polynomial(derivativeResult);
    }

    // ----------------------------INTEGRATION ------------------------
    @Override
    public Polynomial integration(Polynomial P) {
        Map<Integer, Monomial> integrationResult = new HashMap<>();

        for (Map.Entry<Integer, Monomial> entry : P.getMonomials().entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();

            // Calculate the integration of the current monomial
            double integrationCoefficient = monomial.getCoef() / (exponent + 1);
            int integrationExponent = exponent + 1;

            // Add the integration result to the map
            integrationResult.put(integrationExponent, new Monomial(integrationCoefficient, integrationExponent));
        }

        return new Polynomial(integrationResult);
    }
}
