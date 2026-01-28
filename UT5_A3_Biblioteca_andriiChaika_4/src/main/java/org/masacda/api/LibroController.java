package org.masacda.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.masacda.dto.LibroDto;
import org.masacda.dto.LibroResponse;
import org.masacda.service.LibroService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // 1. CREATE
    @PostMapping
    public ResponseEntity<String> crear(@Valid @RequestBody LibroDto libro) {
        try {
            String id = libroService.crearLibro(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body("Libro creado con ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al crear: " + e.getMessage());
        }
    }

    // 2. GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable String id) {
        try {
            LibroResponse libro = libroService.obtenerPorId(id);
            if (libro != null) {
                return ResponseEntity.ok(libro);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // 3. GET ALL
    @GetMapping
    public ResponseEntity<List<LibroResponse>> listar() {
        try {
            return ResponseEntity.ok(libroService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // 4. UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable String id, @Valid @RequestBody LibroDto libro) {
        try {
            libroService.actualizarCompleto(id, libro);
            return ResponseEntity.ok("Libro actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    // 5. UPDATE (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<String> actualizarParcial(@PathVariable String id, @RequestBody Map<String, Object> campos) {
        try {
            libroService.actualizarParcial(id, campos);
            return ResponseEntity.ok("Campos actualizados");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    // 6. DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable String id) {
        try {
            libroService.borrar(id);
            return ResponseEntity.ok("Libro eliminado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    // 7. BÚSQUEDA AVANZADA
    @GetMapping("/buscar")
    public ResponseEntity<List<LibroResponse>> buscar(
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) Boolean disponible,
            @RequestParam(required = false) Double minValoracion,
            @RequestParam(required = false) Integer limit
    ) {
        try {
            List<LibroResponse> resultados = libroService.buscar(genero, disponible, minValoracion, limit);
            return ResponseEntity.ok(resultados);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}