package ifpb.pos.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/06/2018, 10:47:10
 */
public class MensagemRemota extends UnicastRemoteObject implements Mensagem {

    private final String mensagem;

    public MensagemRemota(String msg) throws RemoteException {
        this.mensagem = msg;
    }

    @Override
    public String ler() throws RemoteException {
        return this.mensagem;
    }
}
