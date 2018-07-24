package com.learn.ashutosh.bottomnav.DataModelDao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import com.learn.ashutosh.bottomnav.DataModel.Customer;

@Database(entities = {Customer.class}, version = 1)
public abstract class DatabaseRoom extends RoomDatabase {

    private static DatabaseRoom INSTANCE;

    public abstract CustomerDao customerDao();

    public static DatabaseRoom getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseRoom.class, "m2s_database")
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
