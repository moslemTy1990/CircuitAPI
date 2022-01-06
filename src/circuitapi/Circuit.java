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
public interface Circuit<T> {
    public T getValue();
    public void setValue(T t);
}
