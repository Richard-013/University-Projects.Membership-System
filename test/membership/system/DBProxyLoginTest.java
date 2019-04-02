/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membership.system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hortonr6
 */
public class DBProxyLoginTest {
    
    public DBProxyLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkForUser method, of class DBProxyLogin.
     */
    @Test
    public void testCheckForUser()
    {
        System.out.println("Check For User Test");
        String usernameIncorrect = "User466";
        String usernameCorrect = "user1";
        String sql = "SELECT username FROM LOGIN WHERE username = ?";
        boolean result = DBProxyLogin.checkForUser(usernameIncorrect, sql);
        assertEquals(false, result);
        result = DBProxyLogin.checkForUser(usernameCorrect, sql);
        assertEquals(true, result);
    }

    /**
     * Test of getPassword method, of class DBProxyLogin.
     */
    @Test
    public void testGetPassword()
    {
        System.out.println("Get Password Test");
        String usernameIncorrect = "USER";
        String usernameCorrect = "user1";
        String sql = "SELECT password FROM LOGIN WHERE username = ?";
        String result = DBProxyLogin.getPassword(usernameIncorrect, sql);
        assertNull(result);
        result = DBProxyLogin.getPassword(usernameCorrect, sql);
        assertEquals("password", result);
    }
    
}
