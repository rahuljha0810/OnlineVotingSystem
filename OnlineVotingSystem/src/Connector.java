import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    public static Connection connect()
    {
        try{
            // load class

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/voterlist";
            String id ="root";
            String password="Rahul@1234";
            // create connection
            Connection con = DriverManager.getConnection(url, id, password);
            System.out.println("Connected SuccessFully ");
            return con;

        }
        catch (Exception c)
        {
            c.printStackTrace();
        }
        return null;

    }

}
