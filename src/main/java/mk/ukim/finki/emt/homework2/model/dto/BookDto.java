package mk.ukim.finki.emt.homework2.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.homework2.model.enumerations.BookCategory;

@Data
@NoArgsConstructor
public class BookDto {
    private String name;

    private BookCategory category;

    private Long authorId;

    private Integer availableCopies;

    public BookDto(String name, BookCategory category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
