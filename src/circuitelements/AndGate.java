/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitelements;

import circuitfactory.Circuit;
import javax.swing.text.StyledEditorKit;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.function.BinaryOperator;

/**
 *
 * @author Renisa, Shyam, Shabnam, Moslem
 */
public class AndGate<T extends Object> extends BinaryCircuit<T>{

    public AndGate(Circuit rCircuit, Circuit lCircuit) {
        super(rCircuit, lCircuit);
    }
    
   @Override
    public T getValue() throws Exception {
        
        if(!(rOperand.getValue() instanceof Boolean) || !(lOperant.getValue() instanceof Boolean))
            throw new Exception("The input type of And should be Boolean");

        Object value= (Boolean)rOperand.getValue() && (Boolean)lOperant.getValue();
        return (T)value;

    }
    
}
