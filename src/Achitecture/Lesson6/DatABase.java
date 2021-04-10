package Achitecture.Lesson6;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Random;
import java.util.UUID;

public class DatABase {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/clients?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "Lbvf88801";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) throws ClassNotFoundException {
        String query = "select * from USERS";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {

            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

//            Random rand = new Random();
//            String[] firstName = {"Anton", "XXX", "SASHA", "VIKING","VLFL","PETYA", "SUKAMTO"};
//            String[] lastName = {"LOOLLL", "YYY", "SASHULEVICH", "VIKINGOVICH","VLFL","PETYAVICH", "SUKAMTOVICH"};
//            //for (int i = 0; i < 50000000; i++) {
//            InsertData(rand.nextInt(60606),rand.nextInt(60) + 10,firstName[rand.nextInt(7)], lastName[rand.nextInt(7)]);
//            //}
//            updateUserAge(54941, rand.nextInt(100));
//            updateUserAge(6495, rand.nextInt(100));
//            deleteUser("VLFL");
//            deleteUser("SASHA");
//            deleteUser("PETYA");
//            SelectUers();
//            System.out.println("Количество записей " + getCount());

        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
    public static void SelectUers() throws SQLException {
        String query = "select * from USERS";
        // getting Statement object to execute query

        // executing SELECT query
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt(1);
            int age = rs.getInt(2);
            String firstname = rs.getString(3);
            String lastname = rs.getString(4);

            System.out.printf("id: %d | Age: %d | FirstName: %s | LastName: %s | %n", id, age, firstname,lastname);
        }
    }

    public static void InsertData(int id, int age, String firstName, String lastName) throws SQLException {
        String query = "INSERT INTO MYDATABASENEW.USERS (id, AGE, FirstName,LastName) \n" +
                String.format(" VALUES (%d, '%d', '%s','%s');",id,age,firstName,lastName);

// executing SELECT query
        stmt.executeUpdate(query);
    }

    public static void deleteUser(String firstName) throws SQLException {
        String query = "DELETE FROM MYDATABASENEW.USERS \n" +
                String.format(" WHERE FirstName = '%s';",firstName);

// executing SELECT query
        stmt.executeUpdate(query);
    }


    public static void updateUserAge(int id, int age) throws SQLException {
        String query = "UPDATE MYDATABASENEW.USERS" +
                String.format(" SET Age = %d WHERE id = %d",age, id);

// executing SELECT query
        stmt.executeUpdate(query);
    }

    public static int getCount() throws SQLException {
        String query = "SELECT COUNT(*) FROM MYDATABASENEW.USERS";
        rs = stmt.executeQuery(query);
        while (rs.next()) return rs.getInt(1);
        return 1;
    }
}
