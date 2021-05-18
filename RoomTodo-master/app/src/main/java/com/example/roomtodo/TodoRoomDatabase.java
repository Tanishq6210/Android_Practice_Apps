package com.example.roomtodo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Step 1: Database Class
 */

// Step 1 - Annotate with @ Database
@Database(entities = {Todo.class}, version = 1)
public abstract class TodoRoomDatabase extends RoomDatabase {// Step 2 - Should be an abstract class and Step3 - Extend Room database

    public abstract TodoDao todoDao(); // Step 5

    //Singleton pattern
    private static volatile TodoRoomDatabase INSTANCE;

    static TodoRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TodoRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TodoRoomDatabase.class, "Todo_Database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
