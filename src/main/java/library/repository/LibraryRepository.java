package library.repository;

import library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<BookEntity, Integer> {
}
