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
public class UnaryCircuit<T extends Object> implements Circuit<T>{

    protected Circuit operand;

    public UnaryCircuit(Circuit circuit){
        this.operand = circuit;
    }

    @Override
    public T getValue() throws Exception {
        return null;
    }

    @Override
    public void setValue(T t) {

    }

}
