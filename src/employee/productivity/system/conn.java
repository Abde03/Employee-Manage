package employee.productivity.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {
    Connection connection ;
    Statement statement ;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productivity", "root", "abde");
            statement = connection.createStatement();

            String sql = "SELECT * FROM login";
            statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}