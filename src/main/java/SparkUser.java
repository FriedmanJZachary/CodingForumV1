import static spark.Spark.*;

public class SparkUser {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World \n");

        get("/hello/:name/:password", (req,res)->{
            String pass = req.params(":password");
            String name = req.params(":name");
            UserClass user1 = new UserClass(name, pass, "k34mlf56ewo9", "white@squirrel.com");
            return "Hello, " + user1.getName() + "\n";
        });
    }
}
