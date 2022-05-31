package com.example.piG1.Service.IService;

import com.example.piG1.Model.Category;
import com.example.piG1.Model.Product;
import com.example.piG1.Model.ProductDTO;
import com.example.piG1.Service.ICheckId;
import com.example.piG1.Service.IServices;

public interface IProductServices extends IServices<ProductDTO>, ICheckId<Product> {
}
