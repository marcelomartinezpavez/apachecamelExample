package camel.config.routes;

import camel.config.services.HelloBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import camel.config.services.ProductoService;

@Component
public class FetchProductsRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:fetchProducts")
                .routeId("direct-fetchProducts")
                .tracing()
                .log(">>> ${body}")
                .bean(ProductoService.class, "fetchProductsByCategory")
                .end();

        from("direct:hello").routeId("hello").tracing().log(">>> ${body}").end();


        rest("/hello")
                .get("/").description("hello")
                .route().routeId("hello-api")
                .bean(HelloBean.class, "sayHello")
                .to("direct:hello").endRest();
        rest("/say/hello")
                .get().route().transform().constant("Hello World");
    }
}
