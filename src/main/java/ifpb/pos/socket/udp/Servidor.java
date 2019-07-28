package ifpb.pos.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2018, 11:02:43
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            System.out.println("Servidor");
            int porta = 1234;
            DatagramSocket socket = new DatagramSocket(porta);
            //Array byte
            byte[] dados = new byte[100];
            DatagramPacket pacote = new DatagramPacket(dados, dados.length);
            System.out.println("Estou esperando a mensagem");
            //Recebida - Tamanho, Tipo, etc...
            socket.receive(pacote);
            String mensagem = new String(pacote.getData(), 0, pacote.getLength());
            System.out.println("Mensagem: " + mensagem);
//            Enviando mensagem 
            InetAddress envio = pacote.getAddress();
            int portaEnvio = pacote.getPort();
            byte[] msg = "Olá tudo bem!!".getBytes();
            DatagramPacket pacoteEnvio = new DatagramPacket(msg, msg.length, envio, portaEnvio);
            socket.send(pacoteEnvio);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
