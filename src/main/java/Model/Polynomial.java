
package Model;

import Model.Monomial;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Polynomial {

        private Map<Integer, Monomial> polinom; 

        public Polynomial(Map<Integer, Monomial> polinom) {
            this.polinom = polinom;
        }

        public Polynomial() {
            this.polinom = new HashMap<>();
        }
        public Map<Integer, Monomial> getMonomials() {
            return polinom;
        }
        public Polynomial(String input) {
            Map<Integer, Monomial> result = new HashMap<>();
            Pattern pattern = Pattern.compile("((-?\\d+(?=x))?(-?[x])(\\^(-?\\d+))?)|((-?)[x])|(-?\\d+)");

            input = input.replaceAll("\\s", "");
            input = input.replaceAll("\\*", "");

            Matcher matcher = pattern.matcher(input);

            double coefficient = 0;
            int exponent = 0;

            while (matcher.find()) {
                if (matcher.group(3) != null && matcher.group(2) != null) { //the monomial of the form ax^b

                    exponent = (matcher.group(5) != null ? Integer.parseInt(matcher.group(5)) : 1);
                    coefficient = Integer.parseInt(matcher.group(2));
                } else if (matcher.group(3) != null && matcher.group(2) == null) { //the monomial of the form +/-x^b or +/-x
                    if (matcher.group(3).equals("-x")) {
                        coefficient = -1;
                    } else {
                        coefficient = 1;
                    }
                    exponent = (matcher.group(5) != null ? Integer.parseInt(matcher.group(5)) : 1);
                } else if (matcher.group(3) == null && matcher.group(2) == null) { //the constant monomial, without x
                    coefficient = Integer.parseInt(matcher.group());
                }
                result.put(exponent, new Monomial(coefficient, exponent));
                coefficient = 0;
                exponent = 0;
            }
            this.polinom = result;
        }

        public Map<Integer, Monomial> getPolinom() {
            return this.polinom;
        }

        public void setPolinom(Map<Integer, Monomial> polinom) {
            this.polinom = polinom;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            boolean first = true;

            for (Map.Entry<Integer, Monomial> entry : polinom.entrySet()) {
                int exponent = entry.getKey();
                double coefficient = entry.getValue().getCoef();

                if (!first) {
                    if (coefficient >= 0) {
                        stringBuilder.append(" + ");
                    } else {
                        stringBuilder.append(" - ");
                        coefficient = Math.abs(coefficient);
                    }
                } else {
                    first = false;
                }

                if (exponent == 0) {
                    stringBuilder.append(coefficient);
                } else {
                    if (coefficient != 1) {
                        stringBuilder.append(coefficient);
                    }
                    stringBuilder.append("x");
                    if (exponent != 1) {
                        stringBuilder.append("^").append(exponent);
                    }
                }
            }

            if (stringBuilder.length() == 0) {
                stringBuilder.append("0"); // Dacă polinomul este gol
            }

            return stringBuilder.toString();
        }
    }