package logarithmic;

import abstracts.AbstractFunction;
import util.Functions;

import static java.lang.Double.NaN;

public class Ln extends AbstractFunction {

    public Ln(double precision){
        super(precision);
        this.function = Functions.LN;
        super.setFuncIsStub(true);
    }

    @Override
    protected double getFunctionValue(double x) {
        double result = 0;
        if (x == 0)
            return Double.NEGATIVE_INFINITY;
        else if (x < 0)
            return NaN;

        double member = 1;
        double numerator;
        double multiplier;
        double coef = 1;

        if (x < 1){
            numerator = x-1;
            multiplier= -x+1;
            while (Math.abs( member) > precision){
                member = numerator/coef;
                numerator = numerator*multiplier;
                coef+=1;
                result += member;
            }
        }else{
            numerator = (x-1)/(x+1);
            multiplier = Math.pow((x-1)/(x+1), 2);
            coef = 1;
            while (Math.abs( member) > precision){
                member = 2*numerator/coef;
                numerator = numerator*multiplier;
                coef+=2;
                result += member;
            }
        }
        return result;

    }

    @Override
    protected double getStubValue(double x) {
        return Math.log(x);
    }
}
