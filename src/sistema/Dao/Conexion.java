/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.Dao;
import java.sql.*;
/**
 *
 * @author Ricardo Burgos
 */
public class Conexion {
    private String driver="con.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/sis16a";
    private String user="root";
    private String pass="";
    public Connection con()throws ClassNotFoundException,SQLException{
        Class.forName(driver);
        return DriverManager.getConnection(url,user,pass);
    }
}
