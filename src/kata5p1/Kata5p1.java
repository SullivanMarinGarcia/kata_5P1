package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5p1 {

    
    
    
    public static void createTable(){
        String url = "jdbc:sqlite:email.db";
        
        String sql = "CREATE TABLE IF NOT EXISTS direcc_email (\n" +
                " id integer PRIMARY KEY AUTOINCREMENT, \n" + 
                " direccion text NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
            
            stmt.execute(sql);
            System.out.println("TABLA CREADA");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        connectDB conn = new connectDB();
        conn.selectAll();
        createTable();
        
    }
    
    
    
}
