package com.example.playlist;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLAYLIST")
public class Playlist {
    
    @Id
    private int codigo;
    private String titulo;
    private String interprete;
    private int cantidadTemas;
    private double duracionTotal;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public int getCantidadTemas() {
        return cantidadTemas;
    }

    public void setCantidadTemas(int cantidadTemas) {
        this.cantidadTemas = cantidadTemas;
    }

    public double getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(double duracionTotal) {
        this.duracionTotal = duracionTotal;
    }
}
