package org.jp.todo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jp.todo.dao.vo.TodoVO;
import org.jp.todo.dto.TodoDTO;

import java.util.List;

@Mapper
public interface TodoDao {

    List<TodoVO> selectTodoList();
    TodoVO selectTodoById(Integer id);
    int deleteTodoById(Integer id);
    int inserteTodoById(TodoDTO tododto);
    int updateTodoById(Integer id);
    int updateTodoByIdCAT(Integer id,Integer no, Integer catnum);

}
