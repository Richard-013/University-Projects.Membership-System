package membership.system;

public class UpdateMemberController
{
    /**
     *
     * @param memberID
     * @param firstName
     * @param lastName
     * @param email
     * @param contactNumber
     * @param membership
     * @param dateOfBirth
     * @param gender
     * @param addressLine1
     * @param addressLine2
     * @param city
     * @param county
     * @param postcode
     * @param cardName
     * @param expiryMonth
     * @param expiryYear
     * @param security
     * @return
     */
    public int updateMember(String memberID, String firstName, String lastName,
            String email, int contactNumber, int membership, int gender,
            String addressLine1, String addressLine2, String city, String county, String postcode,
            int cardNum, String cardName, int expiryMonth, int expiryYear, int security)
    {
        if(AdvisorUI.currentMember == null)
        {
            // No member selected
            return 3;
        }
        else
        {
            int intMemberID = Integer.parseInt(memberID);
            int personalCheck = updatePersonalDetails(intMemberID, firstName, lastName, email,
                    contactNumber, membership, gender);
            int addressCheck = updateAddressDetails(intMemberID, addressLine1, addressLine2,
                    city, county, postcode);
            int billingCheck = updateBillingDetails(intMemberID, cardNum, cardName, expiryMonth,
                    expiryYear, security);
            if(billingCheck == 0 && addressCheck == 0 && personalCheck == 0)
            {
                getDetails(memberID);
                return 0;
            }
            else if(billingCheck == 1 || addressCheck == 1 || personalCheck == 1)
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }
    }
    
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
    private int updatePersonalDetails(int memberID, String firstName, String lastName,
            String email, int contactNumber, int membership, int gender)
    {
        AdvisorUI.currentMember.setFirstName(firstName);
        AdvisorUI.currentMember.setLastName(lastName);
        AdvisorUI.currentMember.setEmail(email);
        AdvisorUI.currentMember.setContactNumber(contactNumber);
        AdvisorUI.currentMember.setMembershipType(membership);
        AdvisorUI.currentMember.setGender(gender);
        String sql = "UPDATE MEMBER "
                + "SET firstname = ?, lastname = ?, email = ?, contactnumber = ?, "
                + "membership = ?, gender = ? "
                + "WHERE memberid = ?";
        return DBProxyMembership.changeDetails(1, memberID, sql);
    }

    /**
     * 
     * @param addressLine1
     * @param addressLine2
     * @param city
     * @param county
     * @param postcode
     */
    private int updateAddressDetails(int memberID, String addressLine1,
            String addressLine2, String city, String county, String postcode)
    {
        AdvisorUI.currentMember.setAddressLine1(addressLine1);
        AdvisorUI.currentMember.setAddressLine2(addressLine2);
        AdvisorUI.currentMember.setCity(city);
        AdvisorUI.currentMember.setCounty(county);
        AdvisorUI.currentMember.setPostcode(postcode);
        String sql = "UPDATE ADDRESS "
                + "SET addressline1 = ?, addressline2 = ?, city = ?, county = ?, "
                + "postcode = ?"
                + "WHERE memid = ?";
        return DBProxyMembership.changeDetails(2, memberID, sql);
    }

    /**
     * 
     * @param cardName
     * @param expiryMonth
     * @param expiryYear
     * @param security
     */
    private int updateBillingDetails(int memberID, int cardNum, String cardName, int expiryMonth,
            int expiryYear, int security)
    {
        AdvisorUI.currentMember.setCardNumber(cardNum);
        AdvisorUI.currentMember.setCardName(cardName);
        AdvisorUI.currentMember.setExpiryMonth(expiryMonth);
        AdvisorUI.currentMember.setExpiryYear(expiryYear);
        AdvisorUI.currentMember.setSecurity(security);
        String sql = "UPDATE BILLINGINFO "
                + "SET cardnum = ?, cardname = ?, security = ?, expirymonth = ?, "
                + "expiryyear = ? "
                + "WHERE memberid = ?";
        return DBProxyMembership.changeDetails(3, memberID, sql);
    }

    /**
     * 
     * @param memberID
     */
    public int getDetails(String memberID)
    {
        AdvisorUI.currentMember = new Member();
        int intMemberID = Integer.parseInt(memberID);
        int billingCheck = getBillingDetails(intMemberID);
        int addressCheck = getAddressDetails(intMemberID);
        int personalCheck = getPersonalDetails(intMemberID);
        if(billingCheck == 0 && addressCheck == 0 && personalCheck == 0)
        {
            return 0;
        }
        else if(billingCheck == 1 || addressCheck == 1 || personalCheck == 1)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    /**
     * 
     * @param memberID
     */
    private int getPersonalDetails(int memberID)
    {
        String sql = "SELECT * FROM MEMBER WHERE memberID = ?";
        return DBProxyMembership.getDetails(1, memberID, sql);
    }

    /**
     * 
     * @param memberID
     */
    private int getAddressDetails(int memberID)
    {
        String sql = "SELECT * FROM ADDRESS WHERE memID = ?";
        return DBProxyMembership.getDetails(2, memberID, sql);
    }

    /**
     * 
     * @param memberID
     */
    private int getBillingDetails(int memberID)
    {
        String sql = "SELECT * FROM BILLINGINFO WHERE memberID = ?";
        return DBProxyMembership.getDetails(3, memberID, sql);
    }

    /**
     * 
     * @param memberID
     * @return statusCode
     */
    public int deleteMembership(int memberID)
    {
        int billingCheck = deleteBillingDetails(memberID);
        int addressCheck = deleteAddressDetails(memberID);
        int personalCheck = deletePersonalDetails(memberID);
        if(billingCheck == 0 && addressCheck == 0 && personalCheck == 0)
        {
            return 0;
        }
        else if(billingCheck == 1 || addressCheck == 1 || personalCheck == 1)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    /**
     * 
     * @param memberID
     */
    private int deletePersonalDetails(int memberID)
    {
        String sql = "DELETE FROM MEMBER WHERE memberid = ?";
        return DBProxyMembership.delete(memberID, sql);
    }

    /**
     * 
     * @param memberID
     */
    private int deleteAddressDetails(int memberID)
    {
        String sql = "DELETE FROM ADDRESS WHERE memid = ?";
        return DBProxyMembership.delete(memberID, sql);
    }

    /**
     * 
     * @param memberID
     */
    private int deleteBillingDetails(int memberID)
    {
        String sql = "DELETE FROM BILLINGINFO WHERE memberid = ?";
        return DBProxyMembership.delete(memberID, sql);
    }
}