/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

/**
 *
 * @author mariam_youssef
 */
public class FixedFine implements FineCalculationStrategy {
 
    @Override
    public int calculateFine(int num) {
        return  FIXED_FINE;
    }
    
}
