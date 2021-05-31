package eu.deltasource.library.controllers;

import eu.deltasource.library.entities.EBookInfo;
import eu.deltasource.library.entities.PaperBookInfo;
import eu.deltasource.library.exceptions.IllegalInputException;
import eu.deltasource.library.repositories.BookRepository;
import eu.deltasource.library.util.Paths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

/**
 * This class is used for searching, adding and removing books from the repository.
 * Optional values are returned from find methods. Searches are based on isbn.
 */
@CrossOrigin
@RestController
@RequestMapping(path="/books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        setBookRepository(bookRepository);
    }

    private void setBookRepository(BookRepository bookRepository) {
        if (bookRepository == null) {
            throw new IllegalInputException("Book repository can not be null");
        }
        this.bookRepository = bookRepository;
    }

    /**
     * Calls {@link BookRepository} method for searching paper book by isbn.
     *
     * @param isbn Isbn to search by
     * @return Paper book found
     */
    public Optional<PaperBookInfo> findPaperBookByIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalInputException("Isbn to search paper book by can not be null or empty");
        }
        return bookRepository.findPaperBookByIsbn(isbn);
    }

    /**
     * Calls {@link BookRepository} method for searching E-book by isbn
     *
     * @param isbn Isbn to search by
     * @return E-book found
     */
    public Optional<EBookInfo> findEBookByIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalInputException("Isbn to search e-book by can not be null or empty");
        }
        return bookRepository.findEBookByIsbn(isbn);
    }

    /**
     * Calls {@link BookRepository} method for adding new paper book to repository
     *
     * @param paperBookInfo Paper book to add to repository
     */
    public void addNewPaperBook(PaperBookInfo paperBookInfo) {
        if (paperBookInfo == null) {
            throw new IllegalInputException("Paper book to add can not be null");
        }
        bookRepository.addNewPaperBook(paperBookInfo);
    }

    /**
     * Calls {@link BookRepository} method for adding new E-book book to repository
     *
     * @param eBookInfo E-book to add to repository
     */
    public void addNewEBook(EBookInfo eBookInfo) {
        if (eBookInfo == null) {
            throw new IllegalInputException("E-book to add can not be null");
        }
        bookRepository.addNewEBook(eBookInfo);
    }

    /**
     * Calls {@link BookRepository} method for getting count of E-books
     *
     * @return E-books count in repository
     */
    public int getEBooksCount() {
        return bookRepository.getEBooksCount();
    }

    /**
     * Calls {@link BookRepository} method for getting count of Paper books
     *
     * @return Paper books count in repository
     */
    public int getPaperBooksCount() {
        return bookRepository.getPaperBooksCount();
    }

    @GetMapping(path="/paper-book/all")
    @Operation(summary = "Get all paper books", description = "Fetches all present paper books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<Iterable<PaperBookInfo>> getAllPaperBooks() {
        return new ResponseEntity<>(bookRepository.findAllPaperBooks(), HttpStatus.OK);
    }

    @GetMapping(path="/paper-book/{isbn}")
    @Operation(summary = "Get paper book", description = "Fetch paper book by given isbn")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content())
    })
    public ResponseEntity<PaperBookInfo> getPaperBookInfoByIsbn(@PathVariable String isbn) {
        Optional<PaperBookInfo> foundPaperBookInfo = bookRepository.findPaperBookByIsbn(isbn);
        return foundPaperBookInfo.map(paperBookInfo -> new ResponseEntity<>(paperBookInfo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(path = "/paper-book/add")
    @Operation(summary = "Add paper book", description = "Adds paper book if such is not present already with same isbn")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content())
    })
    public ResponseEntity<PaperBookInfo> postPaperBookInfo(@RequestBody PaperBookInfo paperBookInfo) {
        bookRepository.addNewPaperBook(paperBookInfo);
        URI location = Paths.LocationBuilder(Paths.BOOKS, paperBookInfo.getIsbn());
        return ResponseEntity.created(location).body(paperBookInfo);
    }

    @GetMapping(path="/e-book/all")
    @Operation(summary = "Get all e-books", description = "Fetches all present e-books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<Iterable<EBookInfo>> getAllEBooks() {
        return new ResponseEntity<>(bookRepository.findAllEBooks(), HttpStatus.OK);
    }

    @GetMapping(path="/e-book/{isbn}")
    @Operation(summary = "Get e-book", description = "Fetch e-book by given isbn")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content())
    })
    public ResponseEntity<EBookInfo> getEBookInfoByIsbn(@PathVariable String isbn) {
        Optional<EBookInfo> foundEBookInfo = bookRepository.findEBookByIsbn(isbn);
        return foundEBookInfo.map(eBookInfo -> new ResponseEntity<>(eBookInfo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(path = "/e-book/add")
    @Operation(summary = "Add e-book", description = "Adds e-book if such is not present already with same isbn")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content())
    })
    public ResponseEntity<EBookInfo> postEBookInfo(@RequestBody EBookInfo eBookInfo) {
        bookRepository.addNewEBook(eBookInfo);
        URI location = Paths.LocationBuilder(Paths.BOOKS, eBookInfo.getIsbn());
        return ResponseEntity.created(location).body(eBookInfo);
    }
}
