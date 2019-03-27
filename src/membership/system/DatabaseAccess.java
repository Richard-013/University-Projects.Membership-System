package membership.system;

import java.sql.*;

public class DatabaseAccess
{
    private static Connection conn;
    
    public static Connection makeConnection()
    {
        return conn;
    }
}