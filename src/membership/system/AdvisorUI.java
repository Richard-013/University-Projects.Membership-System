/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membership.system;


import java.sql.*;
/**
 *
 * @author hortonr6
 */
public class AdvisorUI {

    public static UpdateMemberController updateCon;
    public static NewMemberController newMemberCon;
    public static LogInController loginCon;
    public static FindIDController findIDCon;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        updateCon = new UpdateMemberController();
        newMemberCon = new NewMemberController();
        loginCon = new LogInController();
        findIDCon = new FindIDController();
        LoginUI mainApp = new LoginUI();
        mainApp.setVisible(true);
        
        // DB Connection
        String connectionURL = "jdbc:derby://localhost:1527/MembershipDB";
        String uName = "user1";
        String uPass = "password";
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            System.out.println("Connecting...");
            
            if(conn != null)
            {
                Statement st = conn.createStatement();
                ResultSet rs = null;
                
                System.out.println("Sample Record:");
                System.out.println("---------------------");
                String sql = "SELECT * FROM Member";
                rs=st.executeQuery(sql);
                while(rs.next())
                { 
                    System.out.println(rs.getInt("MEMBERID")+"\t"+rs.getString("FIRSTNAME"));
                }
                
                rs.close();
                st.close();
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
    
    public void startUI()
    {
	// TODO - implement Advisor_UI.startUI
    }
}

