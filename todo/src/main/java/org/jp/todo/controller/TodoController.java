package org.jp.todo.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.jp.todo.dto.TodoDTO;
import org.jp.todo.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // -> "Json"
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoDTO> getAllData() {
        return this.todoService.getAllData();
    }

    @GetMapping("/{id}")
    public TodoDTO getIdData(@PathVariable("id") Integer id) {

        return this.todoService.getIdData(id);
    }

    @Schema(name = "DELETE TODO")
    @DeleteMapping("/delete/{id}")
    public String deleteIdData(
            @PathVariable("id")
            Integer id
    ) {

        return this.todoService.deleteTodoById(id);
    }

    @Schema(name = "INSERT TODO")
    @PostMapping("/inert")
    public String insertIdData(
            @RequestBody TodoDTO tododto
    ) {

        return this.todoService.inserteTodoById(tododto);
    }

    @Schema(name = "UPDATE TODO")
    @PutMapping("/upsert/{no}/{id}/{catnum}")
    public String updateIdData(
            @PathVariable("id")
            Integer id,
            @PathVariable("no") Integer no,
            @PathVariable("catnum") Integer catnum

    ) {
        return this.todoService.updateTodoById(id,no,catnum);
    }

}
