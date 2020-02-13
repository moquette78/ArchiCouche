package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import metier.Etudiant;

public class EtudiantDao {
	
public void insererEtudiant( Etudiant etudiant) {
	
		
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://localhost:8889/gestionecole";
		String login = "root";
		String password = "root";
		int resultat;
		
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql ="INSERT INTO Etudiant " + "VALUES ('"+etudiant.getId()+"', "+etudiant.getNom()+"', "+etudiant.getPrenom()+"', "+etudiant.getEmail()+")";
			
			// Etape 4 : Ex�cution requ�te
			resultat= statement.executeUpdate(sql);
			
			if(resultat==0) {
				System.out.println("Erreur");
			}else {
				System.out.println("Etudiant ajouté !");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	

public void modifierEtudiant(Etudiant etudiant ) {
	
	// Information d'acc�s � la base de donn�es
			String url = "jdbc:mysql://localhost:8889/gestionecoleez";
			String login = "root";
			String password = "root";
			int resultat;
			
			Connection connection = null;
			Statement statement = null;
			
			try
			{
				// Etape 1 : Chargement du driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// Etape 2 : R�cup�ration de la connexion
				connection = DriverManager.getConnection(url, login, password);
				
				// Etape 3 : Cr�ation d'un statement
				statement = connection.createStatement();
				
				String sql = "Update Etudiant Set email= '"+etudiant.getEmail() +"'where id ='"+etudiant.getId()+"'";
				
				// Etape 4 : Ex�cution requ�te
				resultat= statement.executeUpdate(sql);
				
				if(resultat==0) {
					System.out.println("Aucun etudiant ne possède cet id \n");
				}else {
					System.out.println("Nouvelle id mise a jour \n");
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					// Etape 5 : Lib�rer ressources de la m�moire
					connection.close();
					statement.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
	
}
public void supprimerEtudiant() {
	
}

public void listerEtudiants() {
	

}
}
