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
public class Constant<T> implements Circuit<T>{
    private boolean value;

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public void setValue(Object t) {
        this.value =(boolean) t;
    }
    
}
