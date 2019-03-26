package membership.system;

public class NewMemberController
{
	private NewMemberController()
        {
		// TODO - implement NewMemberController.NewMemberController
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
	public void addPersonalDetails(String firstName, String lastName,
                String email, int contactNumber, int membership,
                String dateOfBirth, int gender)
        {
		// TODO - implement NewMemberController.addPersonalDetails
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
		// TODO - implement NewMemberController.addAddressDetails
	}

	/**
	 * 
	 * @param cardName
	 * @param expiryMonth
	 * @param expiryYear
	 * @param security
	 */
	public void addBillingDetails(String cardName, int expiryMonth,
                int expiryYear, int security)
        {
		// TODO - implement NewMemberController.addBillingDetails
	}

}