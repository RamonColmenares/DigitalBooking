package com.example.piG1.Model;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PolicyDTO {
    public Integer id;
    public List<TypeOfPolicy> typeOfPolicies;
}
