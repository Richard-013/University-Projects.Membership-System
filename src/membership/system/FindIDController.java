package membership.system;

public class FindIDController
{
    /**
     * 
     * @param firstName
     */
    public void searchByName(String firstName)
    {
        System.out.println("YES");
        String sqlStatement = "SELECT memberid, firstname, lastname, email, dateofbirth FROM MEMBER WHERE firstname = ?";

        DBProxyMembership.searchByName(firstName, sqlStatement);


    }
}