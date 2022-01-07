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
        System.out.println(and.getValue());
    }
    @Test
    public void testX1andX2Boolean2() throws Exception{

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Andx2 = factory.createAnd(x1, x2);

        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(false));
        assertEquals(x1Andx2.getValue(),false);
        System.out.println(x1Andx2.getValue());
    }

    @Test
    public void testX1andX2Boolean3() throws Exception{

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Andx2 = factory.createAnd(x1, x2);

        x1.setValue(Boolean.valueOf(false));
        x2.setValue(Boolean.valueOf(true));
        assertEquals(x1Andx2.getValue(),false);
        System.out.println(x1Andx2.getValue());
    }

    @Test
    public void testX1andX2_PairInputBoolean() throws Exception{
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);


        PairInput input1 = new PairInput(true, false);
        PairInput input2 = new PairInput(true, true);

        x1.setValue(input1);
        x2.setValue(input2);


        PairInput result = (PairInput) and.getValue();
        assertEquals(true, result.getInputType());
        assertEquals(false, result.getInputValue());
        System.out.println(result.getInputType() + "," + result.getInputValue());
    }

    @Test
    public void testX1andX2_PairInputBoolean2() throws Exception{
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);


        PairInput input1 = new PairInput(true, true);
        PairInput input2 = new PairInput(true, false);

        x1.setValue(input1);
        x2.setValue(input2);


        PairInput result = (PairInput) and.getValue();
        assertEquals(true, result.getInputType());
        assertEquals(false, result.getInputValue());
        System.out.println(result.getInputType() + "," + result.getInputValue());
    }

    @Test
    public void testX1andX2_PairInputDouble() throws Exception{

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);

        PairInput input1 = new PairInput(false, 0.25);
        PairInput input2 = new PairInput(false, 0.5);

        x1.setValue(input1);
        x2.setValue(input2);

        PairInput result = (PairInput) and.getValue();
        assertEquals(false, result.getInputType());
        assertEquals(0.125, result.getInputValue());
        System.out.println(result.getInputType() + "," + result.getInputValue());
    }

    @Test
    public void testX1andX2PairOneZero() throws Exception{
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Andx2 = factory.createAnd(x1, x2);


        x1.setValue(new PairInput(false, 1.0));
        x2.setValue(new PairInput(false, 0.0));

        PairInput result = (PairInput) x1Andx2.getValue();
        assertEquals(false, result.getInputType());
        assertEquals(0.0, result.getInputValue());
        System.out.println(result.getInputType() + "," + result.getInputValue());
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
            System.out.println(exception.getMessage());
            assertThat(exception.getMessage(), is("The input type of AND should be Boolean"));
        }
    }

    @Test
    public void testX1andX2_invalidInputStrings() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);

        x1.setValue("xxx");
        x2.setValue("xxx");

        try {
            and.getValue();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertThat(exception.getMessage(), is("The input type of AND should be Boolean"));
        }
    }


    @Test
    public void testX1andX2_invalidInputPairFormat1() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1andx2 = factory.createAnd(x1, x2);


        x1.setValue(new PairInput(true, "xxx"));
        x2.setValue(new PairInput(true, true));

        try {
            x1andx2.getValue();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }


    @Test
    public void testX1andX2_invalidInputPairFormat2() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1andx2 = factory.createAnd(x1, x2);


        x1.setValue(new PairInput(true, false));
        x2.setValue(new PairInput(true, 1));

        try {
            x1andx2.getValue();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1andX2_invalidInputPairOutOfRange() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1andx2 = factory.createAnd(x1, x2);


        x1.setValue(new PairInput(false, 0.5));
        x2.setValue(new PairInput(false, 2.0));

        try {
            x1andx2.getValue();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertThat(exception.getMessage(), is("Invalid Input Range"));
        }
    }

    @Test
    public void testX1andX2PairOneZeroInvalidInteger() throws Exception{
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Andx2 = factory.createAnd(x1, x2);


        x1.setValue(new PairInput(false, 1));
        x2.setValue(new PairInput(false, 0));


        try {
            x1Andx2.getValue();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }
}
