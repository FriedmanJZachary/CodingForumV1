import static spark.Spark.*;

public class SparkUser {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }

    // I am testing a git commit
}