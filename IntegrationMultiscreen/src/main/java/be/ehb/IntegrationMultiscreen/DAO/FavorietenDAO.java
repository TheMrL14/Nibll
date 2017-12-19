/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;
import be.ehb.IntegrationMultiscreen.model.Favoriet;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author MaartenH
 */
public class FavorietenDAO {
    public static ArrayList<Favoriet> getFavorieten() {
		ArrayList<Favoriet> resultaat = new ArrayList<Favoriet>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Favorieten");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Favoriet huidigeSnoep = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeSnoep);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Favoriet getFavorietById(int id) {
		Favoriet resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Favorieten where favorietId = ?", new Object[] { id });
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

	public static int voegFavorietToe(Favoriet nieuweFavoriet) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.Favorieten (favorietId, naamFavoriet, deviceId,profielId) VALUES (?,?,?,?)", new Object[] { nieuweFavoriet.getFavorietId(), nieuweFavoriet.getNaamFavoriet(), nieuweFavoriet.getDeviceId(),nieuweFavoriet.getProfielId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateFavoriet(Favoriet nieuweFavoriet) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.Favoriet SET favorietId = ?, naamFavoriet = ?, deviceId = ?,profielId WHERE favorietId = ?", new Object[] { nieuweFavoriet.getFavorietId(), nieuweFavoriet.getNaamFavoriet(), nieuweFavoriet.getDeviceId(), nieuweFavoriet.getProfielId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderFavoriet(int favorietId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.Favoriet WHERE favorietId = ?", new Object[] { favorietId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Favoriet converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Favoriet(mijnResultset.getInt("favorietId"), mijnResultset.getString("naamFavoriet"), mijnResultset.getInt("deviceId"), mijnResultset.getInt("profielId"));
	}
}
