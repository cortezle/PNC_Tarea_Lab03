package com.uca.inventarioProducto.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.inventarioProducto.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/productos")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0,"The Shinning","237"));
		productos.add(new Product(1,"11/22/63","63"));
		productos.add(new Product(2,"1984","3"));
		productos.add(new Product(3,"Star Wars","66"));
		productos.add(new Product(4,"The Magicians","5"));
		
		mav.setViewName("producto");
		mav.addObject("product", new Product());
		mav.addObject("producto",productos);
		
		
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product producto) {
		ModelAndView mav = new ModelAndView();
		
		int cantI = Integer.parseInt(productos.get(producto.getId()).getCantidad());
		int cantD = Integer.parseInt(producto.getCantidad());
		if(cantD > cantI) {
			//no se puede
			mav.addObject("error", productos.get(producto.getId()).getNombre() );
			mav.setViewName("error");
		}
		else {
			//compra
			mav.addObject("compra", productos.get(producto.getId()).getNombre() );
			mav.setViewName("compra");
		}
		return mav;
}
	}

