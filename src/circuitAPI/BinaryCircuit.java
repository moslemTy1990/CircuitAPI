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
class BinaryCircuit<T extends Object> implements Circuit<T>{
    
    protected Circuit lOperant;
    protected Circuit rOperand;

    protected BinaryCircuit(Circuit lCircuit,Circuit rCircuit){
      this.lOperant = lCircuit;
      this.rOperand = rCircuit;
    }

    @Override
    public T getValue() throws Exception {
      return null;
    }

    @Override
    public void setValue(T t) {

    }
    
    
}
