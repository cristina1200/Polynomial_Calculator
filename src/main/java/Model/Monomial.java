package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monomial {
    private double coef;
    private int power;

    public Monomial(double coef, int power) {
        this.coef = coef;
        this.power = power;
    }

    public double getCoef() {
        return coef;
    }

    public int getPower() {
        return power;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public void setPower(int power) {
        this.power = power;
    }


   /* @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (coef == 0) {
            return "";
        }

        if (coef == (int) coef) {
            sb.append((int) coef);
        } else {
            sb.append(coef);
        }

        if (power != 0) {
            sb.append("X");
            if (power > 1) {
                sb.append("^").append(power);
            }
        }

        return sb.toString();
    }

    */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Verificăm dacă coeficientul este zero, în acest caz nu afișăm nimic
        if (coef == 0) {
            return "";
        }

        // Afisăm coeficientul
        if (coef == (int) coef) {
            sb.append((int) coef);
        } else {
            sb.append(coef);
        }

        // Verificăm puterea și adăugăm 'X' și '^' doar dacă puterea este diferită de zero
        if (power != 0) {
            sb.append("X");

            // Adăugăm '^' doar dacă puterea este mai mare decât 1
            if (power > 1) {
                sb.append("^").append(power);
            }
        }

        return sb.toString();
    }

}
