import java.rmi.*;
import java.rmi.*;
import java.util.*;
public interface Bank extends Remote{
    public List<Customer> getCustomers()throws RemoteException;

}
