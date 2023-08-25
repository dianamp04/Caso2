
package com.caso2.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Articulo 
{
    private int id_articulo;
    private String detalle;
    private int cantidad;
    private String fecha_vence;

    public Articulo() {
    }

    public Articulo(int id_articulo, String detalle, int cantidad) {
        this.id_articulo = id_articulo;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.fecha_vence = ""+(new Date());
    }
    
}
