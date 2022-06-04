package com.example.piG1.Model.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductAddFeaturesDTO {
    private Integer productId;
    private List<FeatureDTO> listFeatures;
}
