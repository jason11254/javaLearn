/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.ocp.day10.clothes;

/**
 *
 * @author MB-study
 */
public class Shirt_M extends T_Shirt{
    private Integer price;
    private Integer amount;

    public Shirt_M() {
    }
    
    public Shirt_M(Integer price, Integer amount) {
        this.price = price;
        this.amount = amount;
    }
    
    @Override
    public String getSize() {
        return "M";
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }
}
