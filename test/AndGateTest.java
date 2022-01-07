import circuitAPI.Circuit;
import circuitAPI.CircuitFactory;
import circuitAPI.PairInput;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AndGateTest {
    CircuitFactory factory;
    public AndGateTest() {
        factory = new CircuitFactory() ;
    }

    @Test
    public void testX1AndX2() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);

        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(true));

        assertEquals(and.getValue(),true);
    }


    @Test
    public void testX1andX2_PairInputBoolean(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);


        PairInput input1 = new PairInput(true, false);
        PairInput input2 = new PairInput(true, true);

        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) and.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(false, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    public void testX1andX2_PairInputDouble() {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);

        PairInput input1 = new PairInput(false, 0.25);
        PairInput input2 = new PairInput(false, 0.5);

        x1.setValue(input1);
        x2.setValue(input2);


        try {
            PairInput result = (PairInput) and.getValue();
            assertEquals(false, result.getInputType());
            assertEquals(0.125, result.getInputValue());
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }


    @Test
    public void testX1andX2_invalidInput() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);

        x1.setValue("xxx");
        x2.setValue(Boolean.valueOf(true));

        try {
            and.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("The input type of AND should be Boolean"));
        }
    }

}
