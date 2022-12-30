package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.PreparedStatement;

public class Kata5p1 {

    private static insertar insertados;
    
    
    public static void createTable(){
        String url = "jdbc:sqlite:mail2.db";
        
        String sql = "CREATE TABLE IF NOT EXISTS mail2 (\n" +
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
        
        String file = "D:\\NETBEANS\\KATAS OFICIALES\\kata5p1\\email.txt";
        List<String> mails = new MailListReader().read(file);
        
        insertados = new insertar();
        insertados.connect();
        
        for(String mail: mails){
            insertados.insert(mail);
        }
        
    }
    
    public static class insertar{
            
        private Connection connect() {
            // Cadena de conexión SQLite
            String url = "jdbc:sqlite:mail2.db";
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }
        // Método para insertar datos en la tabla direcc_email
        public void insert(String email) {
            String sql = "INSERT INTO mail2(direccion) VALUES(?)";
            try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
