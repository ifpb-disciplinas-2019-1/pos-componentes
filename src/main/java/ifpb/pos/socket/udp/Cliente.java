package ifpb.pos.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2018, 11:04:34
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            System.out.println("Cliente");
            DatagramSocket socket = new DatagramSocket();
            //Enviando informações - destino
            InetAddress destino = InetAddress.getByName("127.0.0.1");
            int porta = 1234;
            //Enviando informações - mensagem
            String mensagem = "Outra mensagem";
            byte[] dados = mensagem.getBytes();
            DatagramPacket pacote = new DatagramPacket(dados, dados.length, destino, porta);
            socket.send(pacote);
            System.out.println("Mensagem enviada");
            //Recebendo 
            byte[] dadosRecebidos = new byte[14];
            DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);
            socket.receive(pacoteRecebido);
            System.out.println("Recebido: " + new String(pacoteRecebido.getData()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
