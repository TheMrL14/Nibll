/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;
import java.sql.*;
import java.util.ArrayList;

import be.lennertvandenherrewegen.model.Snoep;
import be.lennertvandenherrewegen.model.Smaak;
/**
 *
 * @author MaartenH
 */
public class snoepDAO {
    public static ArrayList<Snoep> getSnoepjes() {
		ArrayList<Snoep> resultaat = new ArrayList<Snoep>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Snoep");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Snoep huidigeSnoep = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeSnoep);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Snoep getSnoepById(int id) {
		Snoep resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Snoep where SnoepId = ?", new Object[] { id });
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

	public static int voegSnoepToe(Snoep nieuweSnoep) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Snoep (smaakId, naam, chaloriewaarde) VALUES (?,?,?)", new Object[] { nieuweSnoep.getSmaakId(), nieuweSnoep.getNaam(), nieuweSnoep.getCaloriewaarde()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateSnoep(Snoep nieuweSnoep) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Snoep SET smaakId = ?, naam = ?, chaloriewaarde = ? WHERE SnoepId = ?", new Object[] { nieuweSnoep.getSmaakId(), nieuweSnoep.getNaam(), nieuweSnoep.getCaloriewaarde(), nieuweSnoep.getSnoepId() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderSnoep(int snoepId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Snoep WHERE SnoepId = ?", new Object[] { snoepId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Snoep converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Snoep(mijnResultset.getInt("snoepId"), mijnResultset.getInt("smaakId"), mijnResultset.getString("naam"), mijnResultset.getInt("chaloriewaarde"));
	}
}
