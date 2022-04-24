package mk.ukim.finki.emt.homework2.service.impl;

import mk.ukim.finki.emt.homework2.model.Author;
import org.springframework.stereotype.Service;
import mk.ukim.finki.emt.homework2.repository.AuthorRepository;
import mk.ukim.finki.emt.homework2.service.AuthorService;


import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

}
