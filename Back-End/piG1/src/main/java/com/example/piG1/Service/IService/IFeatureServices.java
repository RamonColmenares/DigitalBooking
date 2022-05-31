package com.example.piG1.Service.IService;

import com.example.piG1.Model.Category;
import com.example.piG1.Model.Feature;
import com.example.piG1.Model.FeatureDTO;
import com.example.piG1.Service.ICheckId;
import com.example.piG1.Service.IServices;

public interface IFeatureServices extends IServices<FeatureDTO>, ICheckId<Feature> {
}
