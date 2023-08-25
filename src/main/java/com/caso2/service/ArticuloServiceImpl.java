
package com.caso2.service;

import com.caso2.domain.Articulo;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService
{
    public ArticuloServiceImpl() {
        listaArticulos.add(new Articulo(1, "Celular", 4));
        listaArticulos.add(new Articulo(2, "Computadora", 8));
    }

    @Override
    public void save(Articulo articulo) {
        var indice = -1;
        for (var a : listaArticulos) {
            indice++;
            if (Objects.equals(a.getId_articulo(), articulo.getId_articulo())) {
                listaArticulos.remove(indice);
                break;
            }
        }
        listaArticulos.add(articulo);
    }

    @Override
    public void delete(Articulo articulo) {
        int indice = -1;
        for (var a : listaArticulos) {
            indice++;
            if (Objects.equals(a.getId_articulo(), articulo.getId_articulo())) {
                listaArticulos.remove(indice);
                break;
            }
        }
    }

    @Override
    public Articulo getArticulo(Articulo articulo) {
        for (var a : listaArticulos) {
            if (Objects.equals(a.getId_articulo(), articulo.getId_articulo())) {
                return a;
            }
        }
        return null;
    }

    @Override
    public List<Articulo> getArticulos() {
        return listaArticulos;
    }
    
}
