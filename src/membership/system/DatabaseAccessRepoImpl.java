package membership.system;

import java.sql.*;

public class DatabaseAccessRepoImpl implements DatabaseAccessRepo
{
    private static Connection conn;
    private static final String CONNECTIONURL = "jdbc:derby://localhost:1527/MembershipDB";
    private static final String UNAME = "user1";
    private static final String UPASS = "password";
    public static int memID;
    public static int addID;
    public static int billID;
    
    // DB Connection

    /**
     *
     * @return conn
     */
    public static Connection makeConnection()
    {
        conn = null;

        try
        {
            conn = DriverManager.getConnection(CONNECTIONURL, UNAME, UPASS);
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement("SELECT memberid FROM MEMBER ORDER BY memberid DESC");
                ResultSet rs = null;
                
                rs = ps.executeQuery();
                while(rs.next())
                { 
                    memID = rs.getInt("MEMBERID") + 1;
                    break;
                }
                
                ps = conn.prepareStatement("SELECT addressid FROM ADDRESS ORDER BY addressid DESC");
                rs = null;
                
                rs = ps.executeQuery();
                while(rs.next())
                { 
                    addID = rs.getInt("ADDRESSID") + 1;
                    break;
                }
                
                ps = conn.prepareStatement("SELECT billingid FROM BILLINGINFO ORDER BY billingid DESC");
                rs = null;
                
                rs = ps.executeQuery();
                while(rs.next())
                { 
                    billID = rs.getInt("BILLINGID") + 1;
                    break;
                }
                
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