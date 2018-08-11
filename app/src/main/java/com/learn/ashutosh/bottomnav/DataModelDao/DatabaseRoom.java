package com.learn.ashutosh.bottomnav.DataModelDao;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


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
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private final CustomerDao mCustomerDao;

        public PopulateDbAsync(DatabaseRoom database) {
            mCustomerDao = database.customerDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mCustomerDao.deleteAll();
            Customer customer = new Customer("Ashutosh","9989","adfasd@email.com","Bangalore");
            mCustomerDao.insert(customer);
              customer = new Customer("Shanu","9989","adfasd@email.com","Bangalore");
            mCustomerDao.insert(customer);

            return null;
        }
    }
}
