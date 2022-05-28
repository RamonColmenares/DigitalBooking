package com.example.piG1.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "imagenes")
public class Imagen {
    @Id
    @SequenceGenerator(name = "imagen_sequence", sequenceName = "imagen_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagen_sequence")
    public Integer id;
    @Column(name="nombre")
    public String nombre;
}
