/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitAPI;

/**
 *
 * @author Renisa, Shyam, Shabnam, Moslem
 */
class NotGate<T extends Object> extends UnaryCircuit<T> {
    protected NotGate(Circuit circuit) {super(circuit);
    }

    @Override
    public T getValue() throws Exception {
        if(operand.getValue() instanceof Boolean ){
            return getValueOfBoolean();
        }
        else if(operand.getValue() instanceof PairInput){
            return getValueOfPairInput();
        }
        else if(!(operand.getValue() instanceof Boolean))
            throw new Exception("The input type of NOT should be Boolean");
        else
            throw new Exception("Invalid Input Type");

    }
    
     private T getValueOfBoolean() throws Exception {
        Object value = ! (Boolean)operand.getValue();
        return (T)value;
    }

    private T getValueOfPairInput() throws Exception {
        Object inputValue = ((PairInput)operand.getValue()).getInputValue();
        Object result = null;

        if(!((PairInput)operand.getValue()).validaPair())
            throw new Exception("Invalid Input Type");

        if(inputValue instanceof Boolean){
            result = ! (Boolean)inputValue;
        }
        else if(inputValue instanceof Double && ((PairInput)operand.getValue()).checkRange()) {
            result = 1 - (Double) inputValue;
        }
        System.out.println(operand.getValue());
       return (T) new PairInput(((PairInput)operand.getValue()).getInputType(), result);
    }
}
