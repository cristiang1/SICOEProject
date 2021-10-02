package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Consultas {

    public ResultSet getProducto(){
        Connection conexion = Conexion.getConnection();
        ResultSet rs = null;

        try{
            Statement stm = conexion.createStatement();
            rs = stm.executeQuery("select codigo, nombre, valor, costo from producto");
            conexion.close();

        }catch(Exception e){
            System.out.println("Error al ejecutar la consulta: "+e);
        }

        return rs;
    }

    public ResultSet getVentasPorMes(){
        Connection conexion = Conexion.getConnection();
        ResultSet rs = null;

        try{
            Statement stm = conexion.createStatement();
            rs = stm.executeQuery("select p.nombre, p.codigo, fi.cantidad,(fi.cantidad*fi.cantidad) total_en_pesos from producto p inner join facturaitem fi on(p.codigo= fi.producto) inner join factura f on(fi.numero = f.numero) where f.fecha between to_timestamp('2020-07-01 00:00:00','YYYY-MM-DD H24:MI:SS') AND to_timestamp('2020-07-31 23:59:59','YYYY-MM-DD H24:MI:SS')");
            conexion.close();

        }catch(Exception e){
            System.out.println("Error al ejecutar la consulta: "+e);
        }

        return rs;
    }

    public ResultSet getProductosNoVendidos(){
        Connection conexion = Conexion.getConnection();
        ResultSet rs = null;

        try{
            Statement stm = conexion.createStatement();
            rs = stm.executeQuery("select p.codigo, p.nombre, p.unidad, valor, fechavenci from producto p where not exists (select null from facturaitem fi where p.codigo = fi.producto and fi.fecha between to_timestamp('2020-07-01 00:00:00','YYYY-MM-DD H24:MI:SS') AND to_timestamp('2020-07-31 23:59:59','YYYY-MM-DD H24:MI:SS'))");
            conexion.close();

        }catch(Exception e){
            System.out.println("Error al ejecutar la consulta: "+e);
        }

        return rs;
    }

    public ResultSet getFacturasPorCliente(){
        Connection conexion = Conexion.getConnection();
        ResultSet rs = null;

        try{
            Statement stm = conexion.createStatement();
            rs = stm.executeQuery("select cliente, nom_cliente, sum(valor) valor_acumulado, count(numero) cantidad_facturas from factura where fecha between to_timestamp('2020-01-01 00:00:00','YYYY-MM-DD H24:MI:SS') AND to_timestamp('2020-07-31 23:59:59','YYYY-MM-DD H24:MI:SS') group by cliente, nom_cliente, valor;");
            conexion.close();

        }catch(Exception e){
            System.out.println("Error al ejecutar la consulta: "+e);
        }

        return rs;
    }
}


