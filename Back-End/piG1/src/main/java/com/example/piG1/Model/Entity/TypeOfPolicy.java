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
@Table(name = "typeOfPolicies")
public class TypeOfPolicy {
    @Id
    @SequenceGenerator(name = "type_of_policy_sequence", sequenceName = "type_of_policy_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_of_policy_sequence")
    public Integer id;
    @Column(name="title")
    public String title;
    @Column(name="description")
    public String description;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "policy_id")
//    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
//    private Policy policy;
}
