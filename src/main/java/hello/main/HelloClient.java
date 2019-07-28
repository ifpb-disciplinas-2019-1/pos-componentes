package hello.main;

import hello.Hello;
import hello.HelloHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 14/06/2018, 10:45:56
 */
public class HelloClient {

//    static Hello helloImpl;

    public static void main(String args[]) {
        try {
            String[] params = {"-ORBInitialPort", "1050", "-ORBInitialHost" ,"localhost"};
            // Create and initialize the ORB
            ORB orb = ORB.init(params, System.getProperties());
            org.omg.CORBA.Object objRef= orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
             

            String name = "Hello";
            Hello helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));
            
            System.out.println("Obtained a handle on server object: " + helloImpl);
            System.out.println(helloImpl.sayHello());
            System.out.println(helloImpl.sayHello());
            helloImpl.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
