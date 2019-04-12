package server;

import Sem6Lab5.Taskable;
import Sem6Lab5.TaskableHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA RootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            RootPOA.the_POAManager().activate();

            Task taskObj = new Task();

            org.omg.CORBA.Object ref = RootPOA.servant_to_reference(taskObj);
            Taskable href = TaskableHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent[] path = ncRef.to_name("ABC2");
            ncRef.rebind(path, href);
            System.out.println("Server has been started");

            for (; ; ) {
                orb.run();
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
