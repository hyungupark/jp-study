package org.jp.todo.services;

import org.jp.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    List<TodoDTO> getAllData();
    TodoDTO getIdData(Integer id);
    String deleteTodoById(Integer id);
    String inserteTodoById(TodoDTO todoDTO);
    String updateTodoById(Integer id,Integer no, Integer catnum);
}
