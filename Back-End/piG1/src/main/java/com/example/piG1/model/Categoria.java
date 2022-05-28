package com.example.piG1.model;
//este paquete lo importo para hacer el MAPEO
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//le indico que es una entidad donde van a persistir los datos
@Entity
//como se va a llamar mi tabla de esa entidad
@Table(name = "categorias")
public class Categoria {
    //para q sea el identificador de la bbdd
    @Id
    @SequenceGenerator(name = "categoria_sequence", sequenceName = "categoria_sequence", allocationSize = 1)
    //si no le paso el id que se autogenere
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_sequence")
    private Integer id;
    private String titulo;
    private String descripcion;
    private String url;

    //aca se van a marcar las relaciones MAS ADELANTE con oneToMany
    //y el JsonIgnore, para que no entre en el loop infinito (de completar la propiedad, q cuando sea json la ignore)
//    constructor SIN id por si lo necesito
//    public Categoria(String titulo, String descripcion, String url) {
//        this.titulo = titulo;
//        this.descripcion = descripcion;
//        this.url = url;
//    }
}
