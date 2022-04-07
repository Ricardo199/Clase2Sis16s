/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.Dao;
import java.util.*;
import sistema.Entidades.Producto;
import java.sql.*;
/**
 *
 * @author Ricardo Burgos
 */
public interface CrudProducto {
public ArrayList<Producto>mostrar()throws ClassNotFoundException,
        SQLException;
public int agregar(Producto p)throws ClassNotFoundException,SQLException;
public int modificarar(Producto p)throws ClassNotFoundException,SQLException;
public int eliminar(Producto p)throws ClassNotFoundException,SQLException;
}
