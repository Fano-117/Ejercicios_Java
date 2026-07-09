/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author stimp
 *//**
 *
 * @author stimp
 */
public class ImplementarInterface 
        extends UnicastRemoteObject 
        implements Interface{

    
    protected ImplementarInterface() throws RemoteException{
        super();
    }
    
    @Override
    public float suma(float n1, float n2) throws RemoteException {
    
        return n1+n2;
    }

    @Override
    public float resta(float n1, float n2) throws RemoteException {
    return n1-n2;
    }

    @Override
    public float multiplicacion(float n1, float n2) throws RemoteException {
    return n1*n2;
    }

    @Override
    public float divicion(float n1, float n2) throws RemoteException {
     return n1/n2;
    }
    
}
