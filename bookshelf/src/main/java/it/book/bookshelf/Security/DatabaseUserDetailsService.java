package it.book.bookshelf.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.book.bookshelf.Repository.Userrepository;
import it.book.bookshelf.f.Model.User;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private Userrepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <User> user = userRepo.findByUsername(username);

        if(user.isPresent()){
            return new DatabaseUserDetails(user.get());
        }else throw new UsernameNotFoundException("User not found");
    }
}
