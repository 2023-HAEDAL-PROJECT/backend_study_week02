package com.example.haedalweek2.service;


import com.example.haedalweek2.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public void update(Long id){
        todoRepository.update(id);
    }


}
