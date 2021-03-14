package com.practice.sample.controller;

import com.practice.sample.model.Address;
import com.practice.sample.model.Author;
import com.practice.sample.model.Book;
import com.practice.sample.model.Publication;
import com.practice.sample.repository.AddressRepository;
import com.practice.sample.repository.AuthorRepository;
import com.practice.sample.repository.BookRepository;
import com.practice.sample.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    BookRepository bookRepository;

    @Value("${spring.profiles.active}")
    private String activeProfile; //To get the profile that's active.

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    AddressRepository addressRepository;

    @GetMapping(path = "/greetings", produces = "application/json")
    public ResponseEntity<Object> greetings(){
        return ResponseEntity.ok().body("HI There!");
    }

    @PostMapping(path = "/greetings/{for}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> greetingsPost(@PathVariable("for") String name){
        return ResponseEntity.ok().body("HI There "+name+"!");
    }

    @PutMapping(path = "/book" , produces = "application/json", consumes = "application/json")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        addressRepository.save(book.getAuthor().getAddress());
        addressRepository.save(book.getPublication().getAddress());
        authorRepository.save(book.getAuthor());
        publicationRepository.save(book.getPublication());
       Book savedBook = bookRepository.save(book);
       return ResponseEntity.ok().body(savedBook);
    }
    @PutMapping(path = "/author" , produces = "application/json", consumes = "application/json")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        addressRepository.save(author.getAddress());
        Author savedAuthor = authorRepository.save(author);
        return ResponseEntity.ok().body(savedAuthor);
    }

    @PutMapping(path = "/address" , produces = "application/json", consumes = "application/json")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){
        Address savedAddress = addressRepository.save(address);
        return ResponseEntity.ok().body(savedAddress);
    }

    @PutMapping(path = "/publication" , produces = "application/json", consumes = "application/json")
    public ResponseEntity<Publication> savePublication(@RequestBody Publication publication){
        addressRepository.save(publication.getAddress());
        Publication savedPub = publicationRepository.save(publication);
        return ResponseEntity.ok().body(savedPub);
    }

    @PatchMapping(path = "/book/{id}" , produces = "application/json", consumes = "application/json")
    public ResponseEntity<Book> patchBook(@PathVariable Long id, @RequestBody Book book){
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book storedBook = optionalBook.get();
        if(book.getAuthor() != null){
            storedBook.setAuthor(book.getAuthor());
        }
        if(book.getName() != null){
            storedBook.setName(book.getName());
        }
        if(book.getPublication() != null){
            storedBook.setPublication(book.getPublication());
        }
        if(book.getShortDescription() != null){
            storedBook.setShortDescription(book.getShortDescription());
        }
        Book saved = bookRepository.save(storedBook);
        return ResponseEntity.ok().body(saved);
    }

    @PostMapping(path = "/book/{id}" , produces = "application/json", consumes = "application/json")
    public ResponseEntity<Book> postBook(@PathVariable Long id, @RequestBody Book book){
        bookRepository.deleteById(id);
        Book saved = bookRepository.save(book);
        return ResponseEntity.ok().body(saved);
    }


}
