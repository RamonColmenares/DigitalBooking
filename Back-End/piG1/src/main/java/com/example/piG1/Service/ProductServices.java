package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.FeatureDTO.FeatureDTO;
import com.example.piG1.Model.DTO.ImageDTO.ImageDTO;
import com.example.piG1.Model.DTO.PolicyDTO.PolicyAndTypeOfPolicyDTO;
import com.example.piG1.Model.DTO.PolicyDTO.PolicyDTO;
import com.example.piG1.Model.DTO.ProductDTO.*;
import com.example.piG1.Model.Entity.*;
import com.example.piG1.Repository.*;
import com.example.piG1.Service.IService.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Log4j
@Service
public class ProductServices implements IProductServices {
    protected final static Logger logger = Logger.getLogger(ProductServices.class);

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICityRepository cityRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private IImageServices imageServices;
    @Autowired
    private IBookingServices bookingServices;
    @Autowired
    private IPolicyServices policyServices;
    @Autowired
    private IFeatureServices featureServices;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ProductCompliteDTO saveComplite(ProductDTO productDTO) {
        Product product = mapper.convertValue(productDTO, Product.class);
        Optional <City> city = cityRepository.findById(productDTO.getCity_id());
        Optional <Category> category = categoryRepository.findById(productDTO.getCategory_id());
        product.setCategory(category.get());
        product.setCity(city.get());

        product = productRepository.save(product);
        System.out.println(product);
//        log.info(product);
        return mapper.convertValue(product, ProductCompliteDTO.class);
    }

    @Override
    public ProductCompliteDTO addImages(ProductAddImagesDTO productAddImagesDTO) {
        //obtengo el producto
        Optional <Product> product = productRepository.findById(productAddImagesDTO.getProductId());
        List <Image> listImage = new ArrayList<>();
        for (ImageDTO imageDTO: productAddImagesDTO.getListImages()){
            Image  image = mapper.convertValue(imageDTO, Image.class);
            image.setProduct(product.get());
            listImage.add(image);
        }
        imageServices.saveImages(listImage);
        //ya debe tener imagenes
        product = productRepository.findById(productAddImagesDTO.getProductId());
        return  mapper.convertValue(product, ProductCompliteDTO.class);
    }

    @Override
    public ProductCompliteDTO addPolicies(ProductAddPoliciesDTO productAddPoliciesDTO) {
        //obtengo el producto
        Optional <Product> product = productRepository.findById(productAddPoliciesDTO.getProductId());
        List <Policy> policiesList = new ArrayList<>();
        for (PolicyDTO policyDTO: productAddPoliciesDTO.getListPolicies()){
            Policy  policy = mapper.convertValue(policyDTO, Policy.class);
            policy.setProduct(product.get());
            policiesList.add(policy);
        }
        policyServices.savePolicies(policiesList);
        //ya debe tener imagenes
        product = productRepository.findById(productAddPoliciesDTO.getProductId());
        return  mapper.convertValue(product, ProductCompliteDTO.class);
    }

    @Override
    public ProductCompliteDTO addFeatures (ProductAddFeaturesDTO productAddFeaturesDTO) {
        //obtengo el producto
        Optional <Product> product = productRepository.findById(productAddFeaturesDTO.getProductId());
        List <Feature> featureList = new ArrayList<>();
        for (FeatureDTO featureDTO: productAddFeaturesDTO.getListFeatures()){
            Feature  feature = mapper.convertValue(featureDTO, Feature.class);
            feature.setProduct(product.get());
            featureList.add(feature);
        }
        featureServices.saveFeatures(featureList);
        product = productRepository.findById(productAddFeaturesDTO.getProductId());
        return  mapper.convertValue(product, ProductCompliteDTO.class);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapper.convertValue(productDTO, Product.class);
        product = productRepository.save(product);
        return mapper.convertValue(product, ProductDTO.class);
    }

    @Override
    public ProductFullDTO findById(Integer id) throws ResourceNotFoundException {
        Product product = checkId(id);
        System.out.println(product);
        ProductFullDTO productFullDTO = mapper.convertValue(product, ProductFullDTO.class);
        List<ImageDTO> imagesList = imageServices.findByProductId(id);
        productFullDTO.setImages(imagesList);

        List<PolicyAndTypeOfPolicyDTO> policyAndTypeOfPolicyDTO = policyServices.findByProductId(id);
        productFullDTO.setPolicies(policyAndTypeOfPolicyDTO);

        List<FeatureDTO> featuresDTO = featureServices.findByProductId(id);
        productFullDTO.setFeatures(featuresDTO);
        return productFullDTO;
    }

    @Override
    public ProductCompliteDTO findByIdComplite(Integer id) throws ResourceNotFoundException {
        Product product = checkId(id);
        logger.info("La busqueda fue exitosa: id " + id);
        return mapper.convertValue(product, ProductCompliteDTO.class);
    }

    @Override
    public List<GetProductsAllDTO> findAll() throws ResourceNotFoundException {
        List<GetProductsAllDTO>  getProductsAllDTO= new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for(Product product: products){
            GetProductsAllDTO getProductsAllDTO1 = mapper.convertValue(product, GetProductsAllDTO.class);
            List<PolicyAndTypeOfPolicyDTO> policyAndTypeOfPolicyDTO = policyServices.findByProductId(product.getId());
            getProductsAllDTO1.setPolicies(policyAndTypeOfPolicyDTO);
            System.out.println(getProductsAllDTO1);
            List<ImageDTO> imagesList = imageServices.findByProductId(product.getId());
            String url_image = imagesList.get(0).getUrl();
            getProductsAllDTO1.setImageUrl(url_image);
            getProductsAllDTO.add(getProductsAllDTO1);
        }
        getProductsAllDTO .sort(Comparator.comparing(GetProductsAllDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ getProductsAllDTO);
        return getProductsAllDTO;
    }
    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        checkId(id);
        productRepository.deleteById(id);
        logger.info("Se elimino el producto correctamente con el id("+id+")");
    }

    @Override
    public Product checkId(Integer id) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException(messageError + id);
        }
        return product.get();
    }

    @Override
    public List<ProductFindByFilterDTO> findByCityId(Integer cityId) throws ResourceNotFoundException {
        List<ProductFindByFilterDTO> productsFindByFilterDTO = new ArrayList<>();
        List<Product> products = productRepository.findByCityId(cityId);
        for(Product product: products){
            ProductFindByFilterDTO productFindByFilterDTO = mapper.convertValue(product, ProductFindByFilterDTO.class);
            Integer productId = product.getId();
            List<ImageDTO> imagesList = imageServices.findByProductId(productId);
            productFindByFilterDTO.setImages(imagesList);
            productsFindByFilterDTO.add(productFindByFilterDTO);
        }
        productsFindByFilterDTO .sort(Comparator.comparing(ProductFindByFilterDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ productsFindByFilterDTO);
        return productsFindByFilterDTO;
    }

    @Override
    public List<ProductFindByFilterDTO> findByCategoryId(Integer categoryId) throws ResourceNotFoundException {
        List<ProductFindByFilterDTO> productsFindByFilterDTO = new ArrayList<>();
        List<Product> products = productRepository.findByCityId(categoryId);
        for(Product product: products){
            ProductFindByFilterDTO productFindByFilterDTO = mapper.convertValue(product, ProductFindByFilterDTO.class);
            Integer productId = product.getId();
            List<ImageDTO> imagesList = imageServices.findByProductId(productId);
            productFindByFilterDTO.setImages(imagesList);
            productsFindByFilterDTO.add(productFindByFilterDTO);
        }
        productsFindByFilterDTO .sort(Comparator.comparing(ProductFindByFilterDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ productsFindByFilterDTO);
        return productsFindByFilterDTO;
    }
}
