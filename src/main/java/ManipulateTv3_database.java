import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ManipulateTv3_database {
    public static void main(String[] args) {
        String host = "localhost";
        String port = "3306";
        String database = "tv3_database";
        String username = "root";
        String password = "10joes10";
        String cp = "utf8";

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?characterEncoding=" + cp;

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Scanner scanner = new Scanner(System.in, "cp850");
            System.out.println("Type sql manipulation:");
            String sqlManipulation = scanner.nextLine();

            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlManipulation);

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
