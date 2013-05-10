/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package ComunicacionCliente;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.imageio.ImageIO;
/**
*
* @author Roger
*/
public class DesktopSocket {

String ip;
String comando;
public DesktopSocket(String ip) {
this.ip=ip;

}

public BufferedImage Ejecutar() {
final String servidor=ip;
final int puerto=11001;


// System.out.println(ip+"aaaaa");
try{
Socket socket; 
socket= new Socket (servidor,puerto);

PrintWriter salida=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
salida.println("captpa<EOF>");

//recibimos la respuesta del servidor
BufferedImage image = ImageIO.read(socket.getInputStream());

// ImageIO.write(image, "png", new File("foto.png"));
return image;
} catch (UnknownHostException e){
e.printStackTrace();
System.out.println("Debes estar conectado para que esto funcione bien");
} catch (IOException e)
{
e.printStackTrace();
}
return null;

}
}