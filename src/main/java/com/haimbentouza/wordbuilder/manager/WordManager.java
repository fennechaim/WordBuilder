package com.haimbentouza.wordbuilder.manager;

import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class WordManager implements IWordManager {
    private final String STARTBOLD = "<b>";
    private final String ENDBOLD = "</b>";

    private final String STARTITALIC = "<i>";
    private final String ENDITALIC = "</i>";

    private final String STARTUNDERLINE = "<u>";
    private final String ENDTUNDERLINE = "</u>";

    private final LinkedList<String> list = new LinkedList<>();
    private final LinkedList<String> redolist = new LinkedList<>();


    @Override
    public void add(String stringToAdd, int position) {
        initIndexView();
        if (list.size() == 0) {
            list.add(0, stringToAdd);
        } else {
            StringBuilder sb = new StringBuilder(list.getLast());
            sb.insert(position, stringToAdd);
            list.addLast(sb.toString());
        }

    }

    @Override
    public void remove(int fromPos, int toPos) {
        initIndexView();
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder(list.getLast());
            sb.delete(fromPos, toPos);

            list.addLast(sb.toString());
        }

    }


    @Override
    public void bold(int fromPos, int toPos) {
        initIndexView();
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder(list.getLast());

            sb.insert(fromPos, STARTBOLD);

            sb.insert(toPos + 4, ENDBOLD);

            list.addLast(sb.toString());
        }

    }

    @Override
    public void italic(int fromPos, int toPos) {
        initIndexView();
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder(list.getLast());

            sb.insert(fromPos, STARTITALIC);

            sb.insert(toPos + 4, ENDITALIC);

            list.addLast(sb.toString());
        }

    }

    @Override
    public void uderline(int fromPos, int toPos) {
        initIndexView();
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder(list.getLast());

            sb.insert(fromPos, STARTUNDERLINE);

            sb.insert(toPos + 4, ENDTUNDERLINE);

            list.addLast(sb.toString());
        }
    }

    @Override
    public void undo() {
        if (list.size()>0) {
            redolist.add(list.getLast());
            list.removeLast();
        }
    }

    @Override
    public String print() {
        return list.getLast();
    }

    @Override
    public void redo() {
        if (redolist.size()>0) {
            list.add(redolist.getLast());
            redolist.removeLast();
        }
    }

    private void initIndexView() {
        redolist.clear();
    }


}
