package com.example.piG1.Service.IService;

import com.example.piG1.Model.Policy;
import com.example.piG1.Model.PolicyDTO;
import com.example.piG1.Service.ICheckId;
import com.example.piG1.Service.IServices;

public interface IPolicyServices extends IServices<PolicyDTO>, ICheckId<Policy> {
}
