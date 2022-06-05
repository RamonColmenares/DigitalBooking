package com.example.piG1.Model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PolicyAndProductDTO {
    private Integer id;
    private Integer productId;
    private String description;
}
