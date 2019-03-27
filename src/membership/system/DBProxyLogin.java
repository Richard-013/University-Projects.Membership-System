package membership.system;

import java.sql.*;

public class DBProxyLogin
{
    /**
     * 
     * @param username
     */
    public void checkForUser(String username)
    {
	try
        {
            Connection conn = DatabaseAccess.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, firstName);
                ResultSet rs = null;

                rs = ps.executeQuery();
                while(rs.next())
                { 
                    
                }

                rs.close();
                ps.close();
                conn.close();
                System.out.println("Connection is closed.");  
            }
            else
            {
                System.out.println("null");
            }
        }
        catch(SQLException ex)
        {             
            System.out.println("SQLException error");
            System.out.println(ex.getMessage());
        }
    }

    public void getPassword()
    {
        try
        {
            Connection conn = DatabaseAccess.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, firstName);
                ResultSet rs = null;

                rs = ps.executeQuery();
                while(rs.next())
                { 
                    
                }

                rs.close();
                ps.close();
                conn.close();
                System.out.println("Connection is closed.");  
            }
            else
            {
                System.out.println("null");
            }
        }
        catch(SQLException ex)
        {             
            System.out.println("SQLException error");
            System.out.println(ex.getMessage());
        }
    }
}