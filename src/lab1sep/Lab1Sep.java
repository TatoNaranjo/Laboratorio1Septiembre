
package lab1sep;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
/**
 *
 * @author Acer
 */
public class Lab1Sep {
   

   
    public static void main(String[] args) {
        
    String url = "jdbc:mysql://localhost:3306/laboratorio";
    String user = "root";
    String password = "";
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    //Creando la Cadena de Conexión
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lab1Sep.class.getName()).log(Level.SEVERE, null, ex);
        }
    //Insertando datos en la Tabla de la Base de Datos
        try {
            con = DriverManager.getConnection(url,user,password);
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO persona VALUES (null,'Ricardo','2000-01-01') ");
    //Leyendo todos los datos desde la Tabla en la Base de Datos
            rs = stmt.executeQuery("SELECT * FROM persona");
            rs.next();
            //Retornando Datos Desde la  Tabla en la Base de datos.
            do{
                
                System.out.println(rs.getString("ID")+". Nombre: "+rs.getString("Nombre")+"\nNacimiento: "+rs.getString("Nacimiento"));
            }while(rs.next());
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Lab1Sep.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
        
      
        
        
    }
}
    

