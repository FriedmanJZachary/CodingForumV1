import static spark.Spark.*;

public class SparkUser {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World /n");
    }

    // I am testing a git commit
}