package com.example.studyhubtanishq;

public class Contact {
    private String name;
    private String post;
    private int imageid;

    public Contact(String name, String post, int imageid){
        this.name = name;
        this.post = post;
        this.imageid = imageid;
    }
    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
