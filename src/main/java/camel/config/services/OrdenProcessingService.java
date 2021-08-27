package camel.config.services;

import java.util.List;

import camel.config.models.Orden;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import camel.config.models.LineaParaOrden;

public class OrdenProcessingService {
    @Autowired
    private ProducerTemplate producerTemplate;

    public Orden process(final List<LineaParaOrden> lineaParaOrdens) {
        Orden orden = producerTemplate.requestBody(
                "direct:processOrder", lineaParaOrdens, Orden.class);

        return orden;
    }

}
