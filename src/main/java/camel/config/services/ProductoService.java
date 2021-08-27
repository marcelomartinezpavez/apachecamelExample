package camel.config.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import camel.config.models.LineaParaOrden;
import camel.config.models.Producto;

@Service
public class ProductoService {

    public double getPrecio(final String nombreProducto) {

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

    public List<Producto> fetchProductsByCategory(final String category) {
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto("Television","Electronicos"));
        productos.add(new Producto("Lavadora","Hogar"));
        return productos;
    }
}
