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
public class CircuitFactory<T> {
    public Circuit<T> createAnd(Circuit<T> lCircuit, Circuit<T> rCircuit){
        Circuit<T> andCircuit = new AndGate<T>(lCircuit,rCircuit);
        return andCircuit;
    }
    
    public Circuit createConstant(){
        return null;
    }
      
    public Circuit createNot(Circuit circuit){
        return null;
    }
    
    public Circuit createOr(Circuit lCircuit, Circuit rCircuit){
        return null;
    }
    
    
}
