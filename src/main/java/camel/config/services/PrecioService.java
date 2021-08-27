package camel.config.services;

import camel.config.models.Producto;
import org.springframework.stereotype.Service;

import camel.config.models.LineaParaOrden;

@Service
public class PrecioService {

    public LineaParaOrden calucarPrecio(){
        LineaParaOrden lineaParaOrden = new LineaParaOrden();
        Producto producto = new Producto("café","Hogar");
        lineaParaOrden.setPrecio(2.34);
        lineaParaOrden.setProducto(producto);
        lineaParaOrden.setNumeroDeUnidades(22);
        return calculaPrecio(lineaParaOrden);
    }

    public LineaParaOrden calculaPrecio(final LineaParaOrden lineaParaOrden) {
        System.out.println("calculaPrecio orden");

        String category = lineaParaOrden.getProducto().getCategoriaProducto();
        if("Electronicos".equalsIgnoreCase(category))
            lineaParaOrden.setPrecio(300.0);
        else if("Hogar".equalsIgnoreCase(category))
            lineaParaOrden.setPrecio(55.0);
        else
            lineaParaOrden.setPrecio(99.0);
        return lineaParaOrden;

    }
}
