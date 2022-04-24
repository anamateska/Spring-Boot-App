package mk.ukim.finki.emt.homework2.service.impl;

import mk.ukim.finki.emt.homework2.model.Author;
import mk.ukim.finki.emt.homework2.model.Book;
import mk.ukim.finki.emt.homework2.model.dto.BookDto;
import mk.ukim.finki.emt.homework2.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.homework2.model.exceptions.BookNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import mk.ukim.finki.emt.homework2.repository.BookRepository;
import mk.ukim.finki.emt.homework2.service.AuthorService;
import mk.ukim.finki.emt.homework2.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllPaginated(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author=this.authorService.findById(bookDto.getAuthorId()).
                orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book=new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book=this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author=this.authorService.findById(bookDto.getAuthorId()).
                orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book=this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Integer availableCopies=book.getAvailableCopies();
        if(availableCopies > 0){
            book.setAvailableCopies(availableCopies-1);
        }
        else{
            book.setAvailableCopies(availableCopies);
        }
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
