package membership.system;

public class Advisor
{
    private String username;
    private String password;
    
    public Advisor(String currentUsername, String currentPassword)
    {
        setUsername(currentUsername);
        setPassword(currentPassword);
    }

    public String getUsername()
    {
        return this.username;
    }

    /**
     * 
     * @param username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    /**
     * 
     * @param password
     */
    public void setPassword(String password)
    {
            this.password = password;
    }
}