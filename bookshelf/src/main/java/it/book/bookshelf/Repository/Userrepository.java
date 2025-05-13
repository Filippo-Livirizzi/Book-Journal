package it.book.bookshelf.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.book.bookshelf.f.Model.User;

public interface Userrepository extends JpaRepository <User, Integer> {
    Optional <User> findByUsername(String username);


}
