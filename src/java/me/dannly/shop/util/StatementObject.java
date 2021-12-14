/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.dannly.shop.util;

/**
 *
 * @author vinix
 */
public class StatementObject<T> {
    
    private final T object;
    private final int position;

    public StatementObject(T object, int position) {
        this.object = object;
        this.position = position;
    }

    public T getObject() {
        return object;
    }

    public int getPosition() {
        return position;
    }
}
