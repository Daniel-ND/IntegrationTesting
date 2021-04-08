import abstracts.AbstractFunction;
import logarithmic.LogarithmicFunction;
import trigonometric.TrigonometricFunction;
import util.Functions;

public class SystemFunction extends AbstractFunction {
    private LogarithmicFunction logFn;
    private TrigonometricFunction trigFn;

    public SystemFunction(double precision){
        super(precision);
        this.function = Functions.SYSTEM;
        super.setFuncIsStub(true);
        logFn = new LogarithmicFunction(precision);
        trigFn = new TrigonometricFunction(precision);
    }

    public LogarithmicFunction getLogarithmicFunction(){
        return logFn;
    }

    public TrigonometricFunction getTrigonometricFunction(){
        return trigFn;
    }

    @Override
    protected double getFunctionValue(double x) {
        if (x <= 0){
            return logFn.calculate(x);
        }
        else
            return trigFn.calculate(x);
    }

    @Override
    protected double getStubValue(double x) {
        if (x <= 0){
            return logFn.getStubValue(x);
        }
        else
            return trigFn.getStubValue(x);
    }
}
