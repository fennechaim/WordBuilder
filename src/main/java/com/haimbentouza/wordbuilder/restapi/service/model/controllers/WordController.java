package com.haimbentouza.wordbuilder.restapi.service.model.controllers;

import com.haimbentouza.wordbuilder.restapi.application.model.IWordManagement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/word")
public class WordController {

    private final IWordManagement wordManagement;

    public WordController(IWordManagement wordManagement) {
        this.wordManagement = wordManagement;
    }

    @GetMapping(value = "add/stringToAdd/{stringToAdd},position/{position}")
    public ResponseEntity<?> add(@PathVariable("stringToAdd") String stringToAdd, @PathVariable("position") int position) {

        try {
            this.wordManagement.add(stringToAdd, position);

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Input Wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "remove/fromPos/{fromPos},toPos/{toPos}")
    public ResponseEntity<?> remove(@PathVariable("fromPos") int fromPos, @PathVariable("toPos") int toPos) {
        try {
            this.wordManagement.remove(fromPos, toPos);

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Input Wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "bold/fromPos/{fromPos},toPos/{toPos}")
    public ResponseEntity<?> bold(@PathVariable("fromPos") int fromPos, @PathVariable("toPos") int toPos) {
        try {
            this.wordManagement.bold(fromPos, toPos);

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Input Wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "italic/fromPos/{fromPos},toPos/{toPos}")
    public ResponseEntity<?> italic(@PathVariable("fromPos") int fromPos, @PathVariable("toPos") int toPos) {
        try {
            this.wordManagement.italic(fromPos, toPos);

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Input Wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "uderline/fromPos/{fromPos},toPos/{toPos}")
    public ResponseEntity<?> uderline(@PathVariable("fromPos") int fromPos, @PathVariable("toPos") int toPos) {
        try {
            this.wordManagement.uderline(fromPos, toPos);

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Input Wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "undo")
    public ResponseEntity<?> undo() {

        this.wordManagement.undo();

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "redo")
    public ResponseEntity<?> redo() {

        this.wordManagement.redo();

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "print")
    public ResponseEntity<String> print() {

        String response = this.wordManagement.print();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
