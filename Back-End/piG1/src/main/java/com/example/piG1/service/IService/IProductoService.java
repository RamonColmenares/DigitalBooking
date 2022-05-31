package com.example.piG1.service.IService;

import com.example.piG1.model.Product;
import com.example.piG1.model.ProductDTO;

import java.util.List;

public interface IProductoService {
    public Product crearProducto (ProductDTO productDTO);
    public ProductDTO listarProducto(Integer id);
    public Product editarProducto (ProductDTO productDTO);
    public void eliminarProducto (Integer id);
    public List<ProductDTO> listarProductos();
}
