package camel.config.models;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private String ordenNo;
    private String fechaOrden;

    private List<LineaParaOrden> lineasParaOrden;

    private double descuentoTotal;

    private double precioOrden;

    public String getOrdenNo() {
        return ordenNo;
    }

    public void setOrdenNo(String ordenNo) {
        this.ordenNo = ordenNo;
    }

    public String getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(String fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public List<LineaParaOrden> getLineasParaOrden() {
        return lineasParaOrden;
    }

    public void setLineasParaOrden(List<LineaParaOrden> lineaParaOrdens) {
        this.lineasParaOrden = lineaParaOrdens;
    }

    public double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public double getPrecioOrden() {
        return precioOrden;
    }

    public void setPrecioOrden(double precioOrden) {
        this.precioOrden = precioOrden;
    }

    public void addLineaParaOrden(LineaParaOrden lineaParaOrden) {
        if(lineasParaOrden == null) lineasParaOrden = new ArrayList<LineaParaOrden>();
        lineasParaOrden.add(lineaParaOrden);
    }
}
