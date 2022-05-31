package com.example.piG1.service;

import com.example.piG1.model.*;
import com.example.piG1.repository.*;
import com.example.piG1.service.IService.IProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ProductServices implements IProductoService {
    protected final static Logger logger = Logger.getLogger(ProductServices.class);

    @Autowired
    private IProductRepository productoRepository;
    @Autowired
    private ProductServices productServices;
    @Autowired
    private IImageRepository imagenRepository;
    @Autowired
    private IFeatureRepository caracteristicaRepository;
    @Autowired
    private ICityRepository ciudadRepository;
    @Autowired
    private ICategoryRepository categoriaRepository;

    @Autowired
    ObjectMapper mapper;

    private ProductDTO guardarProducto(ProductDTO productDTO){
        Product product = mapper.convertValue(productDTO, Product.class);
        productoRepository.save(product);
        if (productDTO.getId() == null){
            productDTO.setId(product.getId());
            logger.info("Product registrado correctamente: "+ productDTO);
        }else{
            logger.info("Product actualizado correctamente: "+ productDTO);
        }
        return productDTO;
    }

    @Override
    public Product crearProducto(ProductDTO productDTO) {
        return guardarProducto(productDTO);
    }

    @Override
    public ProductDTO listarProducto(Integer id) {
        Optional<Product> producto = productoRepository.findById(id);
        ProductDTO productDTO = null;
        if (producto.isPresent())
            productDTO = mapper.convertValue(producto, ProductDTO.class);
        return productDTO;
    }

    @Override
    public Product editarProducto(ProductDTO productDTO) {
        return guardarProducto(productDTO);
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> listarProductos() {
        List<Product> products = productoRepository.findAll();
        List<ProductDTO> productosDTO = new ArrayList<>();

        for(Product product : products){
            productosDTO.add(mapper.convertValue(product, ProductDTO.class));
        }
        productosDTO .sort(Comparator.comparing(ProductDTO::getId)); //
        return productosDTO;
    }
}
