/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;

import be.ehb.IntegrationMultiscreen.viewModel.KamerEnDevice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lennert
 */
public class KamerEnDeviceDAO {
    public static ArrayList<KamerEnDevice> getKamerEnDevice() {
		ArrayList<KamerEnDevice> resultaat = new ArrayList<KamerEnDevice>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.KamerEnDeviceenEnKamer");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					KamerEnDevice huidigeKamerEnDevice = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeKamerEnDevice);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static KamerEnDevice getKamerEnDeviceById(int id) {
		KamerEnDevice resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.KamerEnDeviceenEnKamer where idKamerEnDevice = ?", new Object[] { id });
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

	public static int voegKamerEnDeviceToe(KamerEnDevice nieuweKamerEnDevice) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.KamerEnDeviceenEnKamer (kamerId, deviceId,) VALUES (?,?)", new Object[] { nieuweKamerEnDevice.getKamerId(),  nieuweKamerEnDevice.getDeviceId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateKamerEnDevice(KamerEnDevice nieuweKamerEnDevice) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.KamerEnDeviceenEnKamer SET kamerId = ?,  deviceId = ? WHERE idKamerEnDevice = ?", new Object[] {  nieuweKamerEnDevice.getKamerId(),  nieuweKamerEnDevice.getDeviceId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderKamerEnDevice(int idNieuweKamerEnDevice) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.KamerEnDeviceenEnKamer WHERE idKamerEnDevice = ?", new Object[] { idNieuweKamerEnDevice });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static KamerEnDevice converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new KamerEnDevice(mijnResultset.getInt("idKamerEnDevice"), mijnResultset.getInt("kamerId"), mijnResultset.getInt("deviceId"));
	}
}
