/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

/**
 *
 * @author stimp
 */

import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.*;

public class servidorRMI extends UnicastRemoteObject implements InterfazRemota {

    public servidorRMI() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws Exception {
        servidorRMI servidor = new servidorRMI();

        // Crea y arranca el registro de objetos RMI en el puerto 1099
        Registry registro = LocateRegistry.createRegistry(1099);

        // Publica el objeto remoto en el registro
        registro.rebind("ObjetoRemoto", servidor);

        System.out.println("Servidor RMI listo.");
    }

    public String holaMundo() throws RemoteException {
        return "¡Hola desde el servidor!";
    }
}


