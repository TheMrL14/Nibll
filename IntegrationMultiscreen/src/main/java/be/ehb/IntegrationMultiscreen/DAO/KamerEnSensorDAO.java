/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;

import be.ehb.IntegrationMultiscreen.viewModel.KamerEnSensor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lennert
 */
public class KamerEnSensorDAO {
    public static ArrayList<KamerEnSensor> getKamerEnSensor() {
		ArrayList<KamerEnSensor> resultaat = new ArrayList<KamerEnSensor>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.KamerEnSensorenEnKamer");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					KamerEnSensor huidigeKamerEnSensor = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeKamerEnSensor);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static KamerEnSensor getKamerEnSensorById(int id) {
		KamerEnSensor resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.KamerEnSensorenEnKamer where idKamerEnSensor = ?", new Object[] { id });
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

	public static int voegKamerEnSensorToe(KamerEnSensor nieuweKamerEnSensor) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.KamerEnSensorenEnKamer (kamerId, sensorId,) VALUES (?,?)", new Object[] { nieuweKamerEnSensor.getKamerId(),  nieuweKamerEnSensor.getSensorId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateKamerEnSensor(KamerEnSensor nieuweKamerEnSensor) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.KamerEnSensorenEnKamer SET kamerId = ?,  sensorId = ? WHERE idKamerEnSensor = ?", new Object[] {  nieuweKamerEnSensor.getKamerId(),  nieuweKamerEnSensor.getSensorId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderKamerEnSensor(int idNieuweKamerEnSensor) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.KamerEnSensorenEnKamer WHERE idKamerEnSensor = ?", new Object[] { idNieuweKamerEnSensor });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static KamerEnSensor converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new KamerEnSensor(mijnResultset.getInt("idKamerEnSensor"), mijnResultset.getInt("kamerId"), mijnResultset.getInt("sensorId"));
	}
}
