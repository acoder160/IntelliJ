package org.masacda.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class LibroDto {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotEmpty(message = "Debe haber al menos un género")
    private List<String> generos;

    @NotNull(message = "El año de publicación es obligatorio")
    @Min(value = 1000, message = "El año debe ser válido")
    private Integer anyoPublicacion;

    @NotNull(message = "Indica si está disponible")
    private Boolean disponible;

    @Min(value = 1, message = "El libro debe tener páginas")
    private Integer numPaginas;

    @DecimalMin(value = "0.0", message = "La valoración mínima es 0.0")
    @DecimalMax(value = "10.0", message = "La valoración máxima es 10.0")
    private Double valoracionMedia;

    // Opcional
    private List<String> etiquetas;

    // Constructores, Getters y Setters
    public LibroDto() {}

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public List<String> getGeneros() { return generos; }
    public void setGeneros(List<String> generos) { this.generos = generos; }
    public Integer getAnyoPublicacion() { return anyoPublicacion; }
    public void setAnyoPublicacion(Integer anyoPublicacion) { this.anyoPublicacion = anyoPublicacion; }
    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
    public Integer getNumPaginas() { return numPaginas; }
    public void setNumPaginas(Integer numPaginas) { this.numPaginas = numPaginas; }
    public Double getValoracionMedia() { return valoracionMedia; }
    public void setValoracionMedia(Double valoracionMedia) { this.valoracionMedia = valoracionMedia; }
    public List<String> getEtiquetas() { return etiquetas; }
    public void setEtiquetas(List<String> etiquetas) { this.etiquetas = etiquetas; }
}