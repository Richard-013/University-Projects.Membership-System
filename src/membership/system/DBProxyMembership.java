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