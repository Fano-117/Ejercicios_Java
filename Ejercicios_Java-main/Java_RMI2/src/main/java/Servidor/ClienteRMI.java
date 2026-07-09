/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

/**
 *
 * @author stimp
 */
import java.util.ArrayList;

public class ClienteRMI {

    public static void main(String[] args) throws Exception {
        // Obtiene la referencia al objeto remoto desde el registro
        InterfazRemota objetoRemoto = (InterfazRemota) Naming.lookup("//localhost/ObjetoRemoto");

        // Invoca un método en el objeto remoto
        String respuesta = objetoRemoto.holaMundo();

        System.out.println(respuesta);
    }
}


