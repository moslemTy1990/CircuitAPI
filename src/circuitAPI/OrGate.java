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
public class OrGate<T extends Object> extends BinaryCircuit<T> {
    protected OrGate(Circuit rCircuit, Circuit lCircuit) {
        super(rCircuit, lCircuit);
    }


    @Override
    public T getValue() throws Exception {
        if(rOperand.getValue() instanceof Boolean || lOperant.getValue() instanceof Boolean){
            return getValueOfBoolean();
        }
        else if(rOperand.getValue() instanceof PairInput && lOperant.getValue() instanceof  PairInput){
            return getValueOfPairInput();
        }
        else if(!(rOperand.getValue() instanceof Boolean) || !(lOperant.getValue() instanceof Boolean))
            throw new Exception("The input type of OR should be Boolean");
        else
            throw new Exception("Invalid Input Type");

    }

    public T getValueOfBoolean() throws Exception {
        Object value= (Boolean)rOperand.getValue() || (Boolean)lOperant.getValue();
        return (T)value;
    }

    public T getValueOfPairInput() throws Exception {
        Object inputValue1 = ((PairInput)rOperand.getValue()).getInputValue();
        Object inputValue2 = ((PairInput)lOperant.getValue()).getInputValue();
        Object result = null;

        if(inputValue1 instanceof Boolean && inputValue2 instanceof Boolean){
            result = getValueOfBoolean();
        }
        else if(inputValue1 instanceof Double && inputValue2 instanceof Double) {
            result = 1 - (1 -(Double) inputValue1) * ((Double) inputValue2);
        }
        return (T) new PairInput(((PairInput)rOperand.getValue()).getInputType(), result);
    }
    
}
