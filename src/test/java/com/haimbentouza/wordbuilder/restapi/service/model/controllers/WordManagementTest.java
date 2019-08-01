package com.haimbentouza.wordbuilder.restapi.service.model.controllers;

import com.haimbentouza.wordbuilder.restapi.application.model.IWordManagement;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WordManagementTest {

    private final IWordManagement wordManagement;

    @Autowired
    public WordManagementTest(IWordManagement wordManagement) {
        this.wordManagement = wordManagement;
    }

    @Test
    public void add() {

        wordManagement.add("Maison", 0);
        var result = wordManagement.print();
        Assert.assertEquals(result,"Maison");
    }

    @Test
    public void remove() {
    }

    @Test
    public void bold() {
    }

    @Test
    public void italic() {
    }

    @Test
    public void uderline() {
    }

    @Test
    public void undo() {
    }

    @Test
    public void redo() {
    }

    @Test
    public void print() {
    }
}