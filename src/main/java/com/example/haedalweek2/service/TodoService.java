package com.example.haedalweek2.service;

import com.example.haedalweek2.domain.Todo;
import com.example.haedalweek2.dto.TodoDto;
import com.example.haedalweek2.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoDto create(String task){
        TodoDto todoDto = new TodoDto();

        if (todoRepository.create(task)){
            todoDto.setResult("할일을 저장했습니다.");
            todoDto.setSuccess(true);
        }
        else{
            todoDto.setResult("할일을 저장하지 못했습니다.");
            todoDto.setSuccess(false);
        }
        return todoDto;
    }

    public List<Todo> read(){
        List<Todo> todoList = todoRepository.findTodo();


        return todoList;
    }
}
