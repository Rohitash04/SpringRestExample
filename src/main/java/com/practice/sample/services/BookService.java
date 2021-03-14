package com.practice.sample.services;

import com.practice.sample.model.Address;
import com.practice.sample.model.Author;
import com.practice.sample.model.Book;
import com.practice.sample.model.Publication;
import com.practice.sample.model.entity.AddressEntity;
import com.practice.sample.model.entity.AuthorEntity;
import com.practice.sample.model.entity.BookEntity;
import com.practice.sample.model.entity.PublicationEntity;
import com.practice.sample.repository.AddressRepository;
import com.practice.sample.repository.AuthorRepository;
import com.practice.sample.repository.BookRepository;
import com.practice.sample.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublicationRepository publicationRepository;
    private final AddressRepository addressRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublicationRepository publicationRepository, AddressRepository addressRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publicationRepository = publicationRepository;
        this.addressRepository = addressRepository;
    }

    public BookEntity addBook(Book book) {
        BookEntity bookEntity = getBookEntity(book);
        return bookRepository.save(bookEntity);
    }

    private BookEntity getBookEntity(Book book) {
        AuthorEntity authorEntity = null;
        if (book.getAuthor() != null) {
            authorEntity = getAuthorEntity(book.getAuthor());
        }
        PublicationEntity publicationEntity = null;
        if(book.getPublication() != null){
            publicationEntity = getPublicationEntity(book.getPublication());
        }

        BookEntity bookEntity = BookEntity.builder()
                .id(book.getId())
                .name(book.getName())
                .authorEntity(authorEntity)
                .publicationEntity(publicationEntity)
                .shortDescription(book.getShortDescription())
                .build();
        return bookEntity;
    }

    public BookEntity updateBook(Book book, Long id){

        Optional<BookEntity> optionalBook = bookRepository.findById(id);
        BookEntity storedBook = optionalBook.get();
        if(book.getAuthor() != null){
            storedBook.setAuthorEntity(getAuthorEntity(book.getAuthor()));
        }
        if(book.getName() != null){
            storedBook.setName(book.getName());
        }
        if(book.getPublication() != null){
            storedBook.setPublicationEntity(getPublicationEntity(book.getPublication()));
        }
        if(book.getShortDescription() != null){
            storedBook.setShortDescription(book.getShortDescription());
        }
        return bookRepository.save(storedBook);
    }

    public BookEntity replaceBook(Book book, Long id){
        bookRepository.deleteById(id);
        book.setId(id);
        return bookRepository.save(getBookEntity(book));
    }

    public PublicationEntity addPublication(Publication publication){
        PublicationEntity publicationEntity = getPublicationEntity(publication);
        return publicationRepository.save(publicationEntity);
    }

    public AuthorEntity addAuthor(Author author){
        AuthorEntity authorEntity = getAuthorEntity(author);
        return  authorRepository.save(authorEntity);
    }

    public AddressEntity addAddress(Address address){
        AddressEntity addressEntity = getAddressEntity(address);
        return addressRepository.save(addressEntity);
    }

    public BookEntity getBook(Long id){
        return bookRepository.findById(id).get();
    }

    public List<BookEntity> getBook(String name){
        return bookRepository.findByName(name);
    }

    public AuthorEntity getAuthor(Long id){
        return authorRepository.findById(id).get();
    }

    public  List<AuthorEntity> getAuthors(String name){
        return authorRepository.findByName(name);
    }

    public PublicationEntity getPublication(String code){
        return publicationRepository.findByCode(code);
    }

    public List<AddressEntity> getAddresses(String zipCode){
        return addressRepository.findByZipCode(zipCode);
    }



    private PublicationEntity getPublicationEntity(Publication publication) {
        PublicationEntity publicationEntity;
        if(publicationRepository.findByCode(publication.getCode()) == null){
            publicationEntity = PublicationEntity.builder()
                    .code(publication.getCode())
                    .name(publication.getName())
                    .address(getAddressEntity(publication.getAddress()))
                    .build();
        }else{
            publicationEntity = PublicationEntity.builder()
                    .code(publication.getCode())
                    .build();
        }
        return publicationEntity;
    }

    private AuthorEntity getAuthorEntity(Author author) {
        AuthorEntity authorEntity;
        if (authorRepository.findById(author.getId()) == null) {
            AddressEntity addressEntity = null;
            if (author.getAddress() != null) {
                addressEntity = getAddressEntity(author.getAddress());
            }
            authorEntity = AuthorEntity.builder()
                    .id(author.getId())
                    .name(author.getName())
                    .address(addressEntity)
                    .build();
        } else {
            authorEntity = AuthorEntity.builder()
                    .id(author.getId())
                    .build();
        }
        return authorEntity;
    }

    private AddressEntity getAddressEntity(Address address) {
        AddressEntity addressEntity;
        if (addressRepository.findById(address.getId()) == null) {
            addressEntity = AddressEntity.builder()
                    .id(address.getId())
                    .houseNumber(address.getHouseNumber())
                    .street(address.getStreet())
                    .city(address.getCity())
                    .zipCode(address.getZipCode())
                    .build();
        }else{
            addressEntity = AddressEntity.builder()
                    .id(address.getId())
                    .build();
        }
        return addressEntity;
    }
}
