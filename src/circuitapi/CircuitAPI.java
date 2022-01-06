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
        
         
        Circuit and = factory.createAnd(x1, x2);
        
        
        x1.setValue(new Boolean(true));
        x2.setValue(new Boolean(true));
         

        System.out.println(and.getValue().toString());
    }
    
}
