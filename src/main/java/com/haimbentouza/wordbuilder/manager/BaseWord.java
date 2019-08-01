package com.haimbentouza.wordbuilder.manager;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.LinkedList;


@Component
public abstract class BaseWord implements IWordManager {
    LinkedList<String> list = new LinkedList<>();
    LinkedList<String> undolist = new LinkedList<>();

    void initIndexView() {
        undolist.clear();
    }
}
