package com.example.piG1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @SequenceGenerator(name = "policy_sequence", sequenceName = "policy_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_sequence")
    public Integer id;

    @OneToMany(mappedBy = "policy", fetch = FetchType.LAZY)
    @JsonIgnore
    public List<TypeOfPolicy> typeOfPolicies = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Product product;
}
