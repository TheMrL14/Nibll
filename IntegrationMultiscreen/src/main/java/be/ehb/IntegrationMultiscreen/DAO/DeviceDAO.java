/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;
import be.ehb.IntegrationMultiscreen.model.Device;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Lennert
 */
public class DeviceDAO {
    public static ArrayList<Device> getDevice() {
		ArrayList<Device> resultaat = new ArrayList<Device>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Device");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Device huidigeDevice = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeDevice);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Device getDeviceById(int id) {
		Device resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Device where deviceId = ?", new Object[] { id });
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
        
       public static int setStatusById(int id,int status) {
		int aantalAangepasteRijen = 0;
                int[] idStatus; 
                idStatus = new int[2];
                idStatus[0] = id;
                idStatus[1] = status;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.Device SET  status = ? WHERE deviceId = ?", new Object[] { idStatus[1],idStatus[0] });
		} catch (SQLException ex) {
			System.out.println("foutje");
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int voegDeviceToe(Device nieuweDevice) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.Device (inputWaarde, outputWaarde, status, naamDevice) VALUES (?,?,?,?)", new Object[] { nieuweDevice.getInputWaarde(), nieuweDevice.getOutputWaarde(), nieuweDevice.getStatus(), nieuweDevice.getNaamDevice()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateDevice(Device nieuweDevice) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.Device SET inputWaarde = ?, outputWaarde = ?, status = ?, naamDevice = ? WHERE deviceId = ?", new Object[] {  nieuweDevice.getInputWaarde(), nieuweDevice.getOutputWaarde(), nieuweDevice.getStatus(), nieuweDevice.getNaamDevice()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderDevice(int activiteitId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.Device WHERE deviceId = ?", new Object[] { activiteitId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Device converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Device(mijnResultset.getInt("deviceId"), mijnResultset.getDouble("inputWaarde"), mijnResultset.getDouble("outputWaarde"),mijnResultset.getBoolean("status"),mijnResultset.getString("naamDevice"));
	}
}
