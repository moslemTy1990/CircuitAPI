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
public class AndGate<T extends Object> extends BinaryCircuit<T>{

    protected AndGate(Circuit rCircuit, Circuit lCircuit) {
        super(rCircuit, lCircuit);
    }
    
   @Override
    public T getValue() throws Exception {
        
        if(!(rOperand.getValue() instanceof Boolean) || !(lOperant.getValue() instanceof Boolean))
            throw new Exception("The input type of AND should be Boolean");

        Object value= (Boolean)rOperand.getValue() && (Boolean)lOperant.getValue();
        return (T)value;

    }
    
}
