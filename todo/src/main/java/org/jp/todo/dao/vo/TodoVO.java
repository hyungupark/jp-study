package org.jp.todo.dao.vo;

import lombok.Getter;
import lombok.Setter;
import org.jp.todo.dao.TodoDao;
import org.jp.todo.dto.TodoDTO;

import java.sql.Timestamp;

@Getter
@Setter
public class TodoVO {

    private Integer id;
    private String title;
    private String content;
    private Boolean completed;
    private Timestamp createdAt;
    private Integer categoryId;
    private String Name;

    public TodoDTO toDto() {
        TodoDTO dto = new TodoDTO();
        dto.setId(this.id);
        dto.setTitle(this.title);
        dto.setContent(this.content);
        dto.setCompleted(this.completed);
        dto.setCreatedAt(this.createdAt);
        dto.setCategoryId(this.categoryId);
        dto.setName(this.Name);

        return dto;
    }

}
