import circuitAPI.Circuit;
import circuitAPI.CircuitFactory;
import circuitAPI.PairInput;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CombinationalTest {

    CircuitFactory factory;
    public CombinationalTest() {
        factory = new CircuitFactory() ;
    }

    @Test
    public void testX1andX2orX3() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);
        Circuit or = factory.createOr(x3, and);

        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(true));
        x3.setValue(Boolean.valueOf(false));

        assertEquals(or.getValue(),true);
    }

    @Test
    public void testX1AndNotX2OrX3() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();


        Circuit notX2 = factory.createNot(x2);

        Circuit and = factory.createAnd(x1, notX2);
        Circuit or = factory.createOr(x3, and);

        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(true));
        x3.setValue(Boolean.valueOf(false));

        assertEquals(or.getValue(),false);
    }

    @Test
    public void testNotX1andX2OrX3andNotX1() throws Exception {
        // (not(x1 and x2) or x3)and (not x1)
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();


        Circuit notX1 = factory.createNot(x1);

        Circuit X1andX2 = factory.createAnd(x1, x2);

        Circuit NotX1andX2 = factory.createNot(X1andX2);

        Circuit NotX1andX2OrX3 = factory.createOr(NotX1andX2,x3);

        Circuit NotX1andX2OrX3andNotX1 = factory.createOr(NotX1andX2OrX3,notX1);

        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(true));
        x3.setValue(Boolean.valueOf(false));

        assertEquals(NotX1andX2OrX3andNotX1.getValue(),false);
    }


    @Test
    public void testNotX1andX2OrX3andNotX1_invalidInput() throws Exception {

        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();


        Circuit notX1 = factory.createNot(x1);

        Circuit X1andX2 = factory.createAnd(x1, x2);

        Circuit NotX1andX2 = factory.createNot(X1andX2);

        Circuit NotX1andX2OrX3 = factory.createOr(NotX1andX2,x3);

        Circuit NotX1andX2OrX3andNotX1 = factory.createOr(NotX1andX2OrX3,notX1);

        x1.setValue(Boolean.valueOf(true));
        x2.setValue(0);
        x3.setValue(Boolean.valueOf(false));

        try {
            NotX1andX2OrX3andNotX1.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("The input type of AND should be Boolean"));
        }
    }

    @Test
    public void testNotX1andX2_PairInputBoolean(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1,x2);
        Circuit notNot = factory.createNot(and);

        PairInput input1 = new PairInput(true, true);
        PairInput input2 = new PairInput(true, true);

        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) notNot.getValue();

            assertEquals(true, result.getInputType());
            assertEquals(false, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testNotX1andX2_PairInvalidInputBoolean(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1,x2);
        Circuit notNot = factory.createNot(and);

        PairInput input1 = new PairInput(true, true);
        PairInput input2 = new PairInput(true, 0);

        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) notNot.getValue();
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }


    @Test
    public void testNotX1andX2_PairInvalidInputCase2Boolean(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1,x2);
        Circuit notNot = factory.createNot(and);

        PairInput input1 = new PairInput(true, 1);
        PairInput input2 = new PairInput(true, false);

        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) notNot.getValue();
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testNotX1andX2_PairInvalidInputCase3Boolean(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1,x2);
        Circuit notNot = factory.createNot(and);

        PairInput input1 = new PairInput(true, 1);
        PairInput input2 = new PairInput(true, 1);

        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) notNot.getValue();
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testNotX1andX2orX3_PairInputBoolean(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();

        Circuit and = factory.createAnd(x1,x2);
        Circuit notNot = factory.createNot(and);
        Circuit or = factory.createOr(notNot,x3);

        PairInput input1 = new PairInput(true, true);
        PairInput input2 = new PairInput(true, true);
        PairInput input3 = new PairInput(true, true);

        x1.setValue(input1);
        x2.setValue(input2);
        x3.setValue(input3);

        try {
            PairInput result = (PairInput) or.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(true, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }
    @Test
    public void testNotX1andX2orX3_PairInvalidInputBoolean(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();

        Circuit and = factory.createAnd(x1,x2);
        Circuit not = factory.createNot(and);
        Circuit or = factory.createOr(not,x3);

        PairInput input1 = new PairInput(true, true);
        PairInput input2 = new PairInput(true, true);
        PairInput input3 = new PairInput(true, 10);

        x1.setValue(input1);
        x2.setValue(input2);
        x3.setValue(input3);

        try {
            PairInput result = (PairInput) or.getValue();
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1gteX2AndX3_PairInput(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();

        Circuit gte = factory.createGte(x1, x2);
        Circuit and = factory.createAnd(gte, x3);

        PairInput input1 = new PairInput(true, true);
        PairInput input2 = new PairInput(true, true);
        PairInput input3 = new PairInput(false, 1);

        x1.setValue(input1);
        x2.setValue(input2);
        x3.setValue(input3);

        try {
            PairInput result = (PairInput) and.getValue();
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1gteX2AndNotX3_PairInput(){
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();

        Circuit gte = factory.createGte(x1, x2);
        Circuit notX3 = factory.createNot(x3);
        Circuit and = factory.createAnd(gte, notX3);

        PairInput input1 = new PairInput(false, .6);
        PairInput input2 = new PairInput(false, .9);
        PairInput input3 = new PairInput(true, true);

        x1.setValue(input1);
        x2.setValue(input2);
        x3.setValue(input3);

        try {
            PairInput result = (PairInput) and.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(false, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1GteNotX1AndX1_PairInput(){
        //(x1 gte not(x1)) and x1
        Circuit x1 = factory.createConstant();

        Circuit notX1 = factory.createNot(x1);
        Circuit gte = factory.createGte(x1, notX1);
        Circuit and = factory.createAnd(gte, x1);

        PairInput input = new PairInput(false, 0.5);
        x1.setValue(input);

        try {
            PairInput result = (PairInput) and.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(true, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1AndNotX1GteX1_PairInput(){
        //(x1 and not(x1)) gte x1
        Circuit x1 = factory.createConstant();
        Circuit notX1 = factory.createNot(x1);
        Circuit and = factory.createAnd(notX1, x1);

        Circuit gte = factory.createGte(x1, and);

        PairInput input = new PairInput(false, 0.5);
        x1.setValue(input);

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
    public void testX1andX2OrNotX1_1(){
        //(x1 gte not(x1)) and x1
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);
        Circuit notX1 = factory.createNot(x1);
        Circuit or = factory.createOr(and,notX1);

        PairInput input1 = new PairInput(true, true);
        PairInput input2 = new PairInput(true, false);
        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) or.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(false, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }


    @Test
    public void testX1andX2OrNotX1_2(){
        //(x1 gte not(x1)) and x1
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);
        Circuit notX1 = factory.createNot(x1);
        Circuit or = factory.createOr(and,notX1);

        PairInput input1 = new PairInput(true, false);
        PairInput input2 = new PairInput(true, true);
        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) or.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(true, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1andX2OrNotX1_3(){
        //(x1 gte not(x1)) and x1
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);
        Circuit notX1 = factory.createNot(x1);
        Circuit or = factory.createOr(and,notX1);

        PairInput input1 = new PairInput(false, 0.0);
        PairInput input2 = new PairInput(false, 1.0);
        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) or.getValue();
            assertEquals(false, result.getInputType());
            assertEquals(1.0, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }

    @Test
    public void testX1andX2OrNotX1_4(){
        //(x1 gte not(x1)) and x1
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);
        Circuit notX1 = factory.createNot(x1);
        Circuit or = factory.createOr(and,notX1);

        PairInput input1 = new PairInput(false, 0.5);
        PairInput input2 = new PairInput(false, 0.5);
        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) or.getValue();
            assertEquals(false, result.getInputType());
            assertEquals(0.625, result.getInputValue());
        }
        catch (Exception exception){
            System.out.println("error");
        }
    }

    @Test
    public void testX1andX2OrNotX1_5(){
        //(x1 gte not(x1)) and x1
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);
        Circuit notX1 = factory.createNot(x1);
        Circuit or = factory.createOr(and,notX1);

        PairInput input1 = new PairInput(false, 0.0);
        PairInput input2 = new PairInput(false, 2.0);
        x1.setValue(input1);
        x2.setValue(input2);

        try {
            PairInput result = (PairInput) or.getValue();
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Range"));
        }
    }
}