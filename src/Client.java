import java.rmi.*;
import java.rmi.server.*;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try{

            Bank samson = (Bank)Naming.lookup("//localhost:8000/remote");
            List<Customer> list=samson.getCustomers();
            for (Customer c:list){
                System.out.println(c.getAccount_number());
                System.out.println(c.getAmout());
                System.out.println(c.getEmail());
                System.out.println(c.getFirstName());
                System.out.println(c.getLastName());
            }

        }catch(Exception e){}

    }

}
