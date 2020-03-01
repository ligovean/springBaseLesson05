package Lesson05.repositories;

import Lesson05.entities.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends PagingAndSortingRepository<Book, Long>{
}

