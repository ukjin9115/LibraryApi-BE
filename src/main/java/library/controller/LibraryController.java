package library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.entity.BookEntity;
import library.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable("bookId") int bookId) {
        Optional<BookEntity> book = libraryService.getBookById(bookId);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/regist")
    public BookEntity createBook(@RequestBody BookEntity book) {
        return libraryService.saveBook(book);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable("bookId") int bookId, @RequestBody BookEntity bookDetails) {
        Optional<BookEntity> optionalBook = libraryService.getBookById(bookId);
        if (optionalBook.isPresent()) {
            BookEntity book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublisher(bookDetails.getPublisher());
            book.setPublishDate(bookDetails.getPublishDate());
            book.setDescription(bookDetails.getDescription());
            final BookEntity updatedBook = libraryService.saveBook(book);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
        if (libraryService.getBookById(bookId).isPresent()) {
            libraryService.deleteBook(bookId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
