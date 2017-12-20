/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;
import be.ehb.IntegrationMultiscreen.model.Sensor;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Lennert
 */
public class SensorDAO {
    public static ArrayList<Sensor> getSensor() {
		ArrayList<Sensor> resultaat = new ArrayList<Sensor>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Sensor");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Sensor huidigeSensor = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeSensor);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Sensor getSensorById(int id) {
		Sensor resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Sensor where sensorId = ?", new Object[] { id });
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

	public static int voegSensorToe(Sensor nieuweSensor) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.Sensor (naamSensor, inputWaarde) VALUES (?,?)", new Object[] { nieuweSensor.getNaamSensor(), nieuweSensor.getInputWaarde()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateSensor(Sensor nieuweSensor) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.Sensor SET naamSensor = ?, inputWaarde = ? WHERE sensorId = ?", new Object[] {  nieuweSensor.getNaamSensor(), nieuweSensor.getInputWaarde(),});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderSensor(int sensorId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.Sensor WHERE sensorId = ?", new Object[] { sensorId});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Sensor converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Sensor(mijnResultset.getInt("sensorId"), mijnResultset.getString("naamSensor"), mijnResultset.getDouble("inputWaarde"));
	}
}
