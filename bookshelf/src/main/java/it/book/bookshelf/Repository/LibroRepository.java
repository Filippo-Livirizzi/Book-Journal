package it.book.bookshelf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.book.bookshelf.f.Model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {


}
