import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.java_rmi;

/**
 *
 * @author stimp
 */
public interface MyRemoteInterface extends Remote {
    public String sayHello() throws RemoteException;
}

