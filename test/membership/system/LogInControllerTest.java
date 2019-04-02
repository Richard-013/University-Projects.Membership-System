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
public class LogInControllerTest
{
    
    public LogInControllerTest() { 
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
     * Test of logIn method, of class LogInController.
     */
    @Test
    public void testLogIn()
    {
        System.out.println("Login Test");
        String usernameIncorrect = "Alpha";
        String passwordIncorrect = "NotMyPassword";
        String usernameCorrect = "user1";
        String passwordCorrect = "password";
        LogInController instance = new LogInController();
        int result = instance.logIn(usernameIncorrect, passwordCorrect);
        assertEquals(1, result);
        result = instance.logIn(usernameCorrect, passwordIncorrect);
        assertEquals(2, result);
        result = instance.logIn(usernameCorrect, passwordCorrect);
        assertEquals(0, result);
    }
    
}
