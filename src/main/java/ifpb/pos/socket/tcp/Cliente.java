package ifpb.pos.socket.tcp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2018, 09:53:32
 */
public class Cliente {

    public static void main(String[] args) {

        try (Socket client = new Socket("localhost", 10999)) {
            PrintWriter out = new PrintWriter(client.getOutputStream());
            InputStream is = client.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            try (BufferedReader in = new BufferedReader(reader)) {
                out.write("oi");
                System.out.println(in.readLine());
//                ObjectInputStream input = new ObjectInputStream(is);
//                ArrayList list =(ArrayList) input.readObject();
//                is.close();
                //out.close();
//                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
