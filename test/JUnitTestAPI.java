/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import circuitfactory.Circuit;
import circuitfactory.CircuitFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renisa, Shyam, Shabnam, Moslem
 */
public class JUnitTestAPI {
      CircuitFactory factory;
    public JUnitTestAPI() {
           factory = new CircuitFactory() ;
    }

     @Test  
     public void testX1andX2() throws Exception {
         
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);
         
        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(true));

        assertEquals(and.getValue(),true);
     }
     
     @Test
     public void testX1andX2orX3() throws Exception {
         
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();
        
        Circuit and = factory.createAnd(x1, x2);
        Circuit or = factory.createOr(x3, and);
         
        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(true));
        x3.setValue(Boolean.valueOf(false));

        assertEquals(or.getValue(),true);    
     }
     
     
     @Test
     public void testX1andNotX2orX3() throws Exception {
         
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();
        Circuit x3 = factory.createConstant();
        
       
        Circuit notX2 = factory.createNot(x2);
        
        Circuit and = factory.createAnd(x1, notX2);
        Circuit or = factory.createOr(x3, and);
         
        x1.setValue(Boolean.valueOf(true));
        x2.setValue(Boolean.valueOf(true));
        x3.setValue(Boolean.valueOf(false));

        assertEquals(or.getValue(),false);    
     }
     
       @Test  
     public void testX1andX2Invalid() throws Exception {
         
        Circuit x1 = factory.createConstant();
        Circuit x2 = factory.createConstant();

        Circuit and = factory.createAnd(x1, x2);
         
        x1.setValue("xxx");
        x2.setValue(Boolean.valueOf(true));

        assertEquals(and.getValue(), new Exception());
     }
     
}
