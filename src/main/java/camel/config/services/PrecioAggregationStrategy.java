package camel.config.services;

import java.time.Instant;
import java.util.UUID;

import camel.config.models.Orden;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import camel.config.models.LineaParaOrden;

@Component
public class PrecioAggregationStrategy implements AggregationStrategy{

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        LineaParaOrden newBody = newExchange.getIn().getBody(LineaParaOrden.class);
        if (oldExchange == null) {
            Orden orden = new Orden();
            orden.setOrdenNo(UUID.randomUUID().toString());
            orden.setFechaOrden(Instant.now().toString());
            orden.setPrecioOrden(newBody.getPrecio());
            orden.addLineaParaOrden(newBody);

            newExchange.getIn().setBody(orden, Orden.class);
            return newExchange;
        }
        LineaParaOrden newLineaParaOrden = newExchange.getIn().getBody(LineaParaOrden.class);
        Orden orden = oldExchange.getIn().getBody(Orden.class);
        orden.setPrecioOrden(orden.getPrecioOrden() + newLineaParaOrden.getPrecio());
        orden.addLineaParaOrden(newLineaParaOrden);
        oldExchange.getIn().setBody(orden);

        return oldExchange;
    }
}
