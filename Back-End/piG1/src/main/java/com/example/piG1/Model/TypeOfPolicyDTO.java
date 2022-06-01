package com.example.piG1.Model;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TypeOfPolicyDTO {
    public Integer id;
    public String title;
    public String description;
}
