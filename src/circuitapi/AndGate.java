/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitapi;

import java.util.function.BinaryOperator;

/**
 *
 * @author 20215138
 */
public class AndGate<T> extends BinaryCircuit<T>{

    public AndGate(Circuit rCircuit, Circuit lCircuit) {
        super(rCircuit, lCircuit);
    }
    
   @Override
    public T getValue() {
      return new Boolean(rOperand.getValue() && new Boolean(lOperant.getValue());
    }
    
}