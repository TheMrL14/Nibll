/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;
import be.ehb.IntegrationMultiscreen.model.Kamer;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author MaartenH
 */
public class KamerDAO {
    public static ArrayList<Kamer> getKamers() {
		ArrayList<Kamer> resultaat = new ArrayList<Kamer>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Kamer");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Kamer huidigeSnoep = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeSnoep);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Kamer getKamerById(int id) {
		Kamer resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Kamer where kamerId = ?", new Object[] { id });
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

	public static int voegKamerToe(Kamer nieuweKamer) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.Kamer (kamerId, sensorId, naamKamer) VALUES (?,?,?)", new Object[] { nieuweKamer.getKamerId(),nieuweKamer.getSensorId(),nieuweKamer.getNaamKamer()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateKamer(Kamer nieuweKamer) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.Kamer SET kamerId = ?,sensorId=? ,naamKamer = ? WHERE kamerId = ?", new Object[] { nieuweKamer.getKamerId(), nieuweKamer.getNaamKamer()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderKamer(int favorietId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.Kamer WHERE kamerId = ?", new Object[] { favorietId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Kamer converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Kamer(mijnResultset.getInt("kamerId"), mijnResultset.getInt("sensorId"), mijnResultset.getString("naamKamer"));
	}
}
