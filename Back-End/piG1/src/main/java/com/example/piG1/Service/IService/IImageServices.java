package com.example.piG1.Service.IService;

import com.example.piG1.Model.Category;
import com.example.piG1.Model.Image;
import com.example.piG1.Model.ImageDTO;
import com.example.piG1.Service.ICheckId;
import com.example.piG1.Service.IServices;

public interface IImageServices extends IServices<ImageDTO>, ICheckId<Image> {
}
