package com.example.piG1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ciudades")
public class Ciudad {
    @Id
    @SequenceGenerator(name = "ciudad_sequence", sequenceName = "ciudad_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciudad_sequence")
    public Integer id;
    @Column(name="nombre")
    public String nombre;

    @OneToMany(mappedBy = "ciudad", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Producto> productos = new ArrayList<>();
}
