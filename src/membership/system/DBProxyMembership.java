package membership.system;

import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DBProxyMembership
{
    public static void getMemberDetails()
    {
        // TODO - implement DBProxyMembership.getMemberDetails
    }
    
    public static int addNewMember(String sqlPersonal, String sqlID, String sqlAddress, String sqlBilling)
    {
        try
        {
            Connection conn = DatabaseAccess.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement(sqlPersonal);
                ps.setString(1, AdvisorUI.currentMember.getFirstName());
                ps.setString(2, AdvisorUI.currentMember.getLastName());
                ps.setString(3, AdvisorUI.currentMember.getEmail());
                ps.setInt(4, AdvisorUI.currentMember.getContactNumber());
                ps.setInt(5, AdvisorUI.currentMember.getMembershipType());
                ps.setString(6, AdvisorUI.currentMember.getDateOfBirth());
                ps.setInt(7, AdvisorUI.currentMember.getGender());
                ps.setInt(8, DatabaseAccess.memID);
                ps.executeUpdate();
                ps = null;
                DatabaseAccess.memID += 1;
                
                ps = conn.prepareStatement(sqlID);
                ps.setString(1, AdvisorUI.currentMember.getFirstName());
                ps.setString(2, AdvisorUI.currentMember.getLastName());
                ps.setInt(3, AdvisorUI.currentMember.getContactNumber());
                ResultSet rs = null;
                
                rs = ps.executeQuery();
                while(rs.next())
                { 
                    AdvisorUI.currentMember.setMemberID(rs.getInt("MEMBERID"));
                }

                ps = null;
                rs.close();
                
                ps = conn.prepareStatement(sqlAddress);
                ps.setInt(1, AdvisorUI.currentMember.getMemberID());
                ps.setString(2, AdvisorUI.currentMember.getAddressLine1());
                ps.setString(3, AdvisorUI.currentMember.getAddressLine2());
                ps.setString(4, AdvisorUI.currentMember.getCity());
                ps.setString(5, AdvisorUI.currentMember.getCounty());
                ps.setString(6, AdvisorUI.currentMember.getPostcode());
                ps.setInt(7, DatabaseAccess.addID);
                ps.executeUpdate();
                ps = null;
                DatabaseAccess.addID += 1;
                
                ps = conn.prepareStatement(sqlBilling);
                ps.setInt(1, AdvisorUI.currentMember.getMemberID());
                ps.setInt(2, AdvisorUI.currentMember.getCardNumber());
                ps.setString(3, AdvisorUI.currentMember.getCardName());
                ps.setInt(4, AdvisorUI.currentMember.getExpiryMonth());
                ps.setInt(5, AdvisorUI.currentMember.getExpiryYear());
                ps.setInt(6, AdvisorUI.currentMember.getSecurity());
                ps.setInt(7, DatabaseAccess.billID);
                ps.executeUpdate();
                DatabaseAccess.billID += 1;
                
                ps.close();
                conn.close();
                System.out.println("Connection is closed.");  
            }
            else
            {
                System.out.println("null");
                return 1;
            }
        }
        catch(SQLException ex)
        {             
            System.out.println("SQLException error");
            System.out.println(ex.getMessage());
            return 2;
        }
        
        return 0;
    }

    /**
     * 
     * @param member
     */
    public static void changeMemberDetails(Member member)
    {
        // TODO - implement DBProxyMembership.changeMemberDetails
    }

    /**
     * 
     * @param firstName
     */
    public static void searchByName(String firstName, String sql)
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

                DefaultTableModel model = (DefaultTableModel) AdvisorUI.findID.memberTable.getModel();

                rs = ps.executeQuery();
                while(rs.next())
                { 
                    Vector<String> newRow =  new Vector<String>();
                    newRow.add(Integer.toString(rs.getInt("MEMBERID")));
                    newRow.add(rs.getString("FIRSTNAME"));
                    newRow.add(rs.getString("LASTNAME"));
                    newRow.add(rs.getString("ADDRESSLINE1"));
                    newRow.add(rs.getString("POSTCODE"));

                    model.addRow(newRow);
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