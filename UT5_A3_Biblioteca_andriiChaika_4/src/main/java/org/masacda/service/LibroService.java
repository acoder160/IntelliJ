package org.masacda.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.masacda.config.FirebaseService;
import org.masacda.dto.LibroDto;
import org.masacda.dto.LibroResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class LibroService {

    private final CollectionReference coleccionLibros;

    // Inyectamos nuestro FirebaseService
    public LibroService(FirebaseService firebaseService) {
        this.coleccionLibros = firebaseService.db().collection("libros");
    }

    // --- CRUD BÁSICO ---

    // 1. Crear
    public String crearLibro(LibroDto libro) throws ExecutionException, InterruptedException {
        ApiFuture<DocumentReference> future = coleccionLibros.add(libro);
        DocumentReference docRef = future.get(); // Esperamos a que se guarde
        return docRef.getId();
    }

    // 2. Leer uno por ID
    public LibroResponse obtenerLibro(String id) throws ExecutionException, InterruptedException {
        DocumentSnapshot doc = coleccionLibros.document(id).get().get();
        if (doc.exists()) {
            // Convertimos el documento a objeto Java automáticamente
            LibroDto libroDto = doc.toObject(LibroDto.class);
            return new LibroResponse(doc.getId(), libroDto);
        }
        return null; // O lanzar excepción personalizada
    }

    // 3. Actualizar
    public boolean actualizarLibro(String id, LibroDto libroDto) throws ExecutionException, InterruptedException {
        // .set() sobrescribe el documento. Si quisieras actualizar solo campos sueltos usarías .update()
        // Usamos set para garantizar que el documento cumple con el DTO completo validado
        WriteResult result = coleccionLibros.document(id).set(libroDto).get();
        return result.getUpdateTime() != null;
    }

    // 4. Borrar
    public boolean borrarLibro(String id) throws ExecutionException, InterruptedException {
        WriteResult result = coleccionLibros.document(id).delete().get();
        return result.getUpdateTime() != null;
    }

    // --- CONSULTAS AVANZADAS ---

    /**
     * Filtra por género y/o disponibilidad, ordena y limita resultados.
     */
    public List<LibroResponse> buscarLibros(String genero, Boolean disponible, String ordenarPor, int limite) throws ExecutionException, InterruptedException {

        // Empezamos con la colección base
        Query query = coleccionLibros;

        // Filtro 1: Género (Array Contains)
        if (genero != null && !genero.isBlank()) {
            query = query.whereArrayContains("generos", genero);
        }

        // Filtro 2: Disponibilidad (Igualdad)
        if (disponible != null) {
            query = query.whereEqualTo("disponible", disponible);
        }

        // Ordenación (si el usuario no envía nada, ordenamos por título)
        if (ordenarPor != null && !ordenarPor.isBlank()) {
            query = query.orderBy(ordenarPor, Query.Direction.ASCENDING);
        } else {
            query = query.orderBy("titulo");
        }

        // Límite
        query = query.limit(limite > 0 ? limite : 10);

        // Ejecutar consulta
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        // Convertir a DTOs de respuesta
        List<LibroResponse> respuesta = new ArrayList<>();
        for (QueryDocumentSnapshot doc : documents) {
            LibroDto dto = doc.toObject(LibroDto.class);
            respuesta.add(new LibroResponse(doc.getId(), dto));
        }

        return respuesta;
    }
}