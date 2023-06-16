import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HeadControl extends Head {
    protected void remove_party(String name)
    {
        //try {
        //connect to databases
        // update party is not working
           /* Connection con = Connector.connect();
            String query = "SELECT  COUNT(vote) AS frequency " +
                    "FROM voting " +
                    "GROUP BY vote " +
                    "ORDER BY frequency DESC " +
                    "LIMIT 1";

            Statement st = con.createStatement();
            ResultSet set = st.executeQuery(query);
            while(set.next())
            {
                int frequency = set.getInt("frequency");
                System.out.println("Frequency: " + frequency);
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/
    }
}
