package trigonometric;

import abstracts.AbstractFunction;
import util.Functions;

import static java.lang.Double.*;

public class Cosecant extends AbstractFunction {
    private Sine sin;

    public Cosecant(double precision) {
        super(precision);
        this.function = Functions.CSC;
        sin = new Sine(precision * precision);
    }

    public Sine getSin() {
        return sin;
    }

    @Override
    protected double getFunctionValue(double x) {
        double sinValue = sin.calculate(x);
        if (isNaN(x) || isInfinite(x)) {
            return NaN;
        }
        if (x == Math.PI) {
            return Double.NEGATIVE_INFINITY;
        }
        if (x == 0.0) {
            return Double.POSITIVE_INFINITY;
        }
        System.out.println("not stub csc" + x + " " + 1 / sinValue);
        return 1 / sinValue;
    }

    @Override
    protected double getStubValue(double x) {
        if (Math.abs(x % Math.PI) == Math.PI) {
            return Double.NEGATIVE_INFINITY;
        }
        if (Math.abs(x % Math.PI) == 0.0) {
            return Double.POSITIVE_INFINITY;
        } else {
            System.out.println("not stub csc" + x + " " + 1 / Math.sin(x));
            return 1 / Math.sin(x);
        }
    }
}
