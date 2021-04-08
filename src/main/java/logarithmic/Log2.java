package logarithmic;

import util.Functions;

public class Log2 extends Ln{
    public Log2(double precision) {
        super(precision);
        this.function = Functions.LOG_2;
        super.setFuncIsStub(true);
    }

    @Override
    public double getFunctionValue(double x){
        return super.getFunctionValue(x) / super.getFunctionValue(2);
    }

    @Override
    public double getStubValue(double x) {
        return super.getStubValue(x) / super.getStubValue(2);
    }
}
