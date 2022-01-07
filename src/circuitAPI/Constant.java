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
public class Constant<T extends Object> implements Circuit<T>{
    private T value;

    protected Constant(){ }

    protected Constant(T value){
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
