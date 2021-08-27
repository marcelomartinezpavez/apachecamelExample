package camel.config.routes;

import camel.config.services.PrecioService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import camel.config.services.OrdenService;

@Component
public class RestApiRoute extends RouteBuilder{
    @Autowired
    private Environment env;

    @Override
    public void configure() throws Exception {
        CamelContext context = new DefaultCamelContext();

        restConfiguration()
                .component("servlet")
                .host("localhost")
                .port(8080)
                .contextPath("/api")
                .apiContextPath("/v1")
                .apiProperty("api.title", "JAVA DEV JOURNAL REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .bindingMode(RestBindingMode.json);

        rest("/orden/procesar")
                .get("/").description("Process order")
                .route().routeId("ordens-process")
                .bean(OrdenService.class, "generarOrden")
                .to("direct:fetchProducts")
                .endRest();

        rest("/orden/precio")
                .get("/").description("orden Precio")
                .route().routeId("ordens-precio")
                .bean(PrecioService.class, "calucarPrecio")
                .to("direct:fetchProcess")
                .endRest();
        /*
         * rest("/ordens/") .id("api-route") .consumes("application/json")
         * .post("/bean") .bindingMode(RestBindingMode.json_xml) .type(Order.class)
         * .to("direct:remoteService");
         */

    }
}
