package com.example.piG1.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "policies")
public class Policy {
//    @Id
//    @SequenceGenerator(name = "policy_sequence", sequenceName = "policy_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_sequence")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name="description")
    public String description;
//    @ManyToOne(mappedBy = "policy", fetch = FetchType.LAZY)
//    @JsonIgnore
//    public List<TypeOfPolicy> typeOfPolicies = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "type_of_policy_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public TypeOfPolicy typeOfPolicy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Product product;
}
