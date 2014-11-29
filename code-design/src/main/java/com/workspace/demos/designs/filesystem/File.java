package com.workspace.demos.designs.filesystem;

/**
 * Created by deepak on 11/26/14.
 */
public class File extends Entity {

    long size;
    String content;
    String type;

    public File(String parent, String name, String content) {
        super(parent, name);
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
