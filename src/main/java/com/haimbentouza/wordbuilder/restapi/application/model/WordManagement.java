package com.haimbentouza.wordbuilder.restapi.application.model;

import com.haimbentouza.wordbuilder.manager.IWordManager;
import org.springframework.stereotype.Component;

@Component
public class WordManagement implements IWordManagement {

    private final IWordManager wordManager;

    public WordManagement(IWordManager wordManager) {
        this.wordManager = wordManager;
    }

    @Override
    public void add(String stringToAdd, int position) {
        this.wordManager.add(stringToAdd,position);
    }

    @Override
    public void remove(int fromPos, int toPos) {
        this.wordManager.remove(fromPos, toPos);
    }

    @Override
    public void bold(int fromPos, int toPos) {
        this.wordManager.bold(fromPos,toPos);
    }

    @Override
    public void italic(int fromPos, int toPos) {
        this.wordManager.italic(fromPos,toPos);
    }

    @Override
    public void undo() {
        this.wordManager.undo();
    }

    @Override
    public String print() {
        return  this.wordManager.print();
    }

    @Override
    public void redo() {
        this.wordManager.redo();
    }

    @Override
    public void uderline(int fromPos, int toPos) {
        this.wordManager.uderline(fromPos,toPos);
    }
}
