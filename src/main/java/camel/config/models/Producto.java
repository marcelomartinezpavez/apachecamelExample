package camel.config.models;

public class Producto {
    private String nombreProducto;
    private String categoriaProducto;

    public Producto(String nombreProducto, String categoriaProducto) {
        super();
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getCategoriaProducto() {
        return categoriaProducto;
    }
    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }
}
