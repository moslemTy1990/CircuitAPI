/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitAPI;

import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Renisa, Shyam, Shabnam, Moslem
 */
class AndGate<T extends Object> extends BinaryCircuit<T>{

    protected AndGate(Circuit rCircuit, Circuit lCircuit) {
        super(rCircuit, lCircuit);
    }


    @Override
    public T getValue() throws Exception {
        if(rOperand.getValue() instanceof Boolean && lOperant.getValue() instanceof Boolean){
            return getValueOfBoolean();
        }
        else if(rOperand.getValue() instanceof PairInput && lOperant.getValue() instanceof  PairInput
                && ((PairInput) rOperand.getValue()).validPairs((PairInput)lOperant.getValue())){
            return getValueOfPairInput();
        }
        else if((!(rOperand.getValue() instanceof PairInput) && !(lOperant.getValue() instanceof PairInput)) &&
                (!(rOperand.getValue() instanceof Boolean) || !(lOperant.getValue() instanceof Boolean)))
            throw new Exception("The input type of AND should be Boolean");
        else
            throw new Exception("Invalid Input Type");

    }

    private T getValueOfBoolean() throws Exception {
        Object value= (Boolean)rOperand.getValue() && (Boolean)lOperant.getValue();
        return (T)value;
    }

    private T getValueOfPairInput() throws Exception {
        Object inputValue1 = ((PairInput)rOperand.getValue()).getInputValue();
        Object inputValue2 = ((PairInput)lOperant.getValue()).getInputValue();
        Object result = null;

        if(!((PairInput)rOperand.getValue()).validaPair() || !((PairInput)lOperant.getValue()).validaPair())
            throw new Exception("Invalid Input Type");

        if(inputValue1 instanceof Boolean && inputValue2 instanceof Boolean){
            result = (Boolean)inputValue1 && (Boolean)inputValue2;
        }
        else if(inputValue1 instanceof Double && inputValue2 instanceof Double
                && ((PairInput)rOperand.getValue()).checkRange() && ((PairInput)lOperant.getValue()).checkRange()) {
            result = (Double) inputValue1 * (Double) inputValue2;
        }

        return (T) new PairInput(((PairInput)rOperand.getValue()).getInputType(), result);
    }
}
