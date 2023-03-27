import java.sql.*;
import java.util.Scanner;

public class QueryTv3_database {
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
            System.out.println("Type sql query:");
            String sqlManipulation = scanner.nextLine();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlManipulation);

            ResultSetMetaData resultSetMetaData= resultSet.getMetaData();

            int coloumCount = resultSetMetaData.getColumnCount();

            for (int i = 1; i <= coloumCount; i++) {
                System.out.print(resultSetMetaData.getColumnName(i) + "; ");
            }
            System.out.println();
            System.out.println("-----");

            resultSet.beforeFirst();
            while (resultSet.next()) {
                for (int i = 1; i <= coloumCount; i++) {
                    if(resultSet.getString(i) == null) {
                        System.out.print("null;");
                    } else {
                        System.out.print(resultSet.getString(i) + "; ");
                    }
                }
                System.out.println();
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
