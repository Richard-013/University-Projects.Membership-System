/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membership.system;

import java.sql.Connection;

/**
 *
 * @author hortonr6
 */
public interface DatabaseAccessRepo
{
    static Connection makeConnection()
    {
        Connection conn = null;
        return conn;
    }
}
