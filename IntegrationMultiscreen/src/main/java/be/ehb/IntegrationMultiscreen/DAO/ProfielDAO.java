/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;
import be.ehb.IntegrationMultiscreen.model.Profiel;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author MaartenH
 */
public class ProfielDAO {
    public static ArrayList<Profiel> getProfielen() {
		ArrayList<Profiel> resultaat = new ArrayList<Profiel>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Profiel");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Profiel huidigeSnoep = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeSnoep);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Profiel getProfielById(int id) {
		Profiel resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Profiel where profielId = ?", new Object[] { id });
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

	public static int voegProfielToe(Profiel nieuweProfiel) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.Profiel ( naamProfiel) VALUES (?)", new Object[] { nieuweProfiel.getNaamProfiel()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateProfiel(Profiel nieuweProfiel) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.Profiel SET naamProfiel = ? WHERE profielId = ?", new Object[] { nieuweProfiel.getProfielId(), nieuweProfiel.getNaamProfiel()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderProfiel(int favorietId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.Profiel WHERE profielId = ?", new Object[] { favorietId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Profiel converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Profiel(mijnResultset.getInt("profielId"), mijnResultset.getString("naamProfiel"));
	}
}
