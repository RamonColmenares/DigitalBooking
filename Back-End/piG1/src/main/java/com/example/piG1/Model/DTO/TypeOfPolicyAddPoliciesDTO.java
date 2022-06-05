package com.example.piG1.Model.DTO;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TypeOfPolicyAddPoliciesDTO {
    private Integer typeOfPolicyId;
    private Integer productId;
    private List<PolicyDTO> listPolicies;
}
