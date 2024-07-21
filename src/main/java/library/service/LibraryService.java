package library.service;

import library.entity.BookEntity;
import library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<BookEntity> getAllBooks() {
        return libraryRepository.findAll();
    }

    public Optional<BookEntity> getBookById(int id) {
        return libraryRepository.findById(id);
    }

    public BookEntity saveBook(BookEntity book) {
        return libraryRepository.save(book);
    }

    public void deleteBook(int id) {
        libraryRepository.deleteById(id);
    }
}
