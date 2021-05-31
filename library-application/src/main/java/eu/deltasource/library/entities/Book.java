package eu.deltasource.library.entities;

import eu.deltasource.library.entities.enums.Genre;
import eu.deltasource.library.entities.enums.Tag;
import lombok.*;

import java.util.Objects;
import java.util.Set;

/**
 * Contains information about a book that will be represented as {@link EBookInfo} or {@link PaperBookInfo}.
 */
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class Book {

    private String title;
    private Set<Author> authors;
    private Genre genre;
    private String shortSummary;
    private String isbn;
    private Set<Tag> tags;
    private String imgUrl = "https://images-na.ssl-images-amazon.com/images/I/41+2DiWeWAS._SX345_BO1,204,203,200_.jpg";

    @Builder
    public Book(String title, Set<Author> authors, Genre genre, String shortSummary, String isbn, Set<Tag> tags) {
        setTitle(title);
        setAuthors(authors);
        setGenre(genre);
        setShortSummary(shortSummary);
        setIsbn(isbn);
        setTags(tags);
    }

    public Book(String title, Set<Author> authors, Genre genre, String shortSummary, String imgUrl, String isbn, Set<Tag> tags) {
        setTitle(title);
        setAuthors(authors);
        setGenre(genre);
        setShortSummary(shortSummary);
        this.imgUrl = imgUrl;
        setIsbn(isbn);
        setTags(tags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Book) {
            Book book = (Book) o;
            return isbn.equals(book.isbn);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
