package com.luffy.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luffy.todo.model.Todo;
@Repository
public interface Itodorepo extends JpaRepository<Todo, Long>{

}
