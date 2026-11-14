package org.jp.todo.dto;

import lombok.Getter;
import lombok.Setter;
import org.jp.todo.dao.vo.TodoVO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TodoDTO {

    private Integer id;
    private String title;
    private String content;
    private Boolean completed;
    private Timestamp createdAt;
    private Integer categoryId;
    private String name;

}
