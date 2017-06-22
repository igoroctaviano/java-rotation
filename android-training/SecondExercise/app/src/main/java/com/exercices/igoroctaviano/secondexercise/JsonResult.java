package com.exercices.igoroctaviano.secondexercise;

import java.util.ArrayList;
import java.util.List;

public class JsonResult {

    private int count;
    private String next;
    private String previous;
    private List<Profile> results;

    public JsonResult(int count, String next, String previous, List<Profile> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return this.next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return this.previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Profile> getResults() {
        if (this.results == null) { return new ArrayList<>(); }
        return this.results;
    }

    public void setResults(List<Profile> results) {
        this.results = results;
    }
}
