package com.workspace.demos.designs.filesystem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by deepak on 11/26/14.
 */
public class Directory extends Entity {

    List<Entity> list;
    int count;

    protected Directory(String parent, String name) {
        super(parent, name);
        list = new LinkedList<Entity>();
        count = 0;
    }


    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void addContent(Entity e) {
        list.add(e);
        count++;
    }

    public void deleteContent(Entity e) {
        boolean status = false;
        if (e instanceof File)
            status = list.remove(e);
        else if (e instanceof Directory) {
            if (!((Directory) e).isEmpty()) {
                ((Directory) e).getList().clear();
            }
            status = list.remove(e);
        }
        if (status)
            count--;
    }

    @Override
    public double size() {
        for (Entity e : list) {
        }
    }

    public List<Entity> getList() {
        return list;
    }
}

