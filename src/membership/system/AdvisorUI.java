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

    public static FindID_UI findID;
    public static LoginUI login;
    public static MainMenuUI mainMenu;
    public static NewMemberUI newMember;
    public static UpdateMemberUI updateMember;
    public static Advisor currentAdvisor;
    public static Member currentMember;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        startUI();
    }
    
    private static void startUI()
    {
	login = new LoginUI();
        login.setVisible(true);
    }
}

