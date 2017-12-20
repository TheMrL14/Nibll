/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wc7_1.dao;

import com.mycompany.wc7_1.model.Planeet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lione
 */
public class PlanetenDao {
    public static ArrayList<Planeet> getPlaneet() {
		ArrayList<Planeet> resultaat = new ArrayList<Planeet>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Planeet");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Planeet huidigePlaneet = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigePlaneet);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Planeet getPlaneetById(int id) {
		Planeet resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Planeet where planeetId = ?", new Object[] { id });
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
        
        
        public static ArrayList<Planeet> getPlaneetBygemmenteId(int id) {
		ArrayList<Planeet> resultaat = new ArrayList<Planeet>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Planeet where gemeenteId = ?", new Object[] { id });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Planeet huidigePlaneet = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigePlaneet);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return resultaat;
	}

	public static int voegPlaneetToe(Planeet nieuwePlaneet) {
		int gemeenteIdAangepasteRijen = 0;
		try {
			gemeenteIdAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Planeet (naam, gemeenteId) VALUES (?,?)", new Object[] { nieuwePlaneet.getPlaneetNaam(), nieuwePlaneet.getPlaneetId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return gemeenteIdAangepasteRijen;
	}

	public static int updatePlaneet(Planeet nieuwePlaneet) {
		int gemeenteIdAangepasteRijen = 0;
		try {
			gemeenteIdAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Planeet SET naam = ?, gemeenteId = ? WHERE straatId = ?", new Object[] { nieuwePlaneet.getPlaneetNaam(), nieuwePlaneet.getPlaneetId(), nieuwePlaneet.getPlaneetId() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return gemeenteIdAangepasteRijen;
	}

	public static int verwijderPlaneet(int PlaneetId) {
		int gemeenteIdAangepasteRijen = 0;
		try {
			gemeenteIdAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Planeet WHERE PlaneetId = ?", new Object[] { PlaneetId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return gemeenteIdAangepasteRijen;
	}

	private static Planeet converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Planeet(mijnResultset.getInt("PlaneetId"), mijnResultset.getInt("gemeenteId"), mijnResultset.getString("naam"));
	}
}
