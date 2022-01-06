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
public class NotGate<T extends Object> extends UnaryCircuit<T> {
    public NotGate(Circuit circuit) {super(circuit);
    }

    @Override
    public T getValue() {
        Object value;
        if(operand.getValue() instanceof Boolean){
            value = (!(Boolean) operand.getValue());
            return (T)(value);
        }else if(operand.getValue() instanceof Integer){
            if(operand.getValue() == 1){

            }
        }
        return null;
    }
}
