package ifpb.pos.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2018, 10:46:26
 */
public interface Mensagem extends Remote {

    public String ler() throws RemoteException;
}
