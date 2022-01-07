import circuitAPI.Circuit;
import circuitAPI.CircuitFactory;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrGateTest {

    CircuitFactory factory;
    public OrGateTest() {
        factory = new CircuitFactory() ;
    }

    @Test
    public void testX1orX2_invalidInput() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createOr(x1, x2);

        x1.setValue("xxx");
        x2.setValue(Boolean.valueOf(true));

        try {
            and.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("The input type of OR should be Boolean"));
        }
    }
}
