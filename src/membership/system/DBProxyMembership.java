package membership.system;

import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DBProxyMembership
{
    public static int getDetails(int table, int memberID, String sql)
    {
        try
        {
            Connection conn = DatabaseAccessRepoImpl.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, memberID);
                ResultSet rs = null;
                
                rs = ps.executeQuery();
                
                switch (table)
                {
                    // Member Table
                    case 1:
                        System.out.println("Member Start");
                        rs.next();
                        AdvisorUI.currentMember.setFirstName(rs.getString("FIRSTNAME"));
                        AdvisorUI.currentMember.setLastName(rs.getString("LASTNAME"));
                        AdvisorUI.currentMember.setEmail(rs.getString("EMAIL"));
                        AdvisorUI.currentMember.setContactNumber(rs.getInt("CONTACTNUMBER"));
                        AdvisorUI.currentMember.setMembershipType(rs.getInt("MEMBERSHIP"));
                        AdvisorUI.currentMember.setDateOfBirth(rs.getString("DATEOFBIRTH"));
                        AdvisorUI.currentMember.setGender(rs.getInt("GENDER"));
                        System.out.println("Member End");
                        break;
                    // Address Table
                    case 2:
                        System.out.println("Address Start");
                        rs.next();
                        AdvisorUI.currentMember.setAddressLine1(rs.getString("ADDRESSLINE1"));
                        AdvisorUI.currentMember.setAddressLine2(rs.getString("ADDRESSLINE2"));
                        AdvisorUI.currentMember.setCity(rs.getString("CITY"));
                        AdvisorUI.currentMember.setCounty(rs.getString("COUNTY"));
                        AdvisorUI.currentMember.setPostcode(rs.getString("POSTCODE"));
                        System.out.println("Address End");
                        break;
                    // Billing Table
                    case 3:
                        System.out.println("Billing Start");
                        rs.next();
                        AdvisorUI.currentMember.setCardName(rs.getString("CARDNAME"));
                        AdvisorUI.currentMember.setCardNumber(rs.getInt("CARDNUM"));
                        AdvisorUI.currentMember.setExpiryMonth(rs.getInt("EXPIRYMONTH"));
                        AdvisorUI.currentMember.setExpiryYear(rs.getInt("EXPIRYYEAR"));
                        AdvisorUI.currentMember.setSecurity(rs.getInt("SECURITY"));
                        System.out.println("Billing End");
                        break;
                    default:
                        System.out.println("Error");
                }

                rs.close();
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
    
    public static int addNewMember(String sqlPersonal, String sqlID, String sqlAddress, String sqlBilling)
    {
        try
        {
            Connection conn = DatabaseAccessRepoImpl.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement personalStmt = conn.prepareStatement(sqlPersonal);
                personalStmt.setString(1, AdvisorUI.currentMember.getFirstName());
                personalStmt.setString(2, AdvisorUI.currentMember.getLastName());
                personalStmt.setString(3, AdvisorUI.currentMember.getEmail());
                personalStmt.setInt(4, AdvisorUI.currentMember.getContactNumber());
                personalStmt.setInt(5, AdvisorUI.currentMember.getMembershipType());
                personalStmt.setString(6, AdvisorUI.currentMember.getDateOfBirth());
                personalStmt.setInt(7, AdvisorUI.currentMember.getGender());
                personalStmt.setInt(8, DatabaseAccessRepoImpl.memID);
                personalStmt.executeUpdate();
                personalStmt.close();
                DatabaseAccessRepoImpl.memID += 1;
                
                PreparedStatement ps = conn.prepareStatement(sqlID);
                ps.setString(1, AdvisorUI.currentMember.getFirstName());
                ps.setString(2, AdvisorUI.currentMember.getLastName());
                ps.setInt(3, AdvisorUI.currentMember.getContactNumber());
                ResultSet rs = null;
                
                rs = ps.executeQuery();
                while(rs.next())
                { 
                    AdvisorUI.currentMember.setMemberID(rs.getInt("MEMBERID"));
                }

                ps.close();
                rs.close();
                
                PreparedStatement addressStmt = conn.prepareStatement(sqlAddress);
                addressStmt.setInt(1, AdvisorUI.currentMember.getMemberID());
                addressStmt.setString(2, AdvisorUI.currentMember.getAddressLine1());
                addressStmt.setString(3, AdvisorUI.currentMember.getAddressLine2());
                addressStmt.setString(4, AdvisorUI.currentMember.getCity());
                addressStmt.setString(5, AdvisorUI.currentMember.getCounty());
                addressStmt.setString(6, AdvisorUI.currentMember.getPostcode());
                addressStmt.setInt(7, DatabaseAccessRepoImpl.addID);
                addressStmt.executeUpdate();
                addressStmt.close();
                DatabaseAccessRepoImpl.addID += 1;
                
                PreparedStatement billingStmt = conn.prepareStatement(sqlBilling);
                billingStmt.setInt(1, AdvisorUI.currentMember.getMemberID());
                billingStmt.setInt(2, AdvisorUI.currentMember.getCardNumber());
                billingStmt.setString(3, AdvisorUI.currentMember.getCardName());
                billingStmt.setInt(4, AdvisorUI.currentMember.getExpiryMonth());
                billingStmt.setInt(5, AdvisorUI.currentMember.getExpiryYear());
                billingStmt.setInt(6, AdvisorUI.currentMember.getSecurity());
                billingStmt.setInt(7, DatabaseAccessRepoImpl.billID);
                billingStmt.executeUpdate();
                billingStmt.close();
                DatabaseAccessRepoImpl.billID += 1;
                
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
     * @param memberID
     */
    public static int delete(int memberID, String sql)
    {
        try
        {
            Connection conn = DatabaseAccessRepoImpl.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, memberID);
                ps.executeUpdate();
                
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
     * @param table
     * @param memberID
     * @param sql
     * @return integer
     */
    public static int changeDetails(int table, int memberID, String sql)
    {
        try
        {
            Connection conn = DatabaseAccessRepoImpl.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                
                switch (table)
                {
                    // Update Member Table
                    case 1:
                        System.out.println("Member Start");
                        ps.setString(1, AdvisorUI.currentMember.getFirstName());
                        ps.setString(2, AdvisorUI.currentMember.getLastName());
                        ps.setString(3, AdvisorUI.currentMember.getEmail());
                        ps.setInt(4, AdvisorUI.currentMember.getContactNumber());
                        ps.setInt(5, AdvisorUI.currentMember.getMembershipType());
                        ps.setInt(6, AdvisorUI.currentMember.getGender());
                        ps.setInt(7, memberID);
                        ps.executeUpdate();
                        System.out.println("Member End");
                        break;
                    // Update Address Table
                    case 2:
                        System.out.println("Address Start");
                        ps.setString(1, AdvisorUI.currentMember.getAddressLine1());
                        ps.setString(2, AdvisorUI.currentMember.getAddressLine2());
                        ps.setString(3, AdvisorUI.currentMember.getCity());
                        ps.setString(4, AdvisorUI.currentMember.getCounty());
                        ps.setString(5, AdvisorUI.currentMember.getPostcode());
                        ps.setInt(6, memberID);
                        ps.executeUpdate();
                        System.out.println("Address End");
                        break;
                    // Update Billing Table
                    case 3:
                        System.out.println("Billing Start");
                        ps.setInt(1, AdvisorUI.currentMember.getCardNumber());
                        ps.setString(2, AdvisorUI.currentMember.getCardName());
                        ps.setInt(3, AdvisorUI.currentMember.getSecurity());
                        ps.setInt(4, AdvisorUI.currentMember.getExpiryMonth());
                        ps.setInt(5, AdvisorUI.currentMember.getExpiryYear());
                        ps.setInt(6, memberID);
                        ps.executeUpdate();
                        System.out.println("Billing End");
                        break;
                    default:
                        System.out.println("Error");
                }
                
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
     * @param firstName
     * @param sql
     */
    public static void searchByName(String firstName, String sql)
    {
        try
        {
            Connection conn = DatabaseAccessRepoImpl.makeConnection();
            System.out.println("Connecting...");

            if(conn != null)
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, firstName);
                ResultSet rs = null;

                Vector<Integer> memberIDs = new Vector<Integer>();
                DefaultTableModel model;
                model = (DefaultTableModel) AdvisorUI.findID.memberTable.getModel();

                rs = ps.executeQuery();
                while(rs.next())
                {
                    if(memberIDs.isEmpty())
                    {
                        Vector<String> newRow =  new Vector<String>();
                        newRow.add(Integer.toString(rs.getInt("MEMBERID")));
                        newRow.add(rs.getString("FIRSTNAME"));
                        newRow.add(rs.getString("LASTNAME"));
                        newRow.add(rs.getString("EMAIL"));
                        newRow.add(rs.getString("DATEOFBIRTH"));
                        
                        model.addRow(newRow);
                        memberIDs.add(rs.getInt("MEMBERID"));
                    }
                    else if(memberIDs.contains(rs.getInt("MEMBERID")))
                    {
                        continue;
                    }
                    else
                    {
                        Vector<String> newRow =  new Vector<String>();
                        newRow.add(Integer.toString(rs.getInt("MEMBERID")));
                        newRow.add(rs.getString("FIRSTNAME"));
                        newRow.add(rs.getString("LASTNAME"));
                        newRow.add(rs.getString("EMAIL"));
                        newRow.add(rs.getString("DATEOFBIRTH"));
                        
                        model.addRow(newRow);
                        memberIDs.add(rs.getInt("MEMBERID"));
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
    }
}