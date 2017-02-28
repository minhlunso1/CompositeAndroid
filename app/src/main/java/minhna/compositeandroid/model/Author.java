package minhna.compositeandroid.model;

import javax.inject.Inject;

/**
 * Created by Administrator on 28-Feb-17.
 */

public class Author {

    public String name;

    @Inject
    public Author(String name) {
        this.name = name;
    }

}
