package com.torryharris.bookapp.Repository;

import com.torryharris.bookapp.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
    public List<Books> findAllByAuthorIsStartingWith(String author);
    public List<Books> findAllByBookNameIsStartingWith(String bookName);
    public List<Books> findAllBySectionIsStartingWith(String section);


}
