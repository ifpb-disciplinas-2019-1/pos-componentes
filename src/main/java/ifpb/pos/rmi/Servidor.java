package ifpb.pos.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2018, 10:44:04
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(12345);
            Mensagem mensagem = new MensagemRemota("Oii");
//            Remote exportObject = UnicastRemoteObject.exportObject(mensagem, 12346);
//            registry.rebind("msg", exportObject);
            registry.rebind("msg", mensagem);
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
