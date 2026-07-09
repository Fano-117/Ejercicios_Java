/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javarmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author stimp
 */
public interface Interface extends Remote{
      public float suma(float n1, float n2) throws RemoteException;
      public float resta(float n1, float n2) throws RemoteException;
      public float multiplicacion(float n1, float n2) throws RemoteException;
      public float divicion(float n1, float n2) throws RemoteException;
}
