package com.practice.sample.controller;

import com.practice.sample.model.Address;
import com.practice.sample.model.Author;
import com.practice.sample.model.Book;
import com.practice.sample.model.Publication;
import com.practice.sample.model.entity.AddressEntity;
import com.practice.sample.model.entity.AuthorEntity;
import com.practice.sample.model.entity.BookEntity;
import com.practice.sample.model.entity.PublicationEntity;
import com.practice.sample.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Value("${spring.profiles.active}")
    private String activeProfile; //To get the profile that's active.

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/greetings", produces = "application/json")
    public ResponseEntity<Object> greetings() {
        return ResponseEntity.ok().body("HI There!");
    }

    @PostMapping(path = "/greetings/{for}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> greetingsPost(@PathVariable("for") String name) {
        return ResponseEntity.ok().body("HI There " + name + "!");
    }

    @PostMapping(path = "/book", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookEntity> saveBook(@RequestBody Book book) {
        BookEntity savedBook = bookService.addBook(book);
        return ResponseEntity.ok().body(savedBook);
    }

    @PostMapping(path = "/author", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AuthorEntity> saveAuthor(@RequestBody Author author) {
        AuthorEntity savedAuthor = bookService.addAuthor(author);
        return ResponseEntity.ok().body(savedAuthor);
    }

    @PostMapping(path = "/address", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AddressEntity> saveAddress(@RequestBody Address address) {
        AddressEntity savedAddress = bookService.addAddress(address);
        return ResponseEntity.ok().body(savedAddress);
    }

    @PostMapping(path = "/publication", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PublicationEntity> savePublication(@RequestBody Publication publication) {
        PublicationEntity savedPub = bookService.addPublication(publication);
        return ResponseEntity.ok().body(savedPub);
    }

    @PatchMapping(path = "/book/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookEntity> patchBook(@PathVariable Long id, @RequestBody Book book) {

        BookEntity saved = bookService.updateBook(book, id);
        return ResponseEntity.ok().body(saved);
    }

    @PutMapping(path = "/book/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookEntity> postBook(@PathVariable Long id, @RequestBody Book book) {
        BookEntity saved = bookService.replaceBook(book, id);
        return ResponseEntity.ok().body(saved);
    }


}
