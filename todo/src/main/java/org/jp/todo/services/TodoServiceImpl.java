package org.jp.todo.services;

import lombok.RequiredArgsConstructor;
import org.jp.todo.dao.TodoDao;
import org.jp.todo.dao.vo.TodoVO;
import org.jp.todo.dto.TodoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoDao todoDao;

    @Override
    public List<TodoDTO> getAllData() {
        return todoDao.selectTodoList().stream().map(TodoVO::toDto).toList();
    }

    @Override
    public TodoDTO getIdData(Integer id) {
        return todoDao.selectTodoById(id).toDto();
    }

    @Override
    public String deleteTodoById(Integer id) {
        int effectedRow = todoDao.deleteTodoById(id);
        if (effectedRow > 0) {
            return "Data has been deleted " + id;
        }
        return "No data has been deleted";
    }

    @Override
    public String updateTodoById(Integer id, Integer no, Integer catnum) {

        if (no == 1) {
            int effectedRow = todoDao.updateTodoByIdCAT(id, no, catnum);
            if (effectedRow > 0) {
                return "Data has been updated " + id;
            }
        }else if (no == 2) {
            int effectedRow = todoDao.updateTodoById(id);
            if (effectedRow > 0) {
                return "Data has been updated " + id;
            }
        }

        return "No data has been updated";
    }

    @Override
    public String inserteTodoById(TodoDTO tododto) {

        int effectRow = todoDao.inserteTodoById(tododto);
        if (effectRow > 0) {
            return "Data has been created";
        }
        return "Data has been not created";
    }


}
