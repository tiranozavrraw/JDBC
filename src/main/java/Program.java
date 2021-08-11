import java.sql.*;


public class Program {
    public static void main(String[] args){
        final String URL_DB = "jdbc:postgresql://127.0.0.1:5432/Java";
        final String USER = "postgres";
        final String PASS = "*";


        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(URL_DB, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM Students;");
            while(set.next()) {
                System.out.println(set.getString("student_id") + " " + set.getString("name") + " " + set.getString("last_name")
                + " " + set.getString("class_id") + " " + set.getString("average_grade"));
            }
            set.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
