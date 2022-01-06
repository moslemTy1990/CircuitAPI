/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitapi;

/**
 *
 * @author Renisa, Shyam, Shabnam, Moslem
 */
public class CircuitFactory<T> {
    
    public Circuit<T> createAnd(Circuit<T> lCircuit, Circuit<T> rCircuit){
        return new AndGate<T>(lCircuit,rCircuit);
    }
    
    public Circuit createConstant(){
        return new Constant();
    }
      
    public Circuit createNot(Circuit circuit){
         return new NotGate<T>(circuit);
    }
    
    public Circuit createOr(Circuit lCircuit, Circuit rCircuit){
         return new OrGate<T>(lCircuit,rCircuit);
    }    
}
