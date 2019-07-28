package hello.main;



import hello.HelloPOA;
import org.omg.CORBA.ORB;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 14/06/2018, 10:41:00
 */
public class HelloImpl extends HelloPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public String sayHello() {
        return "Oi tudo bem??!!!";
    }

    @Override
    public void shutdown() {
        orb.shutdown(false);
    }

}
