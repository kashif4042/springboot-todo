package com.kashif.ToDoList.controllers;

import com.kashif.ToDoList.model.Todo;
import com.kashif.ToDoList.services.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(toDoService.getAllTodos());
    }


    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById (@PathVariable Long id) {
        return ResponseEntity.ok(toDoService.getTodoById(id));
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.createTodo(todo));
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return ResponseEntity.ok(toDoService.updateTodo(id, todo));
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        toDoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

}