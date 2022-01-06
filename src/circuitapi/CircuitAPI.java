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
public class CircuitAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
             
        CircuitFactory factory = new CircuitFactory() ;
        
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);
        
        Circuit or = factory.createOr(x3, and);
        
        Circuit not = factory.createNot(or);
         
        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(true));
        x3.setValue(Boolean.valueOf(false));

        System.out.println(not.getValue());
    }
    
}
