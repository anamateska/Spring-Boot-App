package mk.ukim.finki.emt.homework2.service;

import mk.ukim.finki.emt.homework2.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
}
