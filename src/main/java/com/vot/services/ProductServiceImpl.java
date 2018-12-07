package com.vot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vot.model.Categoria;
import com.vot.model.Marca;
import com.vot.model.Producto;

import com.vot.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productrepository;
	
	
	@Override
	@Cacheable("prod")
	public Iterable<Producto> listAllProducts() {
	System.out.println("lista prodctos");	
		return productrepository.findAll();
	}

	@Override
	public Producto getProductoById(Integer id) {
		
		return productrepository.findOne(id);
	}

	@Override
	@CacheEvict(value="prod",allEntries=true)
	public Producto saveProduct(Producto producto) {
		
		return productrepository.save(producto);
	}

	@Override
	public void deleteProduct(Integer id) {

		productrepository.delete(id);
	}
	
	@Override
	public Iterable<Marca> listAllMarcas(){
		return productrepository.listAllMarcas();
		
	}
	
	@Override
	public Iterable<Categoria> listAllCategorias(){
		return productrepository.listAllCategorias();
		
	}
	
	@Override
	public Iterable<Producto> findByNombreproducto(String nombreproducto){
		return productrepository.findByNombreproducto(nombreproducto);
		
	};
	
	@Override
	public Iterable<Producto> findByMarca(Marca marca){
		return productrepository.findByMarca(marca);
		
	};
	
	@Override
	public Iterable<Producto> findByCategoria(Categoria categoria){
		return productrepository.findByCategoria(categoria);
		
	};
	
	@Override
	public Iterable<Producto> findByNombreproductoAndMarca(String nombreproducto,Marca marca){
		return productrepository.findByNombreproductoAndMarca(nombreproducto,marca);
		
	};
	
	@Override
	public Iterable<Producto> findByNombreproductoAndCategoria(String nombreproducto,Categoria categoria){
		return productrepository.findByNombreproductoAndCategoria(nombreproducto,categoria);
		
	};
	
	@Override
	public Iterable<Producto> findByMarcaAndCategoria(Marca marca,Categoria categoria){
		return productrepository.findByMarcaAndCategoria(marca,categoria);
		
	};
	
	@Override
	public Iterable<Producto> findByNombreproductoAndMarcaAndCategoria(String nombreproducto,Marca marca,Categoria categoria){
		return productrepository.findByNombreproductoAndMarcaAndCategoria(nombreproducto,marca,categoria);
		
	};
	
	
}
