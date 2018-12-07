package com.vot.services;

import com.vot.model.Categoria;
import com.vot.model.Marca;
import com.vot.model.Producto;

public interface ProductService {

Iterable<Producto> listAllProducts();
Producto getProductoById(Integer id);
Producto saveProduct(Producto producto);
void deleteProduct(Integer id);

Iterable<Marca> listAllMarcas();
Iterable<Categoria> listAllCategorias();

Iterable<Producto> findByNombreproducto(String nombreproducto);
Iterable<Producto> findByMarca(Marca marca);
Iterable<Producto> findByCategoria(Categoria categoria);
Iterable<Producto> findByNombreproductoAndMarca(String nombreproducto,Marca marca);
Iterable<Producto> findByNombreproductoAndCategoria(String nombreproducto,Categoria categoria);
Iterable<Producto> findByMarcaAndCategoria(Marca marca,Categoria categoria);
Iterable<Producto> findByNombreproductoAndMarcaAndCategoria(String nombreproducto,Marca marca,Categoria categoria);

}
