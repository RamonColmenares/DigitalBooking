package com.example.piG1.service.IService;

import com.example.piG1.model.Categoria;
import com.example.piG1.model.CategoriaDTO;
import com.example.piG1.model.Producto;
import com.example.piG1.model.ProductoDTO;

import java.util.List;

public interface IProductoService {
    public Producto crearProducto (ProductoDTO productoDTO);
    public ProductoDTO listarProducto(Integer id);
    public Producto editarProducto (ProductoDTO productoDTO);
    public void eliminarProducto (Integer id);
    public List<ProductoDTO> listarProductos();
}
