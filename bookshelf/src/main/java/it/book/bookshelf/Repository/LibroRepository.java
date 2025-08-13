package it.book.bookshelf.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.book.bookshelf.f.Model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findByAutore(String autore);
}
