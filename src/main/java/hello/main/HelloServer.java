package hello.main;



import hello.Hello;
import hello.HelloHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 14/06/2018, 10:43:12
 */
public class HelloServer {

    public static void main(String[] args) throws InvalidName {
        try {
            String[] params = {"-ORBInitialPort", "1050", "-ORBInitialHost", "localhost"};

            ORB orb = ORB.init(params, System.getProperties());
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            HelloImpl helloImpl = new HelloImpl();
            helloImpl.setORB(orb);

            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(helloImpl);
            Hello href = HelloHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name = "Hello";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);
            rootPOA.the_POAManager().activate();
            System.out.println("HelloServer ready and waiting ...");

            orb.run(); //wait clients connections
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("HelloServer Exiting ...");
    }
}
