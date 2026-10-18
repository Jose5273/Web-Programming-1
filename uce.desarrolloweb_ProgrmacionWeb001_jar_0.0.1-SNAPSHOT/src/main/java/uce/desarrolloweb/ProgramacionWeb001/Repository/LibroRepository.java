package uce.desarrolloweb.ProgramacionWeb001.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uce.desarrolloweb.ProgramacionWeb001.Model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Search by title
    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    // Find by category
    List<Libro> findByCategoriaIgnoreCase(String categoria);

    // 6 random books (PostgreSQL)
    @Query(value = "SELECT * FROM libro ORDER BY RANDOM() LIMIT :n", nativeQuery = true)
    List<Libro> findRandomLibros(@Param("n") int n);
}