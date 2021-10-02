package Controlador;

import Modelo.Consultas;
import java.sql.ResultSet;

public class Controlador {
    Consultas consultas = new Consultas();

    public void Selector(int opcion){
        switch (opcion){
            case 1: ListarProductos();
            break;
            case 2:ListarVentasPorMes();
            break;
            case 3: ListarProductosNoVendidos();
            break;
            case 4: ListarFacturasPorCliente();
            break;
            default:
                System.out.println("Numero seleccionado no valido");
        }
    }

    public void ListarProductos(){
        ResultSet rs = consultas.getProducto();

        try{
            while(rs.next()){
                String codigo = rs.getString("codigo");
                String valor = rs.getString("valor");
                String costo = rs.getString("costo");
                String nombre = rs.getString("nombre");
                System.out.println("codigo: "+codigo+" | nombre: "+nombre+" | valor: "+valor+" | costo: "+costo);
            }

        }catch (Exception e){
            System.out.println("error: " + e);
        }
    }

    public void ListarVentasPorMes(){
        ResultSet rs = consultas.getVentasPorMes();

        try{
            while(rs.next()){
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String cantidad = rs.getString("cantidad");
                String total_en_pesos = rs.getString("total_en_pesos");
                System.out.println("codigo: "+codigo+" | nombre: "+nombre+" | cantidad: "+cantidad+" | total en pesos: "+total_en_pesos);
            }

        }catch (Exception e){
            System.out.println("error: " + e);
        }

    }

    public void ListarProductosNoVendidos(){
        ResultSet rs = consultas.getProductosNoVendidos();

        try{
            while(rs.next()){
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String unidad = rs.getString("unidad");
                String valor = rs.getString("valor");
                String fechavenci = rs.getString("fechavenci");
                System.out.println("codigo: "+codigo+" | nombre: "+nombre+" | unidad: "+unidad+" | valor: "+valor+" | fecha vencimiento"+fechavenci);
            }

        }catch (Exception e){
            System.out.println("error: " + e);
        }
    }

    public void ListarFacturasPorCliente(){
        ResultSet rs = consultas.getFacturasPorCliente();

        try{
            while(rs.next()){
                String cliente = rs.getString("cliente");
                String nom_cliente = rs.getString("nom_cliente");
                String valor_acumulado = rs.getString("valor_acumulado");
                String cantidad_facturas = rs.getString("cantidad_facturas");
                System.out.println("cliente cod.: "+cliente+" | nombre: "+nom_cliente+" | valor acumulado: "+valor_acumulado+" | cantidad facturas: "+cantidad_facturas);
            }

        }catch (Exception e){
            System.out.println("error: " + e);
        }
    }

}
