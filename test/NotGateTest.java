
import circuitAPI.Circuit;
import circuitAPI.CircuitFactory;
import circuitAPI.PairInput;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class NotGateTest {
     CircuitFactory factory;
    public NotGateTest() {
        factory = new CircuitFactory() ;
    }

    @Test
    public void testNotX_Case1() throws Exception {

        Circuit x1 = factory.createConstant();

        Circuit not = factory.createNot(x1);

        x1.setValue(Boolean.valueOf(true));

        assertEquals(not.getValue(),false);
    }
    
    @Test
    public void testNotX_Case2() throws Exception {

        Circuit x1 = factory.createConstant();

        Circuit not = factory.createNot(x1);

        x1.setValue(Boolean.valueOf(false));

        assertEquals(not.getValue(),true);
    }
   
    @Test
    public void testNotX_Invalid() throws Exception {

        Circuit x1 = factory.createConstant();

        Circuit not = factory.createNot(x1);

        x1.setValue("xxx");
        try {
            not.getValue();
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("The input type of NOT should be Boolean"));
        }
    }
    
    @Test
    public void testNotX1_PairInputBoolean(){
        Circuit x1 = factory.createConstant();

        Circuit not = factory.createNot(x1);

        PairInput input = new PairInput(true, false);

        x1.setValue(input);

        try {
            PairInput result = (PairInput) not.getValue();
            assertEquals(true, result.getInputType());
            assertEquals(true, result.getInputValue());
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }
    
    @Test
    public void testNotX1_PairInputInvalidInput_Case1(){
        Circuit x1 = factory.createConstant();

        Circuit not = factory.createNot(x1);

        PairInput input = new PairInput(true, "xxx");

        x1.setValue(input);

        try {
            PairInput result = (PairInput) not.getValue();
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }
    
    @Test
    public void testNotX1_PairInputInvalidInput_Case2(){
        Circuit x1 = factory.createConstant();

        Circuit not = factory.createNot(x1);

        PairInput input = new PairInput(false, 2);

        x1.setValue(input);

        try {
            PairInput result = (PairInput) not.getValue();
            
        }
        catch (Exception exception){
            assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }
    
    @Test
    public void testNotNotX1_PairInputBoolean(){
        Circuit x1 = factory.createConstant();

        Circuit not = factory.createNot(x1);
        Circuit notNot = factory.createNot(not);

        PairInput input = new PairInput(true, false);

        x1.setValue(input);

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
    public void testNotNotX1_PairInputInvalidInputBoolean(){
        Circuit x1 = factory.createConstant();

        Circuit not = factory.createNot(x1);
        Circuit notNot = factory.createNot(not);

        PairInput input = new PairInput(true, 4);

        x1.setValue(input);

        try {
            PairInput result = (PairInput) notNot.getValue();
        }
        catch (Exception exception){
           assertThat(exception.getMessage(), is("Invalid Input Type"));
        }
    }
}