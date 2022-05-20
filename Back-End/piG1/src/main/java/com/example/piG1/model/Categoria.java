package com.example.piG1.model;
//este paquete lo importo para hacer el MAPEO
import javax.persistence.*;
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

//    constructor vacio por si lo necesito en algun metodo
    public Categoria(){
    }


//    constructor con id por si lo necesito
    public Categoria(Integer id, String titulo, String descripcion, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
    }


//    constructor SIN id por si lo necesito
    public Categoria(String titulo, String descripcion, String url) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
    }

    //getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
