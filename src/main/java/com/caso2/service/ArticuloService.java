
package com.caso2.service;

import com.caso2.domain.Articulo;
import java.util.ArrayList;
import java.util.List;

public interface ArticuloService 
{
    public List<Articulo> listaArticulos=new ArrayList<>();
    
    public List<Articulo> getArticulos();
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    public Articulo getArticulo(Articulo articulo);
    
}
