package membership.system;

public class FindIDController
{
    /**
     * 
     * @param firstName
     */
    public void searchByName(String firstName)
    {
        String sqlStatement = "SELECT m.memberID, m.firstName, m.lastName, a.addressLine1, a.postcode\n" +
                        "FROM Member m, Address a\n" +
                        "LEFT JOIN Member ON (SELECT memberID FROM Member WHERE firstName = '?') = a.memberID";

        DBProxyMembership.searchByName(firstName, sqlStatement);


    }
}