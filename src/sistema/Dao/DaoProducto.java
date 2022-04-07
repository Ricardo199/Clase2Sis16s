/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.Dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistema.Entidades.Producto;


/**
 *
 * @author Ricardo Burgos
 */
public class DaoProducto extends Conexion implements CrudProducto{
    PreparedStatement ps;
    ResultSet rs;
    Producto p;
    int res;
    
    @Override
    public ArrayList<Producto> mostrar() throws ClassNotFoundException, 
            SQLException{
        ArrayList<Producto> ar=new ArrayList<Producto>();
        ps=super.con().prepareStatement("select * from producto");
        try {
            rs=ps.executeQuery();
            while (rs.next()) {                
                p=new Producto(rs.getInt("id"), rs.getString(2), rs.getDouble(3));
                ar.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            //ps.close();
            //rs.close();
            super.con().close();
        }
        return ar;
    }

    @Override
    public int agregar(Producto p) throws ClassNotFoundException, SQLException {
        ps=super.con().prepareStatement("INSERT INTO producto(nombre, precio) "
                + "values(?,?)");
        ps.setString(1, p.getNombre());
        ps.setDouble(2, p.getPrecio());
        try {
            res=ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            super.con().close();
        }
        return res;
    }

    @Override
    public int modificarar(Producto p) throws ClassNotFoundException,SQLException {
        ps=super.con().prepareStatement("update producto set nombre=?,precio=?"
                + "where id=?");
        ps.setString(1, p.getNombre());
        ps.setDouble(1, p.getPrecio());
        ps.setInt(3, p.getId());
        try {
            res=ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            super.con().close();
        }
        return res;
    }

    @Override
    public int eliminar(Producto p) throws ClassNotFoundException, SQLException {
       ps=super.con().prepareStatement("delete from producto where id=?");
        ps.setInt(1,p.getId());
        try {
            res=ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            super.con().close();
        }
        return res;
    }
    
}
