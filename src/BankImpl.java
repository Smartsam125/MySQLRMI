import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.*;

public class BankImpl extends  UnicastRemoteObject implements Bank{
    public BankImpl()
            throws RemoteException
    {
        super();
    }
    public List <Customer> getCustomers()

    {
        List<Customer> list= new ArrayList<Customer>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
            System.out.println("SuccessFulConnection");
            PreparedStatement ps =con.prepareStatement("Select*from customer");
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                Customer c = new Customer();
                c.setAccount_number(rs.getInt(1));
                c.setFirstName(rs.getString(2));
                //c.getLastName(rs.getString(3));
                c.setLastName(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setAmout(rs.getInt(5));
              list.add(c);
              con.close();
            }


        }
        catch (Exception  e){
            System.out.println("error"+ e.getMessage() );

        }
        return list;

    }
}
