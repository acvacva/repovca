package com.vot.controllers;

import java.sql.Timestamp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vot.model.Categoria;
import com.vot.model.Comentario;
import com.vot.model.Marca;
import com.vot.model.Producto;
import com.vot.services.ComentariosService;
import com.vot.services.ProductService;



@Controller
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@Autowired
	private ComentariosService comentariosservice;
	

	
	/*listar  productos segun buscado*/
		
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listByNombreproducto(@RequestParam (value = "searchprod", required = false) String searchprod,
			                           @RequestParam (value = "searchmarca", required = false) Marca searchmarca,
			                           @RequestParam (value = "searchcategoria", required = false) Categoria searchcategoria,
			                           Model model) {
		/*Buscador*/
		
		/*Por producto*/
		if ((searchprod != null)  && (searchmarca == null) && (searchcategoria == null)){ 
	    model.addAttribute("products", productservice.findByNombreproducto(searchprod));
		}
		/*Por marca*/
		if ((searchmarca != null) && ((searchprod.isEmpty()) || searchprod == null ) && (searchcategoria == null) ){
		
	    model.addAttribute("products", productservice.findByMarca(searchmarca));
	    
		}
		/*Por categoria*/
		
		if ((searchcategoria != null) && ((searchprod.isEmpty()) || searchprod == null ) && (searchmarca == null) ){
		model.addAttribute("products", productservice.findByCategoria(searchcategoria));
		}
		
		
		/*Por producto y marca*/
		if (( (searchprod!= null) && !("".equals(searchprod)))   && (searchmarca != null) && (searchcategoria == null)){
			
		model.addAttribute("products", productservice.findByNombreproductoAndMarca(searchprod,searchmarca));
		
		}
		
		
		/*Por producto y categoria*/
		if (((searchprod!= null) && !("".equals(searchprod)))  && (searchcategoria != null) && (searchmarca == null)){
		
		model.addAttribute("products", productservice.findByNombreproductoAndCategoria(searchprod,searchcategoria));
		
		}
		
		/*Por marca y categoria*/
		
		if (((searchprod == null) || ("".equals(searchprod)))  && (searchcategoria != null) && (searchmarca != null)){
			
			model.addAttribute("products", productservice.findByMarcaAndCategoria(searchmarca,searchcategoria));
			
			}
		
		
		/*Por producto, marca y categoria*/
		
		if (((searchprod!= null) && !("".equals(searchprod)))  && (searchcategoria != null) && (searchmarca != null)){
		
		model.addAttribute("products", productservice.findByNombreproductoAndMarcaAndCategoria(searchprod,searchmarca,searchcategoria));
		
		}
		
		/* Mostrar todos*/
		
		if (((searchprod == null) || ("".equals(searchprod)))  && (searchcategoria == null) && (searchmarca == null)){
			
			model.addAttribute("products",productservice.listAllProducts());
		}
	    return "products";
	}
	
	
	
	
	
	/*listar todos los comentarios*/
	@RequestMapping(value= {"/comentarios","/"},method=RequestMethod.GET)
	public String listComentarios(Model model) {
		model.addAttribute("coments",comentariosservice.findAllByOrderByFechaDesc());
	return "comentarios";	
	}
	
	/*listar por mas comentados comentarios*/
	@RequestMapping(value= {"/mascomentados"},method=RequestMethod.GET)
	public String listMasComentados(Model model) {
	
		model.addAttribute("coments",comentariosservice.masComentados());
	return "mascomentados";	
	}
	
	/*listar por mas valorado*/
	@RequestMapping(value= {"/masvalorado"},method=RequestMethod.GET)
	public String listMasValorado(Model model) {
		
		model.addAttribute("coments",comentariosservice.masValorado());
	return "masvalorado";	
	}
	
	
	
	
	
	
	
	/*detalle de un producto y sus comentarios*/
	@RequestMapping(value="/products/{id}",method=RequestMethod.GET)
	public String showProduct(@PathVariable Integer id,Model model) {
		model.addAttribute("products",productservice.getProductoById(id));
		model.addAttribute("coments",productservice.getProductoById(id).getComentarios());
	return "showproduct";	
	}
	
	/*editar un producto*/
	@RequestMapping(value="/products/edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		model.addAttribute("product",productservice.getProductoById(id));
	return "productform";	
	}
	
	
	/*editar un comentario*/
	@RequestMapping(value="/products/editcomentario/{id}")
	public String editcomentario(@PathVariable Integer id,Model model) {
		
		Producto product =productservice.getProductoById(id);
		
		Comentario comentario=new Comentario();
		model.addAttribute("comentario",comentario);
		model.addAttribute("product",product);
		
		
	return "newcomentario";	
	}
		
	/*salva  comentario*/
	
	@RequestMapping(value="/products/editcomentario/{id}",method=RequestMethod.POST)
	public String salvacomentario(@PathVariable String id,Comentario comentario) {
		
		 
		Producto product=productservice.getProductoById(Integer.valueOf(id));		
		comentario.setFecha(new Timestamp(System.currentTimeMillis()));
		comentario.setProducto(product);	  	
		comentariosservice.saveComentario(comentario);
		
	return "products";	
	}
	
	
	/*crear un nuevo producto*/
	@RequestMapping("/product/new")
	public String newProduct(Model model) {
		
				model.addAttribute("listmarcas", productservice.listAllMarcas());
				model.addAttribute("listcategorias", productservice.listAllCategorias());
		        model.addAttribute("product", new Producto());
	return "productform";	
	}
	
	/*crear un nuevo producto*/
	@RequestMapping(value="/product/new",method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Producto product,Model model) {
	
		
		productservice.saveProduct(product);
		model.addAttribute("products",productservice.listAllProducts());
		return "products";	
	}
	

	
	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productservice.deleteProduct(id);;
	return "redirect/products";
	}
	
	/*listar los comentarios de un producto*/
	@RequestMapping(value="/products/coment/{id}",method=RequestMethod.GET)
	public String showComentPorProd(@PathVariable Integer id,Model model) {
		model.addAttribute("coments",productservice.getProductoById(id).getComentarios());
		
	return "comentporprod";	
	}
	
	/*Contacto*/
	@RequestMapping("/contacto")
	public String contacto(Model model) {
		
				
	return "contacto";	
	}
	
}
