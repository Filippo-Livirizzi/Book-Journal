package it.book.bookshelf.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.book.bookshelf.f.Model.User;

@Repository
public interface Userrepository extends JpaRepository <User, Integer> {

    Optional <User> findByUsername(String username);


}
