package logarithmic;

import util.Functions;

public class Log5 extends Ln{
    public Log5(double precision) {
        super(precision);
        this.function = Functions.LOG_5;
        super.setFuncIsStub(true);
    }

    @Override
    public double getFunctionValue(double x){
        return super.getFunctionValue(x) / super.getFunctionValue(5);
    }

    @Override
    public double getStubValue(double x) {
        return super.getStubValue(x) / super.getStubValue(5);
    }
}
