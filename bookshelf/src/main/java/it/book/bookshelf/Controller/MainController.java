package it.book.bookshelf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.book.bookshelf.Repository.LibroRepository;
import it.book.bookshelf.f.Model.Libro;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/bookshelf") // Base URL for the controller
public class MainController {
    @Autowired
    private LibroRepository libroRepo; // Assuming you have a repository for the Libro entity

    @GetMapping
    public String index(Model model) {
        List<Libro> libri = libroRepo.findAll(); // Fetch all books from the repository
        model.addAttribute("libro", libri); // Add the list of books to the model
        return "index"; // Return the view name (Thymeleaf template)
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("libri", new Libro()); // Add a new Libro object to the model for the form

        return "create"; // Return the view name for creating a new book
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("libro") Libro libroform, BindingResult bindingresult, Model model) {

        if (bindingresult.hasErrors()) {
            return "create"; // If there are validation errors, return to the create form
        }
        libroRepo.save(libroform); // Save the new book to the repository

        return "redirect:/bookshelf"; // Redirect to the index page after successful creation
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("libro", libroRepo.findById(id).get()); // Fetch the book by ID and add it to the model
        return "show"; // Return the view name for showing the book details
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        libroRepo.deleteById(id); // Delete the book by ID from the repository
        return "redirect:/bookshelf"; // Redirect to the index page after deletion
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Libro libro = libroRepo.findById(id).get(); // Fetch the book by ID
        model.addAttribute("libri", libro); // Add the book to the model for editing
        return "edit"; // Return the view name for editing the book
    }

    @PostMapping("/edit/{id}")
        public String update (@Valid @ModelAttribute("libri") Libro libroform, BindingResult bindingresult, Model model){

            if (bindingresult.hasErrors()) {
                return "edit"; // If there are validation errors, return to the edit form
            }
            libroRepo.save(libroform); // Save the updated book to the repository
            
            return "redirect:/bookshelf"; // Redirect to the index page after successful update
        }
}