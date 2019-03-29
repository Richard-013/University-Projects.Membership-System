package membership.system;

public class LogInController
{
    /**
     * 
     * @param username
     */
    private boolean checkUsername(String username)
    {
        String sql = "SELECT username FROM LOGIN WHERE username = ?";
        return DBProxyLogin.checkForUser(username, sql);
    }

    /**
     * 
     * @param password
     */
    private boolean checkPassword(String password)
    {
        return password.equals(AdvisorUI.currentAdvisor.getPassword());
    }

    /**
     * 
     * @param username
     * @param password
     * @return 0, 1, or 2
     */
    public int logIn(String username, String password)
    {
        // Checks if the username is correct
        if(checkUsername(username))
        {
            // Sets up the advisor class
            String sql = "SELECT password FROM LOGIN WHERE username = ?";
            String dbPassword = DBProxyLogin.getPassword(username, sql);
            AdvisorUI.currentAdvisor = new Advisor(username, dbPassword);
            
            // Checks if the password is correct or not
            if(!checkPassword(password))
            {
                return 2;
            }
        }
        else
        {
            return 1;
        }
        
        return 0;
    }
}