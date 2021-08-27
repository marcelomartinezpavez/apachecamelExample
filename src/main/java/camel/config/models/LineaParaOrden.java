package camel.config.models;

public class LineaParaOrden {

    private Producto producto;

    private int numeroDeUnidades;

    private double precio;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getNumeroDeUnidades() {
        return numeroDeUnidades;
    }

    public void setNumeroDeUnidades(int numeroDeUnidades) {
        this.numeroDeUnidades = numeroDeUnidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
