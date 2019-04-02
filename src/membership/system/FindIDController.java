package membership.system;

public class FindIDController
{
    /**
     * 
     * @param firstName
     */
    public void searchByName(String firstName)
    {
        String sql = "SELECT memberid, firstname, lastname, email, dateofbirth FROM MEMBER WHERE firstname = ?";
        DBProxyMembership.searchByName(firstName, sql);
    }
}