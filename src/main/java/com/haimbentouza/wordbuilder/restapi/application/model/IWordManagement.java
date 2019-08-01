package com.haimbentouza.wordbuilder.restapi.application.model;

import org.springframework.stereotype.Component;

@Component
public interface IWordManagement {
    void add(String stringToAdd, int position);

    void remove(int fromPos, int toPos);

    void bold(int fromPos, int toPos);

    void italic(int fromPos, int toPos);

    void undo();

    String print();

    void redo();

    void uderline(int fromPos, int toPos);
}
