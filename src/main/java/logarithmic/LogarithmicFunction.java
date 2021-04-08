package logarithmic;

import abstracts.AbstractFunction;
import util.Functions;

import static java.lang.Double.NaN;

public class LogarithmicFunction extends AbstractFunction {
    private Ln ln;
    private Log5 log5;
    private Log2 log2;

    public LogarithmicFunction(double precision) {
        super(precision);
        this.function = Functions.LOG_FN;
        super.setFuncIsStub(true);
        ln = new Ln(precision * precision);
        log5 = new Log5(precision * precision);
        log2 = new Log2(precision * precision);
    }

    public Ln getLn() {
        return ln;
    }

    public Log5 getLog5() {
        return log5;
    }

    public Log2 getLog2() {
        return log2;
    }

    @Override
    protected double getFunctionValue(double x) {
        if(Math.abs(x - 1) < precision)
            return NaN;

        return (Math.pow(log5.calculate(x) / log5.calculate(x) * ln.calculate(x), 2) / ln.calculate(x))
                / (ln.calculate(x) * log2.calculate(x) / ln.calculate(x));
    }

    @Override
    public double getStubValue(double x) {
        if(Math.abs(x - 1) < precision)
            return NaN;

        return (Math.pow(log5.calculate(x) / log5.calculate(x) * ln.calculate(x), 2) / ln.calculate(x))
                / (ln.calculate(x) * log2.calculate(x) / ln.calculate(x));
    }
}
