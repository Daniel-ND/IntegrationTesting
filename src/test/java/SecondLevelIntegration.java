import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Second level integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecondLevelIntegration {
    final double PRECISION = 0.00001;
    SystemFunction function;

    @BeforeAll
    public void setUp(){
        function = new SystemFunction(PRECISION);
        function.setFuncIsStub(false);
        function.getLogarithmicFunction().setFuncIsStub(false);
        function.getTrigonometricFunction().setFuncIsStub(false);
        function.getTrigonometricFunction().getCsc().setFuncIsStub(false);
        function.getTrigonometricFunction().getCsc().getSin().setFuncIsStub(false);
        function.getLogarithmicFunction().getLn().setFuncIsStub(false);
        function.getLogarithmicFunction().getLog2().setFuncIsStub(false);
        function.getLogarithmicFunction().getLog5().setFuncIsStub(false);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -1.75, -Math.PI/2, -0.5, 0.0, 0.5, 1.0, 1.5})
    public void testIntegration(double x){
        double expected = function.getStubValue(x);
        double actual = function.calculate(x);
        assertEquals(expected, actual, PRECISION);
    }

    @AfterAll
    public void tearDown(){
        try {
            CSVWriter.printToFile(function,-5.0, 0.1, 100, "secondLevelIntegration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
