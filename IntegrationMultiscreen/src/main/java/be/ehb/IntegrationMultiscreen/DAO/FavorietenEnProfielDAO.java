/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;

import be.ehb.IntegrationMultiscreen.viewModel.FavorietenEnProfiel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lennert
 */
public class FavorietenEnProfielDAO {
    public static ArrayList<FavorietenEnProfiel> getFavorietenEnProfiel() {
		ArrayList<FavorietenEnProfiel> resultaat = new ArrayList<FavorietenEnProfiel>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.FavorietenEnProfielen");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					FavorietenEnProfiel huidigeFavorietenEnProfiel = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeFavorietenEnProfiel);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static FavorietenEnProfiel getFavorietenEnProfielById(int id) {
		FavorietenEnProfiel resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.FavorietenEnProfielen where idFavorietenEnProfiel = ?", new Object[] { id });
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

	public static int voegFavorietenEnProfielToe(FavorietenEnProfiel nieuweFavorietenEnProfiel) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.FavorietenEnProfielen (favorietenId, profielId,) VALUES (?,?)", new Object[] { nieuweFavorietenEnProfiel.getFavorietenId(),  nieuweFavorietenEnProfiel.getProfielId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateFavorietenEnProfiel(FavorietenEnProfiel nieuweFavorietenEnProfiel) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.FavorietenEnProfielen SET favorietenId = ?,  deviceId = ? WHERE idFavorietenEnProfiel = ?", new Object[] {  nieuweFavorietenEnProfiel.getFavorietenId(),  nieuweFavorietenEnProfiel.getProfielId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderFavorietenEnProfiel(int activiteitId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.FavorietenEnProfielenEnKamer WHERE idFavorietenEnProfiel = ?", new Object[] { activiteitId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static FavorietenEnProfiel converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new FavorietenEnProfiel(mijnResultset.getInt("idFavorietenEnProfiel"), mijnResultset.getInt("favorietenId"), mijnResultset.getInt("profielId"));
	}
}
