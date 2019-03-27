package membership.system;

import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class FindIDController
{
	/**
	 * 
	 * @param firstName
	 */
	public void searchByName(String firstName)
        {
            try
            {
                Connection conn = DatabaseAccess.makeConnection();
                System.out.println("Connecting...");

                if(conn != null)
                {
                    String sql = "SELECT m.memberID, m.firstName, m.lastName, a.addressLine1, a.postcode\n" +
                            "FROM Member m, Address a\n" +
                            "LEFT JOIN Member ON (SELECT memberID FROM Member WHERE firstName = '?') = a.memberID";
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