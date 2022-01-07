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
public class NotGate<T extends Object> extends UnaryCircuit<T> {
    protected NotGate(Circuit circuit) {super(circuit);
    }

    @Override
    public T getValue() throws Exception {
        if(!(operand.getValue() instanceof Boolean))
            throw new Exception("The input type of NOT should be Boolean");

        Object value= !(Boolean)operand.getValue();
        return (T)value;

    }
}
