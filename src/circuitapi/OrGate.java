/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitapi;

/**
 *
 * @author 20215138
 */
public class OrGate<T extends Object> extends BinaryCircuit<T> {
    public OrGate(Circuit rCircuit, Circuit lCircuit) {
        super(rCircuit, lCircuit);
    }

    @Override
    public T getValue() {
        Object value= (Boolean)rOperand.getValue() || (Boolean)lOperant.getValue();
        return (T)value;

    }
    
}
