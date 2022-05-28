package com.example.piG1.model;

import lombok.*;

import javax.persistence.*;

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

}
