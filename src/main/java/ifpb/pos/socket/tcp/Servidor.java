package ifpb.pos.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2018, 09:48:19
 */
public class Servidor {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(10999)) {
            System.out.println("Servidor Criado");
            try (Socket client = server.accept()) {
                System.out.println("Cliente Conectado");
                OutputStream os = client.getOutputStream();
//                ObjectOutputStream saida = new ObjectOutputStream(os);
                try (PrintWriter out = new PrintWriter(os, true)) {
                    out.println("Mensagem enviada pelo Servidor");
//                    saida.writeObject(new ArrayList());
                }
            }
        } catch (IOException e) {
            
        }
    }

}
