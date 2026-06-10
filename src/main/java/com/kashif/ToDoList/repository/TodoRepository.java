package com.kashif.ToDoList.repository;


import com.kashif.ToDoList.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long>{

}
