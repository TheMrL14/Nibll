package com.example.bojan.nibllbojanactivities.database.dao;

/**
 * Created by bojan on 20-Dec-17.
 */

        import android.arch.persistence.room.Dao;
        import android.arch.persistence.room.Delete;
        import android.arch.persistence.room.Insert;
        import android.arch.persistence.room.Query;
        import android.arch.persistence.room.Update;

        import com.example.bojan.nibllbojanactivities.model.Device;

        import java.util.List;

/**
 * Created by nick on 10/12/2017.
 */
@Dao
public interface DeviceDao {

    @Query("SELECT * FROM device")
    public List<Device> getAlleDevice();

    @Query("SELECT * FROM device WHERE deviceId=:id")
    public Device getDeviceById(int id);

    @Insert
    public long voegNieuweDeviceToe(Device nieuwDevice);

    @Update
    public int updateDevice(Device geupdateDevice);

    @Delete
    public int verwijderDevice (Device teVerwijderenDevice);
}
