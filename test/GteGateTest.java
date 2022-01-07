
package test;
import circuitAPI.Circuit;
import circuitAPI.CircuitFactory;
import circuitAPI.PairInput;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

public class GteGateTest {
    CircuitFactory factory;
    public GteGateTest() {
        factory = new CircuitFactory() ;
    }

    @Test
    public void testX1gteX2_PairInputDoubleTrueCondition(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit gte = factory.createGte(x1, x2);

        PairInput input1 = new PairInput(false, 0.6);
        PairInput input2 = new PairInput(false, 0.1);

        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) gte.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(true, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1gteX2_PairInputDoubleFalseCondition(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit gte = factory.createGte(x1, x2);

        PairInput input1 = new PairInput(false, 0.1);
        PairInput input2 = new PairInput(false, 0.6);

        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) gte.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(false, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1gteX1_PairInputDouble(){
        Circuit x1 = factory.createConstant();
        Circuit gte = factory.createGte(x1, x1);

        PairInput input1 = new PairInput(true, 1);
        x1.setValue(input1);


        try {
            PairInput result = (PairInput) gte.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(true, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1gteX2_PairInputOther(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit gte = factory.createGte(x1, x2);

        PairInput input1 = new PairInput(true, "aa");
        PairInput input2 = new PairInput(true, false);

        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) gte.getValue();
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1gteX2_PairInputOther(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit gte = factory.createGte(x1, x2);

        PairInput input1 = new PairInput(true, "aa");
        PairInput input2 = new PairInput(true, false);

        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) gte.getValue();
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }


}

