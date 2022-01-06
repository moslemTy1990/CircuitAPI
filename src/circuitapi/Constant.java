/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitapi;

import java.awt.*;

/**
 *
 * @author Renisa, Shyam, Shabnam, Moslem
 */
public class Constant<T extends Object> implements Circuit<T>{
    private T value;

       public Constant(){ }
       
    public Constant(T value){
        this.value =value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T t) {
        this.value = t;
    }
    
}
