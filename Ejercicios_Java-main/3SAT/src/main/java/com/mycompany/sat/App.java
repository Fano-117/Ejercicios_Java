/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sat;

import com.mycompany.sat.hilo1;

/**
 *
 * @author stimp
 */
public class App {
    public static void main(String[] args) {
        
        hilo1 genetico1 = new hilo1();
        hilo1 genetico2 = new hilo1();
        
        genetico1.parametros( 50 , 550 ,  3 ,   30 , 0.01 );
        genetico2.parametros(100, 550, 3, 100, 0.009);
        genetico1.start();
        genetico2.start();
    }
}
