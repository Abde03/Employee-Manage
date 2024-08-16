package employee.productivity.system;

import java.sql.* ;

public class Connect {
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/productivity",
                "root",
                "abde"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM login");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
}