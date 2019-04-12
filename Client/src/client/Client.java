package client;

import Sem6Lab5.Taskable;
import Sem6Lab5.TaskableHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Taskable taskObj = TaskableHelper.narrow(ncRef.resolve_str("ABC2"));
            System.out.println(taskObj.getResult());
        } catch (Exception e) {
            System.out.println("Client has thrown an exception: " + e);
            e.printStackTrace();
        }
    }
}
