package com.example.haedalweek2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private Long id;
    private String task;
    private boolean done;

    public Todo(String task, boolean done) {
        this.task = task;
        this.done = done;
    }

}
