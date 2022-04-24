package mk.ukim.finki.emt.homework2.service;

import mk.ukim.finki.emt.homework2.model.Book;
import mk.ukim.finki.emt.homework2.model.dto.BookDto;
import mk.ukim.finki.emt.homework2.model.enumerations.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Page<Book> findAllPaginated(Pageable pageable);
    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> update(Long id, BookDto bookDto);
    void deleteById(Long id);
    Optional<Book> markAsTaken(Long id);
}
