package trigonometric;

import abstracts.AbstractFunction;
import util.Functions;

public class Sine extends AbstractFunction {

    public Sine(double precision) {
        super(precision);
        this.function = Functions.SIN;
        super.setFuncIsStub(true);
    }

    @Override
    protected double getFunctionValue(double x) {
        double a = x;
        double n = 3;
        double res = 0;
        while (Math.abs(a) > precision){
            res += a;
            a *= (-1) * x * x / (n - 1) / n;
            n += 2;
        }
        return res;
    }

    @Override
    public double getStubValue(double x) {
        return Math.sin(x);
    }
}
