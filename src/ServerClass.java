import java.rmi.*;
import java.rmi.server.*;

public class ServerClass  {
    public static void main(String[] args) {
        try{
            BankImpl sam = new BankImpl();
            Naming.bind("//localhost:8000/remote",sam);
        }
        catch(Exception e){}

    }
}
