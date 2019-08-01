package com.haimbentouza.wordbuilder.manager;

import org.springframework.stereotype.Component;

@Component
public class WordManager extends BaseWord {
    private final String STARTBOLD = "<b>";
    private final String ENDBOLD = "</b>";

    private final String STARTITALIC = "<i>";
    private final String ENDITALIC = "</i>";

    private final String STARTUNDERLINE = "<u>";
    private final String ENDTUNDERLINE = "</u>";


    @Override
    public void add(String stringToAdd, int position) {
        super.initIndexView();
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
        super.initIndexView();
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder(list.getLast());
            sb.delete(fromPos, toPos);

            list.addLast(sb.toString());
        }

    }


    @Override
    public void bold(int fromPos, int toPos) {
        super.initIndexView();
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder(list.getLast());

            sb.insert(fromPos, STARTBOLD);

            sb.insert(toPos + 4, ENDBOLD);

            list.addLast(sb.toString());
        }

    }

    @Override
    public void italic(int fromPos, int toPos) {
        super.initIndexView();
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder(list.getLast());

            sb.insert(fromPos, STARTITALIC);

            sb.insert(toPos + 4, ENDITALIC);

            list.addLast(sb.toString());
        }

    }

    @Override
    public void uderline(int fromPos, int toPos) {
        super.initIndexView();
        if (list.size() != 0) {
            StringBuilder sb = new StringBuilder(list.getLast());

            sb.insert(fromPos, STARTUNDERLINE);

            sb.insert(toPos + 4, ENDTUNDERLINE);

            list.addLast(sb.toString());
        }
    }

    @Override
    public void undo() {
        undolist.add(list.getLast());
        list.removeLast();
    }

    @Override
    public String print() {
        return list.getLast();
    }

    @Override
    public void redo() {
        list.add(undolist.getLast());
        undolist.removeLast();
    }


}
