package membership.system;

public class Advisor
{
    private String username;
    private String password;
    
    public Advisor(String inUsername, String inPassword)
    {
        setUsername(inUsername);
        setPassword(inPassword);
    }

    public String getUsername()
    {
        return username;
    }

    /**
     * 
     * @param username
     */
    public void setUsername(String inUsername)
    {
        username = inUsername;
    }

    public String getPassword()
    {
        return password;
    }

    /**
     * 
     * @param password
     */
    public void setPassword(String inPassword)
    {
        password = inPassword;
    }
}