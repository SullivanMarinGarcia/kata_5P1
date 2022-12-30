package kata5p1;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class connectDB {
    private Connection connect(){
        
        String url = "jdbc:sqlite:KATA5.DB";
        Connection conn = null;
        
        
        try{
            conn = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    
    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        
        try (Connection conn = this.connect();
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                System.out.println(rs.getInt("ID") + "\t" + 
                                    rs.getString("NAME") + "\t" + 
                                    rs.getString("APELLIDOS") + "\t" +
                                    rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
