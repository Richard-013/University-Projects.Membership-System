package membership.system;

public class UpdateMemberController
{
	private UpdateMemberController()
        {
		// TODO - implement UpdateMemberController.UpdateMemberController
	}

	/**
	 * 
	 * @param memberID
	 */
	public void getDetails(int memberID)
        {
		// TODO - implement UpdateMemberController.getDetails
	}

	/**
	 * 
	 * @param memberID
	 */
	private void getPersonalDetails(int memberID)
        {
		// TODO - implement UpdateMemberController.getPersonalDetails
	}

	/**
	 * 
	 * @param memberID
	 */
	private void getAddressDetails(int memberID) {
		// TODO - implement UpdateMemberController.getAddressDetails
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param memberID
	 */
	private void getBillingDetails(int memberID)
        {
		// TODO - implement UpdateMemberController.getBillingDetails
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
	public void updatePersonalDetails(String firstName, String lastName,
                String email, int contactNumber, int membership,
                String dateOfBirth, int gender)
        {
		// TODO - implement UpdateMemberController.updatePersonalDetails
	}

	/**
	 * 
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param county
	 * @param postcode
	 */
	public void updateAddressDetails(String addressLine1,
                String addressLine2, String city, String county, String postcode)
        {
		// TODO - implement UpdateMemberController.updateAddressDetails
	}

	/**
	 * 
	 * @param cardName
	 * @param expiryMonth
	 * @param expiryYear
	 * @param security
	 */
	public void updateBillingDetails(String cardName, int expiryMonth,
                int expiryYear, int security)
        {
		// TODO - implement UpdateMemberController.updateBillingDetails
	}

	/**
	 * 
	 * @param memberID
	 */
	public void deleteMembership(int memberID)
        {
		// TODO - implement UpdateMemberController.deleteMembership
	}

	/**
	 * 
	 * @param memberID
	 */
	private void deletePersonalDetails(int memberID)
        {
		// TODO - implement UpdateMemberController.deletePersonalDetails
	}

	/**
	 * 
	 * @param memberID
	 */
	private void deleteAddressDetails(int memberID)
        {
		// TODO - implement UpdateMemberController.deleteAddressDetails
	}

	/**
	 * 
	 * @param memberID
	 */
	private void deleteBillingInformation(int memberID)
        {
		// TODO - implement UpdateMemberController.deleteBillingInformation
	}
}