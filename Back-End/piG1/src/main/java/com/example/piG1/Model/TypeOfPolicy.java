package com.example.piG1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "typeOfPolicy")
public class TypeOfPolicy {
    @Id
    @SequenceGenerator(name = "typeOfPolicy_sequence", sequenceName = "typeOfPolicy_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeOfPolicy_sequence")
    public Integer id;
    @Column(name="title")
    public String title;
    @Column(name="description")
    public String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "policy_id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Policy policy;
}
