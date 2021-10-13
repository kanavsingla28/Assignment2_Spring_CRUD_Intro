package com.crud.Spring_CRUD_Intro.repository;

import com.crud.Spring_CRUD_Intro.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
