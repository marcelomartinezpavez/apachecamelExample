package camel.config.routes;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import camel.config.services.PrecioAggregationStrategy;

@Component
public class OrderProcessingRoute extends RouteBuilder {

    @Autowired
    private PrecioAggregationStrategy priceAggregationStrategy;

    @Override
    public void configure() throws Exception {
        from("direct:fetchProcess")
                .split(body(), (AggregationStrategy) priceAggregationStrategy).parallelProcessing()
                .to("bean:precioService?method=calucarPrecio")
                .end();
    }
}
