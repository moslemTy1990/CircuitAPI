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
public class BinaryCircuit<T> implements Circuit<T>{
    
    protected Circuit lOperant;
    protected Circuit rOperand;
    
    public BinaryCircuit(Circuit rCircuit,Circuit lCircuit){
      this.lOperant = lCircuit;
      this.rOperand = rCircuit;
    }

    @Override
    public T getValue() {
      return null;
    }

    @Override
    public void setValue(T t) {

    }
    
    
}
