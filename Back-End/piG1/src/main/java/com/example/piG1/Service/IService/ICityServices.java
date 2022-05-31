package com.example.piG1.Service.IService;

import com.example.piG1.Model.Category;
import com.example.piG1.Model.City;
import com.example.piG1.Model.CityDTO;
import com.example.piG1.Service.ICheckId;
import com.example.piG1.Service.IServices;

public interface ICityServices  extends IServices<CityDTO>, ICheckId<City> {
}
