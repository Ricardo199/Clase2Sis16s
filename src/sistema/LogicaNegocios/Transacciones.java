/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.LogicaNegocios;
import sistema.Dao.*;
import sistema.Entidades.Producto;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Ricardo Burgos
 */
public class Transacciones {
    Producto p;
    DaoProducto ob= new DaoProducto();
    public DefaultTableModel datos(){
        ArrayList<Producto> ar = new ArrayList<Producto>();
        String[] title={"ID","NOMBRE","PRECIO"};
        DefaultTableModel tm = new DefaultTableModel(title, 0);
        Object[] row=new Object[3];
        try {
            ar.addAll(ob.mostrar());
            for(Producto v:ar){
                row[0]=v.getId();
                row[1]=v.getNombre();
                row[2]=v.getPrecio();
                tm.addRow(row);
            }
        } catch (Exception e) {
        }
        return tm;
    }
    
    public void agregar(String nombre, String precio){
        p=new Producto(nombre, Double.valueOf(precio));
        try {
            if (ob.agregar(p)>0) {
                JOptionPane.showMessageDialog(null, "Registro guardado "
                        + "completamente");
                }
            else
                    JOptionPane.showMessageDialog(null, "Registro no guardado "
                        + "completamente");
        } catch (Exception e) {
        }
    }
    
    public void modificar(String id,String nombre, String precio){
       p=new Producto(Integer.parseInt(id), nombre, Double.parseDouble(precio));
        try {
            if (ob.modificarar(p)>0) {
                JOptionPane.showMessageDialog(null, "Registro modificado "
                        + "correctamente");
                }
            else
                    JOptionPane.showMessageDialog(null, "Registro no modificado "
                        + "correctamente");
        } catch (Exception e) {
        }
    }
    
    public void eliminar(String id){
       p=new Producto(Integer.parseInt(id));
        try {
            if (ob.eliminar(p)>0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado "
                        + "correctamente");
                }
            else
                    JOptionPane.showMessageDialog(null, "Registro no eliminado "
                        + "correctamente");
        } catch (Exception e) {
        }
    }
}
