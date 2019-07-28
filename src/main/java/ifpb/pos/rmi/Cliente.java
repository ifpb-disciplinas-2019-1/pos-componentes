package ifpb.pos.rmi;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2018, 10:53:23
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(12345);
            Remote lookup = registry.lookup("msg");
            Mensagem msg = (Mensagem) lookup;
            System.out.println(msg.ler());
            
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
