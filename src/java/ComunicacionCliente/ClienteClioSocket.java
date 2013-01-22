/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComunicacionCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Roger
 */
public class ClienteClioSocket {

    String ip;
    String comando;
    public ClienteClioSocket(String ip , String comando) {
        this.ip=ip;
        this.comando=comando;
    }
    
    public  void Ejecutar() {
      final String servidor=ip;
      final int puerto=11001;
      final int puertoWinService=11002;
      
          
      try{
        Socket socket;
        if(comando.equals("apagpc")) {
              socket= new Socket (servidor,puertoWinService);
          }
        else {
              socket= new Socket (servidor,puerto);
          }
        //conseguimos el canal de entrada
        BufferedReader entrada = new BufferedReader (new InputStreamReader(socket.getInputStream()));
        //conseguimos el canal de salida
        PrintWriter salida=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            salida.println(comando+"<EOF>");
               // salida.println("respuesta<EOF>");
                //recibimos la respuesta del servidor    
                  System.out.println(entrada.readLine());
        socket.close();
      } catch (UnknownHostException e){
          e.printStackTrace();
          System.out.println("Debes estar conectado para que esto funcione bien");
      } catch (IOException e)
      {
          e.printStackTrace();
      }
      
    }
    
}
