package membership.system;

public class Member
{
    private int memberID;
    private String firstName;
    private String lastName;
    private String email;
    private int contactNumber;
    private int membershipType;
    private String dateOfBirth;
    private int gender;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String county;
    private String postcode;
    private String cardName;
    private int cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int security;
    private boolean discount;

    public Member()
    {
            // TODO - implement Member.Member
    }

    public void newMember()
    {
            // TODO - implement Member.updateDetails
    }

    public void updateDetails()
    {
            // TODO - implement Member.updateDetails
    }

    public int getMemberID()
    {
        return memberID;
    }

    public void setMemberID(int memberID)
    {
        this.memberID = memberID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getContactNumber()
    {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    public int getMembershipType()
    {
        return membershipType;
    }

    public void setMembershipType(int membershipType)
    {
        this.membershipType = membershipType;
        if(this.membershipType == 3)
        {
            this.discount = true;
        }
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public void setAddressLine2(String addressline2)
    {
        this.addressLine2 = addressline2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCounty()
    {
        return county;
    }

    public void setCounty(String county)
    {
        this.county = county;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getCardName()
    {
        return cardName;
    }

    public void setCardName(String cardName)
    {
        this.cardName = cardName;
    }
    
    public int getCardNumber()
    {
        return expiryMonth;
    }

    public void setCardNumber(int cardNum)
    {
        this.cardNumber = cardNum;
    }

    public int getExpiryMonth()
    {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth)
    {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear()
    {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear)
    {
        this.expiryYear = expiryYear;
    }

    public int getSecurity() 
    {
        return security;
    }

    public void setSecurity(int security)
    {
        this.security = security;
    }
}