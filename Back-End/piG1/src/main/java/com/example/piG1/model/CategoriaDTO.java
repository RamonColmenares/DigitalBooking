package com.example.piG1.model;

import lombok.Getter;
import lombok.Setter;

///aca va lo que voy a mostrar por pantalla cuando lo llame
@Getter
@Setter
public class CategoriaDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String url;
}
