public class UserClass {
    // Instance Variables
    String userName;
    String pass;
    String id;
    String email;

    // Constructor Declaration of Class
    public UserClass(String userName, String pass, String id, String email)
    {
        this.userName = userName;
        this.pass = pass;
        this.id = id;
        this.email = email;
    }

    //Name display method
    public String getName()
    {
        return userName;
    }

}