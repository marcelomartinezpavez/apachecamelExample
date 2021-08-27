package camel.config;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import camel.config.models.Producto;

@RestController
public class ProductoResource {
    @Autowired
    private ProducerTemplate producerTemplate;

    @GetMapping("/productos/{categoria}")
    @ResponseBody
    public List<Producto> getProductosByCategoria(@PathVariable("categoria") final String categoria) throws Exception {
        producerTemplate.start();
        List<Producto> productos = producerTemplate.requestBody("direct:fetchProducts", categoria, List.class);
        producerTemplate.stop();
        return productos;

    }
}
