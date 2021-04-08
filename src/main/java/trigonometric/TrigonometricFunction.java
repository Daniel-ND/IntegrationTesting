package trigonometric;

import abstracts.AbstractFunction;
import util.Functions;

public class TrigonometricFunction extends AbstractFunction {
    private Cosecant csc;

    public TrigonometricFunction (double precision){
        super(precision);
        this.function = Functions.TRIG_FN;
        super.setFuncIsStub(true);
        csc = new Cosecant(precision * precision);
    }

    public Cosecant getCsc() {
        return csc;
    }

    @Override
    protected double getFunctionValue(double x) {
        return Math.pow(Math.pow(csc.calculate(x), 2), 3);
    }

    @Override
    public double getStubValue(double x) {
        return Math.pow(Math.pow(csc.getStubValue(x), 2), 3);
    }

}
