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
public class ActiviteitenDAO {
    public static ArrayList<Activiteit> getActiviteit() {
		ArrayList<Activiteit> resultaat = new ArrayList<Activiteit>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Activiteiten");
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
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.Activiteiten where ActiviteitId = ?", new Object[] { id });
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
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004.Activiteiten (naamActiviteit, outputActie,) VALUES (?,?)", new Object[] { nieuweActiviteit.getNaamActiviteit(), nieuweActiviteit.getOutputActie()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateActiviteit(Activiteit nieuweActiviteit) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.Activiteiten SET naamActiviteit = ?,  outputActie = ? WHERE activiteitId = ?", new Object[] {  nieuweActiviteit.getNaamActiviteit(),  nieuweActiviteit.getOutputActie(), nieuweActiviteit.getActiviteitId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderActiviteit(int activiteitId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.Activiteiten WHERE ActiviteitId = ?", new Object[] { activiteitId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Activiteit converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Activiteit(mijnResultset.getInt("activiteitId"), mijnResultset.getString("naamActiviteit"), mijnResultset.getString("outputActie"));
	}
}
