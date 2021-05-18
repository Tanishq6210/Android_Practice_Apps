package com.example.roomtodo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Step 2: Entity
 * An object containing the table.
 */
@Entity(tableName = "todo_table")
public class Todo {

    @PrimaryKey(autoGenerate = true) // Primary key because this will be unique for every TODO and will be automatically generated
    @ColumnInfo(name = "todo_uid")
    private int uid;

    @ColumnInfo(name = "todo_text") // Column name todo_text
    private String text;

    @ColumnInfo(name = "todo_completed") //Column name todo_completed
    private boolean completed;

    // Constructor to make a single TODO
    public Todo(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "uid=" + uid +
                ", text='" + text + '\'' +
                ", completed=" + completed +
                '}';
    }
}
