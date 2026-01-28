package org.masacda.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.masacda.config.FirebaseService;
import org.masacda.dto.LibroDto;
import org.masacda.dto.LibroResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class LibroService {

    private final CollectionReference coleccion;

    // Inyectamos nuestro FirebaseService
    public LibroService(FirebaseService firebaseService) {
        this.coleccion = firebaseService.db().collection("libros");
    }

    // 1. CREATE (ID automático)
    public String crearLibro(LibroDto libro) throws ExecutionException, InterruptedException {
        // .add() genera un ID automático
        ApiFuture<DocumentReference> future = coleccion.add(libro);
        DocumentReference docRef = future.get(); // Esperamos respuesta
        return docRef.getId();
    }

    // 2. READ ALL
    public List<LibroResponse> listarTodos() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = coleccion.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<LibroResponse> lista = new ArrayList<>();
        for (QueryDocumentSnapshot doc : documents) {
            LibroResponse response = doc.toObject(LibroResponse.class); // Magia de Jackson
            response.setId(doc.getId());
            lista.add(response);
        }
        return lista;
    }

    // 3. READ ONE
    public LibroResponse obtenerPorId(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = coleccion.document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {
            LibroResponse response = document.toObject(LibroResponse.class);
            response.setId(document.getId());
            return response;
        }
        return null; // O lanzar excepción personalizada
    }

    // 4. UPDATE TOTAL (PUT)
    public void actualizarCompleto(String id, LibroDto libro) throws ExecutionException, InterruptedException {
        // .set() sobrescribe todo el documento
        ApiFuture<WriteResult> future = coleccion.document(id).set(libro);
        future.get(); // Esperar confirmación
    }

    // 5. UPDATE PARCIAL (PATCH)
    public void actualizarParcial(String id, Map<String, Object> campos) throws ExecutionException, InterruptedException {
        // .update() solo cambia los campos que le pases
        ApiFuture<WriteResult> future = coleccion.document(id).update(campos);
        future.get();
    }

    // 6. DELETE
    public void borrar(String id) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = coleccion.document(id).delete();
        future.get();
    }

    // 7. BUSQUEDA AVANZADA (Punto 11)
    public List<LibroResponse> buscar(String genero, Boolean disponible, Double minValoracion, Integer limit)
            throws ExecutionException, InterruptedException {

        Query query = coleccion;

        // voy encadenando filtros si no son null
        if (genero != null) {
            // array-contains es especial para arrays en Firestore
            query = query.whereArrayContains("generos", genero);
        }
        if (disponible != null) {
            query = query.whereEqualTo("disponible", disponible);
        }
        if (minValoracion != null) {
            query = query.whereGreaterThanOrEqualTo("valoracionMedia", minValoracion);
        }
        if (limit != null) {
            query = query.limit(limit);
        }

        // Ejecutamos la query construida
        ApiFuture<QuerySnapshot> future = query.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<LibroResponse> lista = new ArrayList<>();
        for (QueryDocumentSnapshot doc : documents) {
            LibroResponse response = doc.toObject(LibroResponse.class);
            response.setId(doc.getId());
            lista.add(response);
        }
        return lista;
    }
}