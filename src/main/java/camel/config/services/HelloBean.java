package camel.config.services;

public class HelloBean {

    public ResponseType sayHello() {
        ResponseType responseType = new ResponseType("Hello, world!");
        return responseType;
    }
}
