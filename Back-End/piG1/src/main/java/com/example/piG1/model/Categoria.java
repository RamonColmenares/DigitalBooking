package com.example.piG1.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "categorias")
public class Categoria {
    @Id
    @SequenceGenerator(name = "categoria_sequence", sequenceName = "categoria_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_sequence")
    private Integer id;
    private String titulo;
    private String descripcion;
    private String url;
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Producto> productos = new ArrayList<>();
}
