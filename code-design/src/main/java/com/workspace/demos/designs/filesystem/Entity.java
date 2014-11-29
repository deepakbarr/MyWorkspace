package com.workspace.demos.designs.filesystem;

/**
 * Created by deepak on 11/26/14.
 */
public abstract class Entity {

    String parent;
    String name;
    Long createdDate;
    Long lastModifiedDate;


    protected Entity(String parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public abstract double size();
}
