package it.book.bookshelf.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.book.bookshelf.f.Model.user_book;

public interface user_bookRepository extends JpaRepository <user_book, Integer> {
    
    Optional<user_book> findByUser_IdAndLibro_Id(Integer userId, Integer bookId); // Custom query method to find user_book by libro ID

}
