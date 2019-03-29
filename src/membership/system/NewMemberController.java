package membership.system;

public class NewMemberController
{
    /**
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @param contactNumber
     * @param membership
     * @param dateOfBirth
     * @param gender
     */
    public void addPersonalDetails(String firstName, String lastName,
        String email, int contactNumber, int membership, String dateOfBirth, int gender)
    {
        AdvisorUI.currentMember.setFirstName(firstName);
        AdvisorUI.currentMember.setLastName(lastName);
        AdvisorUI.currentMember.setEmail(email);
        AdvisorUI.currentMember.setContactNumber(contactNumber);
        AdvisorUI.currentMember.setMembershipType(membership);
        AdvisorUI.currentMember.setDateOfBirth(dateOfBirth);
        AdvisorUI.currentMember.setGender(gender);
    }

    /**
     * 
     * @param addressLine1
     * @param addressLine2
     * @param city
     * @param county
     * @param postcode
     */
    public void addAddressDetails(String addressLine1, String addressLine2,
        String city, String county, String postcode)
    {
        AdvisorUI.currentMember.setAddressLine1(addressLine1);
        AdvisorUI.currentMember.setAddressLine2(addressLine2);
        AdvisorUI.currentMember.setCity(city);
        AdvisorUI.currentMember.setCounty(county);
        AdvisorUI.currentMember.setPostcode(postcode);
    }

    /**
     * 
     * @param cardNum
     * @param cardName
     * @param expiryMonth
     * @param expiryYear
     * @param security
     */
    public void addBillingDetails(int cardNum, String cardName, int expiryMonth,
        int expiryYear, int security)
    {
        AdvisorUI.currentMember.setCardNumber(cardNum);
        AdvisorUI.currentMember.setCardName(cardName);
        AdvisorUI.currentMember.setExpiryMonth(expiryMonth);
        AdvisorUI.currentMember.setExpiryYear(expiryYear);
        AdvisorUI.currentMember.setSecurity(security);
    }
    
    public int completeNewMember()
    {
        String sqlPersonal = "INSERT INTO MEMBER (firstname, lastname, email, contactnumber, membership, dateofbirth, gender, memberid)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlID = "SELECT memberID FROM MEMBER WHERE firstname = ? AND lastname = ? AND contactnumber = ?";
        String sqlAddress = "INSERT INTO ADDRESS (memid, addressLine1, addressLine2, city, county, postCode, addressid)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sqlBilling = "INSERT INTO BILLINGINFO (memberID, cardNum, cardName, expiryMonth, expiryYear, security, billingid)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return DBProxyMembership.addNewMember(sqlPersonal, sqlID, sqlAddress, sqlBilling);
    }
}