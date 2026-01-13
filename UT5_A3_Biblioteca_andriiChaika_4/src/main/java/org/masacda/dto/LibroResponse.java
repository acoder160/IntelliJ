package org.masacda.dto;


// Esta clase extiende el LibroDto y añade el id. Para que el json devuelva id de firebase
public class LibroResponse extends LibroDto {
    private String id; //id in firebase es un String

    public LibroResponse(String id, LibroDto dto) {
        this.id = id;
        this.setTitulo(dto.getTitulo());
        this.setAutor(dto.getAutor());
        this.setGeneros(dto.getGeneros());
        this.setAnyoPublicacion(dto.getAnyoPublicacion());
        this.setDisponible(dto.getDisponible());
        this.setNumPaginas(dto.getNumPaginas());
        this.setValoracionMedia(dto.getValoracionMedia());
        this.setEtiquetas(dto.getEtiquetas());
    }

    // Constructor vacío necesario para mapeos automáticos si los hubiera
    public LibroResponse() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /* KEY FIREBASE

   FileInputStream serviceAccount =
new FileInputStream("path/to/serviceAccountKey.json");

FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .build();

FirebaseApp.initializeApp(options);
     */
}
