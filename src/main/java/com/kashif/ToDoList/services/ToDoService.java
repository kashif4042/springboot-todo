package com.kashif.ToDoList.services;

import com.kashif.ToDoList.Exception.ResourceNotFoundException;
import com.kashif.ToDoList.model.Todo;
import com.kashif.ToDoList.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ToDoService {

    private final TodoRepository todoRepository;

    public ToDoService(TodoRepository todoRepository){
        this.todoRepository= todoRepository;
    }

    // 1. getAllTodos
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 2. getTodoById
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo with ID"+ id + "not found"));
    }

    // 3. createTodo
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // 4.updateTodo
    public Todo updateTodo(Long id,Todo updatedTodo){
       Todo todo=  todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo with ID" + id +"Not found"));
       todo.setTitle(updatedTodo.getTitle());
       todo.setCompleted(updatedTodo.isCompleted());
       todoRepository.save(todo);
       return todo;
    }

    public void deleteTodo(Long id){

        if(!todoRepository.existsById(id)){
            throw new ResourceNotFoundException("Todo with ID" + id + "Not Found");
        }
         todoRepository.deleteById(id);
    }
}