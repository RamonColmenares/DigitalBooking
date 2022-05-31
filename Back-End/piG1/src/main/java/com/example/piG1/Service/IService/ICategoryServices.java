package com.example.piG1.Service.IService;

import com.example.piG1.Model.Category;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Service.ICheckId;
import com.example.piG1.Service.IServices;

public interface ICategoryServices extends IServices<CategoryDTO>, ICheckId<Category> {

}
