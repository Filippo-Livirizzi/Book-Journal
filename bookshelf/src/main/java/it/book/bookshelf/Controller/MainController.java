package it.book.bookshelf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.book.bookshelf.Repository.LibroRepository;
import it.book.bookshelf.f.Model.Libro;

@Controller
@RequestMapping("/bookshelf") // Base URL for the controller
public class MainController {
    @Autowired
    private LibroRepository libroRepo; // Assuming you have a repository for the Libro entity

    public String index(Model model) {
        List<Libro> libri = libroRepo.findAll(); // Fetch all books from the repository
        model.addAttribute("libro", libri); // Add the list of books to the model
        return "/index";
    }

}
