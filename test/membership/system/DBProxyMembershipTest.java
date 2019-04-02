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
public class DBProxyMembershipTest {
    
    public DBProxyMembershipTest() {
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
     * Test of getDetails method, of class DBProxyMembership.
     */
    @Test
    public void testGetDetails() {
        System.out.println("Get Details Test");
        AdvisorUI mainUI = new AdvisorUI();
        AdvisorUI.currentMember = new Member();
        int table = 1;
        
        int memberID = 1;
        String sql = "SELECT * FROM MEMBER WHERE memberID = ?";
        int expResult = 0;
        int result = DBProxyMembership.getDetails(table, memberID, sql);
        assertEquals(expResult, result);
        
        memberID = 500;
        expResult = 2;
        result = DBProxyMembership.getDetails(table, memberID, sql);
        assertEquals(expResult, result);
        
        table = 2;
        memberID = 1;
        sql = "SELECT * FROM ADDRESS WHERE memID = ?";
        expResult = 0;
        result = DBProxyMembership.getDetails(table, memberID, sql);
        assertEquals(expResult, result);
        
        memberID = 500;
        expResult = 2;
        result = DBProxyMembership.getDetails(table, memberID, sql);
        assertEquals(expResult, result);
        
        table = 3;
        memberID = 1;
        sql = "SELECT * FROM BILLINGINFO WHERE memberID = ?";
        expResult = 0;
        result = DBProxyMembership.getDetails(table, memberID, sql);
        assertEquals(expResult, result);
        
        memberID = 500;
        expResult = 2;
        result = DBProxyMembership.getDetails(table, memberID, sql);
        assertEquals(expResult, result);
    }
}
