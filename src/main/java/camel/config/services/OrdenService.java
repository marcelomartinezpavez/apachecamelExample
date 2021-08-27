package camel.config.services;

import java.util.ArrayList;
import java.util.List;

import camel.config.models.Orden;
import camel.config.models.LineaParaOrden;
import camel.config.models.Producto;

public class OrdenService {

    public double getPrecio(final String NombreProducto) {
        return 2.4;
    }

    public List<LineaParaOrden> generarOrden() {

        List<LineaParaOrden> lineaParaOrdens = new ArrayList<LineaParaOrden>();

        LineaParaOrden lineaParaOrden = new LineaParaOrden();
        lineaParaOrden.setProducto(new Producto("Television", "Electronicos"));

        lineaParaOrdens.add(lineaParaOrden);

        lineaParaOrden = new LineaParaOrden();
        lineaParaOrden.setProducto(new Producto("Lavadora", "Hogar"));

        lineaParaOrdens.add(lineaParaOrden);
        return lineaParaOrdens;
    }

    public List<Orden> getOrders() {
        List<Orden> ordens = new ArrayList<Orden>();
        Orden orden = new Orden();
        orden.setOrdenNo("ORD-001");
        orden.setFechaOrden("26/08/2021");
        ordens.add(orden);
        return ordens;
    }
}
