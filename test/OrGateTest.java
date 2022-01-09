import circuitAPI.Circuit;
import circuitAPI.CircuitFactory;
import circuitAPI.PairInput;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class OrGateTest {

    CircuitFactory factory;
    public OrGateTest() {
        factory = new CircuitFactory() ;
    }

    @Test
    public void testX1orX2Boolean1() throws Exception{

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);

        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(true));
        assertEquals(x1Orx2.getValue(),true);
    }

    @Test
    public void testX1orX2Boolean2() throws Exception{

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);

        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(false));
        assertEquals(x1Orx2.getValue(),true);
    }

    @Test
    public void testX1orX2Boolean3() throws Exception{

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);

        x1.setValue(Boolean.valueOf(false));
        x2.setValue(Boolean.valueOf(true));
        assertEquals(x1Orx2.getValue(),true);
    }

    @Test
    public void testX1orX2Pair1() throws Exception{
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);

        x1.setValue(new PairInput(false, 0.25));
        x2.setValue(new PairInput(false, 0.5));

        PairInput result = (PairInput) x1Orx2.getValue();
        assertEquals(false, result.getInputType());
        assertEquals(0.625, result.getInputValue());
    }

    @Test
    public void testX1orX2Pair2() throws Exception{
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);


        x1.setValue(new PairInput(true, false));
        x2.setValue(new PairInput(true, true));

        PairInput result = (PairInput) x1Orx2.getValue();
        assertEquals(true, result.getInputType());
        assertEquals(true, result.getInputValue());
    }

    @Test
    public void testX1orX2Pair3() throws Exception{
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);


        x1.setValue(new PairInput(true, false));
        x2.setValue(new PairInput(true, true));

        PairInput result = (PairInput) x1Orx2.getValue();
        assertEquals(true, result.getInputType());
        assertEquals(true, result.getInputValue());
    }


    @Test
    public void testX1orX2PairOneZero() throws Exception{
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);


        x1.setValue(new PairInput(false, 1.0));
        x2.setValue(new PairInput(false, 0.0));

        PairInput result = (PairInput) x1Orx2.getValue();
        assertEquals(false, result.getInputType());
        assertEquals(1.0, result.getInputValue());
    }

    @Test
    public void testX1orX2_invalidInputBoolean() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit or = factory.createOr(x1, x2);

        x1.setValue("xxx");
        x2.setValue(Boolean.valueOf(true));

        try {
            or.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("The input type of OR should be Boolean"));
        }
    }

    @Test
    public void testX1orX2_invalidInputStrings() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit or = factory.createOr(x1, x2);

        x1.setValue("xxx");
        x2.setValue("xxx");

        try {
            or.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("The input type of OR should be Boolean"));
        }
    }


    @Test
    public void testX1orX2_invalidInputPairFormat1() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);


        x1.setValue(new PairInput(true, "xxx"));
        x2.setValue(new PairInput(true, true));

        try {
            x1Orx2.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }


    @Test
    public void testX1orX2_invalidInputPairFormat2() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);


        x1.setValue(new PairInput(true, false));
        x2.setValue(new PairInput(true, 1));

        try {
            x1Orx2.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }


    @Test
    public void testX1orX2_invalidInputPairOutOfRange() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);


        x1.setValue(new PairInput(false, 0.5));
        x2.setValue(new PairInput(false, 2.0));

        try {
            x1Orx2.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("Invalid Input Range"));
        }
    }


    @Test
    public void testX1orX2PairOneZeroInvalidInteger() throws Exception{
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);


        x1.setValue(new PairInput(false, 1));
        x2.setValue(new PairInput(false, 0));


        try {
            x1Orx2.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }


    @Test
    public void testX1orX2_invalidPair() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x1Orx2 = factory.createOr(x1, x2);


        x1.setValue(new PairInput(true, 0.5));
        x2.setValue(new PairInput(false, 0.5));

        try {
            x1Orx2.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }
}
