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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name="title")
    public String title;
    @Column(name="description")
    public String description;
}
