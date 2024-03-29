
package com.caso2.controller;

import com.caso2.domain.Articulo;
import com.caso2.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticuloController {
    
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/articulo/agregar/{idArticulo}")
    public String agregarArticulo(Model model, Articulo articulo) {
        articuloService.save(articulo);
        var lista = articuloService.getArticulos();
        model.addAttribute("listaArticulos", lista);
        return "";
    }

    @GetMapping("/articulo/listado")
    public String listado(Model model) {
        var articulos = articuloService.getArticulos();
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos", articulos.size());
        return "/articulo/listado";
    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo, Model model) {
        articuloService.save(articulo);
        var articulos = articuloService.getArticulos();
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos", articulos.size());
        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo, Model model) {
        articuloService.delete(articulo);
        var articulos = articuloService.getArticulos();
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos", articulos.size());
        return "redirect:/articulo/listado";
    }
}
