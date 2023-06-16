import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Head {

    private JButton button1;
    private JPanel panel1;

    public static void Head ()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Your Head Id ----> ? ");
        String id = sc.nextLine();
        System.out.println("Enter Your Head password----> ");
        int p =sc.nextInt();
        if(id != "head" && p!=1234)
        {
            System.out.println("Something went worng  :) ");
            System.out.println("Try Again ! ");
            return ;
        }

        while(true)
        {
            System.out.println("Press 1 for add party : ...");
            System.out.println("Press 2 for remove part:. . ");
            System.out.println("Press 3 to declare the winner : ...");
            int temp = sc.nextInt();
            if(temp==1)
            {
                AddParty();
                System.out.println("A new Party is added successfully ...");
            }
            else if(temp==2)
            {
                System.out.println("Party is remove successfully : ....");


            } else if (temp==3) {
                Winner();

            }
            else {
                break;
            }
        }
    }
    private static void AddParty ()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Name of the part :  ");
        String name=sc.nextLine();
        System.out.println("Unique integer of the party :  ");
        int i = sc.nextInt();
        Voter.party.put(i,name);


    }
    private static void Winner ()
    {
        try{
            //connect to databases
            Connection con = Connector.connect();
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
        }


    }
}
