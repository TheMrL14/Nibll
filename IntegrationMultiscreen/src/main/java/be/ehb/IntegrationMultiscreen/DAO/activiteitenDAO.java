/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;
import be.ehb.IntegrationMultiscreen.model.Activiteit;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author MaartenH
 */
public class activiteitenDAO {
    public static ArrayList<Activiteit> getActiviteitjes() {
		ArrayList<Activiteit> resultaat = new ArrayList<Activiteit>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Activiteit");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Activiteit huidigeActiviteit = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeActiviteit);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Activiteit getActiviteitById(int id) {
		Activiteit resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Activiteit where ActiviteitId = ?", new Object[] { id });
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

	public static int voegActiviteitToe(Activiteit nieuweActiviteit) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Activiteit (naamActiviteit, deviceId, outputActie,profielId,kamerId) VALUES (?,?,?,?,?)", new Object[] { nieuweActiviteit.getNaamActiviteit(), nieuweActiviteit.getDeviceId(), nieuweActiviteit.getOutputActie(), nieuweActiviteit.getProfielId(),nieuweActiviteit.getKamerId(), nieuweActiviteit.getActiviteitId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateActiviteit(Activiteit nieuweActiviteit) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Activiteit SET naamActiviteit = ?, deviceId = ?, outputActie = ?, profielId = ?, kamerId = ? WHERE ActiviteitId = ?", new Object[] {  nieuweActiviteit.getNaamActiviteit(), nieuweActiviteit.getDeviceId(), nieuweActiviteit.getOutputActie(), nieuweActiviteit.getProfielId(),nieuweActiviteit.getKamerId(), nieuweActiviteit.getActiviteitId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderActiviteit(int activiteitId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Activiteit WHERE ActiviteitId = ?", new Object[] { activiteitId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Activiteit converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Activiteit(mijnResultset.getInt("activiteitId"), mijnResultset.getString("naamActiviteit"), mijnResultset.getInt("deviceId"), mijnResultset.getString("outputActie"), mijnResultset.getInt("profielId"), mijnResultset.getInt("kamerId"));
	}
}
