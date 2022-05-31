package com.example.piG1.model;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FeatureDTO {
    public Integer id;
    public String name;
    public String icon;
}
