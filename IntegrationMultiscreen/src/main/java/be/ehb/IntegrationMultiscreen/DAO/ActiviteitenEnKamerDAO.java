/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;

import be.ehb.IntegrationMultiscreen.viewModel.ActiviteitenEnKamer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lennert
 */
public class ActiviteitenEnKamerDAO {
    public static ArrayList<ActiviteitenEnKamer> getActiviteitenEnKamer() {
		ArrayList<ActiviteitenEnKamer> resultaat = new ArrayList<ActiviteitenEnKamer>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.ActiviteitenEnKamerenEnKamer");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					ActiviteitenEnKamer huidigeActiviteitenEnKamer = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeActiviteitenEnKamer);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static ActiviteitenEnKamer getActiviteitenEnKamerById(int id) {
		ActiviteitenEnKamer resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.ActiviteitenEnKamerenEnKamer where idActiviteitenEnKamer = ?", new Object[] { id });
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

	public static int voegActiviteitenEnKamerToe(ActiviteitenEnKamer nieuweActiviteitenEnKamer) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.ActiviteitenEnKamerenEnKamer (kamerId, activiteitId,) VALUES (?,?)", new Object[] { nieuweActiviteitenEnKamer.getKamerId(),  nieuweActiviteitenEnKamer.getActiviteitenId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateActiviteitenEnKamer(ActiviteitenEnKamer nieuweActiviteitenEnKamer) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.ActiviteitenEnKamerenEnKamer SET kamerId = ?,  activiteitId = ? WHERE idActiviteitenEnKamer = ?", new Object[] {  nieuweActiviteitenEnKamer.getKamerId(),  nieuweActiviteitenEnKamer.getActiviteitenId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderActiviteitenEnKamer(int activiteitId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.ActiviteitenEnKamerenEnKamer WHERE idActiviteitenEnKamer = ?", new Object[] { activiteitId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static ActiviteitenEnKamer converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new ActiviteitenEnKamer(mijnResultset.getInt("idActiviteitenEnKamer"), mijnResultset.getInt("kamerId"), mijnResultset.getInt("activiteitId"));
	}
}
