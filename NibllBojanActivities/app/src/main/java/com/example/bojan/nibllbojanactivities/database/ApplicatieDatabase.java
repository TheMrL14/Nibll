package com.example.bojan.nibllbojanactivities.database;

/**
 * Created by bojan on 20-Dec-17.
 */

        import android.arch.persistence.db.SupportSQLiteDatabase;
        import android.arch.persistence.room.Database;
        import android.arch.persistence.room.Room;
        import android.arch.persistence.room.RoomDatabase;
        import android.arch.persistence.room.migration.Migration;
        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.util.Log;

        import com.example.bojan.nibllbojanactivities.database.dao.DeviceDao;
        import com.example.bojan.nibllbojanactivities.model.Device;

@Database(entities = {Device.class}, version = 1)
public abstract class ApplicatieDatabase extends RoomDatabase {
    private static ApplicatieDatabase mijnSingleton;

    //Dao's relateren
    public abstract DeviceDao getDeviceDao();

    public static ApplicatieDatabase getDatabase(Context context) {
        if (mijnSingleton == null) {
            //maakt de database effectief aam
            mijnSingleton = Room.databaseBuilder(context.getApplicationContext(),
                    ApplicatieDatabase.class, "DeviceActivity").addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    Log.d("Database gecreerd", "De databank werd aangemaakt");
                    super.onCreate(db);
                }

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    Log.d("Database geopend", "De databank werd geopend");
                    super.onOpen(db);
                }
            }).addMigrations(new Migration(1,2) {
                @Override
                public void migrate(@NonNull SupportSQLiteDatabase database) {
                    database.execSQL("CREATE TABLE");
                }
            }).build();
        }
        return mijnSingleton;
    }

    protected ApplicatieDatabase() {super();}
}