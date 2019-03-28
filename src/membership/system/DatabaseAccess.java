package membership.system;

import java.sql.*;

public class DatabaseAccess
{
    private static Connection conn;
    private static final String CONNECTIONURL = "jdbc:derby://localhost:1527/MembershipDB";
    private static final String UNAME = "user1";
    private static final String UPASS = "password";
    
    // DB Connection
    public static Connection makeConnection()
    {
        conn = null;

        try
        {
            conn = DriverManager.getConnection(CONNECTIONURL, UNAME, UPASS);
            System.out.println("Connecting...");

            if(conn != null)
            {
                return conn;
            }
            else
            {
                System.out.println("Could not connect to the database");  
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    
}