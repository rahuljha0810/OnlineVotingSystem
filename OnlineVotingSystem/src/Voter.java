import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Voter {
    public static HashMap<Integer,String> party= new HashMap<>();

    public static void Login()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your name please.........");
        String name = sc.nextLine();
        System.out.println("OK, Now enter your email........");
        String email =sc.nextLine();
        ArrayList<String> lst= f(name, email);
        if(lst.size()!=0)
        {
            System.out.println("Press 1 for BJP--->");
            System.out.println("Press 2 for AAP--->");
            System.out.println("Press 3 for RJD--->");
            System.out.println("Press 4 for None--->");
            int vote = sc.nextInt();

            if(vote>0 && vote<5)
            {
                Vote(email, vote);
                System.out.println("Your Vote is Counted ");
            }
            else {
                System.out.println("Party dose not exist :");
            }

        }
        else {
            System.out.println("Wrong Candidature -- :(< ");
            System.out.println("Contact with Admin ");
        }

        System.out.println("ThankYou for Using this App :) ");
    }

    private static ArrayList<String> f (String name, String email)
    {
        ArrayList <String> list = new ArrayList<>();
        try{
            // connect database
            Connection con = Connector.connect();
            String query="select * from info WHERE name=? AND  email=?";

            PreparedStatement pst= con.prepareStatement(query);

            pst.setString(1,name);
            pst.setString(2,email);

            ResultSet set=pst.executeQuery();

            while (set.next())
            {
                list.add(set.getString("name"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    private static void Vote(String email, int vote)
    {
        try {
            // connect db
            Connection con = Connector.connect();
            String query="INSERT INTO voting (email, vote) VALUES(?, ?)";
            PreparedStatement pst= con.prepareStatement(query);

            pst.setString(1, email);
            pst.setInt(2,vote);
            pst.execute();
            System.out.println("Voted Successfully");
            con.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}
