/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.DAO;
import be.ehb.IntegrationMultiscreen.model.AccesRight;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Lennert
 */
public class AccesRightDAO {
    public static ArrayList<AccesRight> getAccesRight() {
		ArrayList<AccesRight> resultaat = new ArrayList<AccesRight>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.AccesRight");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					AccesRight huidigeAccesRight = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeAccesRight);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static AccesRight getAccesRightById(int id) {
		AccesRight resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from IP1718004.AccesRight where accesRightId = ?", new Object[] { id });
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

	public static int voegAccesRightToe(AccesRight nieuweAccesRight) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO IP1718004. AccesRight (deviceId, profielId) VALUES (?,?)", new Object[] { nieuweAccesRight.getDeviceId(), nieuweAccesRight.getProfielId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateAccesRight(AccesRight nieuweAccesRight) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE IP1718004.AccesRight SET deviceId = ?, profielId = ? WHERE accesRightId = ?", new Object[] {  nieuweAccesRight.getDeviceId(), nieuweAccesRight.getProfielId(),});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderAccesRight(int activiteitId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM IP1718004.AccesRight WHERE accesRightId = ?", new Object[] { activiteitId });
		} catch (SQLException ex) {
			ex.printStackTrace();
                        
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static AccesRight converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new AccesRight(mijnResultset.getInt("accesRightId"), mijnResultset.getInt("profielId"), mijnResultset.getInt("deviceId"));
	}
}
