import static spark.Spark.*;

public class SparkUser {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World \n");

        get("/hello/:name/:password", (req,res)->{
            String pass = req.params(":password");
            System.out.println(pass);
            return "Hello, "+ req.params(":name") + "\n";
        });
    }

    // I am testing a git commit
    // adding a comment
}

