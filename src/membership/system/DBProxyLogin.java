package membership.system;

import java.sql.*;

public class DBProxyLogin
{
    /**
     * 
     * @param username
     */
    public static boolean checkForUser(String username, String sql)
    {
	try
        {
            Connection conn = DatabaseAccess.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ResultSet rs = null;

                rs = ps.executeQuery();
                while(rs.next())
                {
                    String dbUser = rs.getString("USERNAME");
                    if(dbUser.equals(username))
                    {
                        rs.close();
                        ps.close();
                        conn.close();
                        System.out.println("Connection is closed.");
                        return true;
                    }
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
        
        return false;
    }

    public static String getPassword(String username, String sql)
    {
        String password = null;
        
        try
        {
            Connection conn = DatabaseAccess.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ResultSet rs = null;

                rs = ps.executeQuery();
                while(rs.next())
                { 
                    password = rs.getString("PASSWORD");
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
        
        return password;
    }
}