package it.book.bookshelf.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.book.bookshelf.Repository.LibroRepository;
import it.book.bookshelf.Repository.Userrepository;
import it.book.bookshelf.Repository.user_bookRepository;
import it.book.bookshelf.f.Model.Libro;
import it.book.bookshelf.f.Model.User;
import it.book.bookshelf.f.Model.user_book;

@Service
public class Logic_Service {

    @Service
public class UserBookService {

    @Autowired
    private Userrepository userRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private user_bookRepository userBookRepository;

    public user_book registraLettura(Integer userId, Integer libroId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        Libro libro = libroRepository.findById(libroId)
            .orElseThrow(() -> new RuntimeException("Libro non trovato"));

        user_book userBook = new user_book();
        userBook.setUser(user);
        userBook.setLibro(libro);

        // Se hai altri campi, tipo data di lettura, puoi aggiungerli qui
       // userBook.setDataLettura(LocalDate.now());

        return userBookRepository.save(userBook);
    }
}

}
