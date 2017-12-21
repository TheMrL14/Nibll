/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;

import be.ehb.IntegrationMultiscreen.viewModel.ActiviteitenDeviceEnOutput;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lennert
 */
public class ActiviteitenDeviceEnOutputDAO {
    public static ArrayList<ActiviteitenDeviceEnOutput> getActiviteitenDeviceEnOutput() {
		ArrayList<ActiviteitenDeviceEnOutput> resultaat = new ArrayList<ActiviteitenDeviceEnOutput>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.ActiviteitenDeviceEnOutput");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					ActiviteitenDeviceEnOutput huidigeActiviteitenDeviceEnOutput = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeActiviteitenDeviceEnOutput);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static ActiviteitenDeviceEnOutput getActiviteitenDeviceEnOutputById(int id) {
		ActiviteitenDeviceEnOutput resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.ActiviteitenDeviceEnOutputenEnKamer where idActiviteitenDeviceEnOutput = ?", new Object[] { id });
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

	public static int voegActiviteitenDeviceEnOutputToe(ActiviteitenDeviceEnOutput nieuweActiviteitenDeviceEnOutput) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.ActiviteitenDeviceEnOutputen (activiteitId,deviceId,outputWaarde) VALUES (?,?,?)", new Object[] { nieuweActiviteitenDeviceEnOutput.getActiviteitId(),  nieuweActiviteitenDeviceEnOutput.getDeviceId(),nieuweActiviteitenDeviceEnOutput.getOutputWaarde()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateActiviteitenDeviceEnOutput(ActiviteitenDeviceEnOutput nieuweActiviteitenDeviceEnOutput) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.ActiviteitenDeviceEnOutputenEnKamer SET  activiteitId = ?, deviceId = ?, outputWaarde = ?  WHERE activiteitenEnKamerId = ?", new Object[] {  nieuweActiviteitenDeviceEnOutput.getActiviteitId(),  nieuweActiviteitenDeviceEnOutput.getDeviceId(), nieuweActiviteitenDeviceEnOutput.getOutputWaarde()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderActiviteitenDeviceEnOutput(int idActiviteitDeviceEnOutput) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.ActiviteitenDeviceEnOutputenEnKamer WHERE idActiviteitDeviceEnOutput = ?", new Object[] { idActiviteitDeviceEnOutput });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static ActiviteitenDeviceEnOutput converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new ActiviteitenDeviceEnOutput(mijnResultset.getInt("idActiviteitenDeviceEnOutput"), mijnResultset.getInt("activiteitId"), mijnResultset.getInt("deviceId"), mijnResultset.getInt("outputWaarde"));
	}
}
