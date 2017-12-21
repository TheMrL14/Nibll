/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;

import be.ehb.IntegrationMultiscreen.viewModel.DeviceEnSensor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lennert
 */
public class DeviceEnSensorDAO {
    public static ArrayList<DeviceEnSensor> getDeviceEnSensor() {
		ArrayList<DeviceEnSensor> resultaat = new ArrayList<DeviceEnSensor>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.DeviceEnSensoren");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					DeviceEnSensor huidigeDeviceEnSensor = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeDeviceEnSensor);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static DeviceEnSensor getDeviceEnSensorById(int id) {
		DeviceEnSensor resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.DeviceEnSensoren where idDeviceEnSensor = ?", new Object[] { id });
			if (mijnResultset != null) {
				mijnResultset.first();
				resultaat = converteerHuidigeRijNaarObject(mijnResultset);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static int voegDeviceEnSensorToe(DeviceEnSensor nieuweDeviceEnSensor) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.DeviceEnSensoren (deviceId, sensorId,) VALUES (?,?)", new Object[] { nieuweDeviceEnSensor.getDeviceId(),  nieuweDeviceEnSensor.getSensorId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateDeviceEnSensor(DeviceEnSensor nieuweDeviceEnSensor) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.DeviceEnSensoren SET deviceId = ?,  sensorId = ? WHERE idDeviceEnSensor = ?", new Object[] {  nieuweDeviceEnSensor.getDeviceId(),  nieuweDeviceEnSensor.getSensorId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderDeviceEnSensor(int activiteitId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.DeviceEnSensorenEnKamer WHERE idDeviceEnSensor = ?", new Object[] { activiteitId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static DeviceEnSensor converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new DeviceEnSensor(mijnResultset.getInt("idDeviceEnSensor"), mijnResultset.getInt("deviceId"), mijnResultset.getInt("sensorId"));
	}
}
