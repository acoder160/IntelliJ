package main.java.org.examenpokemon.model;

/**
 * Clase de modelo que representa un juego de la saga Pokémon.
 * <p>
 * Contiene la información principal del juego, así como el identificador
 * de la plataforma a la que pertenece y, de forma opcional, el nombre de dicha
 * plataforma (rellenado al realizar un JOIN con la tabla <code>plataforma</code>).
 * </p>
 *
 * @author Profesor Oak
 */
public class JuegoPokemon {

    /** Identificador único del juego (clave primaria). */
    private int id;

    /** Título del juego. */
    private String titulo;

    /** Generación del juego (por ejemplo: 1, 2, 3, ...). */
    private int generacion;

    /** Año de lanzamiento del juego. */
    private int anioLanzamiento;

    /** Identificador de la plataforma asociada. */
    private int plataformaId;

    /**
     * Nombre descriptivo de la plataforma.
     * <p>
     * Este campo no se almacena directamente en la tabla <code>juego_pokemon</code>,
     * sino que se completa al realizar consultas con JOIN a la tabla <code>plataforma</code>.
     * </p>
     */
    private String nombrePlataforma;

    // ──────────────────────────────────────────────────────────────
    // Constructores
    // ──────────────────────────────────────────────────────────────

    /** Constructor vacío (necesario para operaciones genéricas). */
    public JuegoPokemon() {}

    /**
     * Constructor principal usado para crear o editar juegos.
     *
     * @param id              identificador del juego.
     * @param titulo          título del juego.
     * @param generacion      número de generación.
     * @param anioLanzamiento año de lanzamiento.
     * @param plataformaId    identificador de la plataforma.
     */
    public JuegoPokemon(int id, String titulo, int generacion, int anioLanzamiento, int plataformaId) {
        this.id = id;
        this.titulo = titulo;
        this.generacion = generacion;
        this.anioLanzamiento = anioLanzamiento;
        this.plataformaId = plataformaId;
    }

    /**
     * Constructor simplificado (sin ID) para inserciones.
     *
     * @param titulo          título del juego.
     * @param generacion      número de generación.
     * @param anioLanzamiento año de lanzamiento.
     * @param plataformaId    identificador de la plataforma.
     */
    public JuegoPokemon(String titulo, int generacion, int anioLanzamiento, int plataformaId) {
        this.titulo = titulo;
        this.generacion = generacion;
        this.anioLanzamiento = anioLanzamiento;
        this.plataformaId = plataformaId;
    }

    // ──────────────────────────────────────────────────────────────
    // Getters y Setters
    // ──────────────────────────────────────────────────────────────

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public int getPlataformaId() {
        return plataformaId;
    }

    public void setPlataformaId(int plataformaId) {
        this.plataformaId = plataformaId;
    }

    public String getNombrePlataforma() {
        return nombrePlataforma;
    }

    public void setNombrePlataforma(String nombrePlataforma) {
        this.nombrePlataforma = nombrePlataforma;
    }

    // ──────────────────────────────────────────────────────────────
    // Métodos auxiliares
    // ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "JuegoPokemon{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", generacion=" + generacion +
                ", anioLanzamiento=" + anioLanzamiento +
                ", plataformaId=" + plataformaId +
                (nombrePlataforma != null ? ", nombrePlataforma='" + nombrePlataforma + '\'' : "") +
                '}';
    }
}
