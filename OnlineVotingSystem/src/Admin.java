import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {


    public static void add(String name, String email, int ph)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Your Admin Id ----> ? ");
        String id = sc.nextLine();
        System.out.println("Enter Your Admin password----> ");
        int p =sc.nextInt();
        if(id != "root" && p!=1234)
        {
            System.out.println("Something went wrong  :) ");
            System.out.println("Try Again ! ");
            return ;
        }
        try {
            // to add 1. create connection 2. prepare statement 3. excute statement
            Connection con = Connector.connect();

            String query = "INSERT INTO info (name, email, ph) VALUES (?, ?, ?)";
            PreparedStatement pst= con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2,email);
            pst.setInt(3, ph);

            pst.execute();
            System.out.println("added successfully ");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void remove(String name)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Your Admin Id ----> ? ");
        String id = sc.nextLine();
        System.out.println("Enter Your Admin password----> ");
        int p =sc.nextInt();
        if(id != "root" && p!=1234)
        {
            System.out.println("Something went worng  :) ");
            System.out.println("Try Again ! ");
            return ;
        }
        try {
            // create connection
            Connection con = Connector.connect();

            String query ="DELETE FROM info WHERE name=? ;";
            PreparedStatement pst= con.prepareStatement(query);
            pst.setString(1, name);

            pst.executeUpdate();
            System.out.println("Candidate is executed successfully... ");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    public static void UpdateName(String email, String Name)
    {
        try{
            Connection con = Connector.connect();
            String query="UPDATE info SET name = ? WHERE email= ? ;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, Name);
            pst.setString(2, email);
            pst.executeUpdate();
            con.close();
            System.out.println("Name is Updated Successfully ");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void Update_email(String email, String Name)
    {
        try{
            Connection con = Connector.connect();
            String query="UPDATE info SET email = ? WHERE name= ? ;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, Name);
            pst.executeUpdate();
            con.close();
            System.out.println("Email is Updated Successfully ");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
