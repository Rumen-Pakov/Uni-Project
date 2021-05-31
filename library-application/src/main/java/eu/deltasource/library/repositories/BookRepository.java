package eu.deltasource.library.repositories;

import eu.deltasource.library.entities.EBookInfo;
import eu.deltasource.library.entities.PaperBookInfo;
import eu.deltasource.library.exceptions.NewBookToAddAlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Contains all paper books and e-books, and the methods necessary to add remove and find, based on isbn.
 */
@Repository
public class BookRepository {

    private final Set<PaperBookInfo> paperBooks = new HashSet<>();
    private final Set<EBookInfo> eBooks = new HashSet<>();

    public int getPaperBooksCount() {
        return paperBooks.size();
    }

    public int getEBooksCount() {
        return eBooks.size();
    }

    /**
     * Searches for paper book by given isbn.
     *
     * @param isbn Isbn to search by.
     * @return Paper book found
     */
    public Optional<PaperBookInfo> findPaperBookByIsbn(String isbn) {
        return paperBooks.stream()
                .filter(paperBookInfo -> paperBookInfo.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    /**
     * Searches for E-book by given isbn.
     *
     * @param isbn Isbn to search by
     * @return E-book found
     */
    public Optional<EBookInfo> findEBookByIsbn(String isbn) {
        return eBooks.stream()
                .filter(eBookInfo -> eBookInfo.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    public Set<PaperBookInfo> findAllPaperBooks() {
        return Collections.unmodifiableSet(paperBooks);
    }

    public Set<EBookInfo> findAllEBooks() {
        return Collections.unmodifiableSet(eBooks);
    }

    /**
     * Adds new paper book to repository.
     *
     * @param paperBookInfo Paper book to add
     */
    public void addNewPaperBook(PaperBookInfo paperBookInfo) {
        if (isPaperBookPresentInRepository(paperBookInfo.getIsbn())) {
            throw new NewBookToAddAlreadyExistsException("Book with same isbn already exists in repository." +
                    " Value passed: " + paperBookInfo);
        }
        paperBooks.add(paperBookInfo);
    }

    /**
     * Checks if paper book exists in repository by given isbn.
     *
     * @param isbn Isbn to search by
     * @return True if present
     */
    private boolean isPaperBookPresentInRepository(String isbn) {
        return findPaperBookByIsbn(isbn).isPresent();
    }

    /**
     * Adds new e-book to repository.
     *
     * @param eBookInfo E-book to add
     */
    public void addNewEBook(EBookInfo eBookInfo) {
        if (isEbookPresentInRepository(eBookInfo.getIsbn())) {
            throw new NewBookToAddAlreadyExistsException("Book with same isbn already exists in repository." +
                    " Value passed: " + eBookInfo);
        }
        eBooks.add(eBookInfo);
    }

    /**
     * Checks if E-book exists in repository by given isbn.
     *
     * @param isbn Isbn to search by.
     * @return True if present
     */
    private boolean isEbookPresentInRepository(String isbn) {
        return findEBookByIsbn(isbn).isPresent();
    }

    /**
     * Removes all existing books.
     */
    public void clear() {
        paperBooks.clear();
        eBooks.clear();
    }
}
