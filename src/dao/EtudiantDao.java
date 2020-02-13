package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			
			String sql ="INSERT INTO Etudiant " + "VALUES ("+etudiant.getId()+", '"+etudiant.getNom()+"', '"+etudiant.getPrenom()+"', '"+etudiant.getEmail()+"')";
			
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
			System.out.println("Cet id est deja pris");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Cet id est deja pris");
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
	

public void modifierEtudiant(int id, String email ) {
	
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
				
				String sql = "Update Etudiant Set EmailEtu= '"+email +"'where IdEtu ='"+id+"'";
				
				// Etape 4 : Ex�cution requ�te
				resultat= statement.executeUpdate(sql);
				
				if(resultat==0) {
					System.out.println("Aucun etudiant ne possède cet id \n");
				}else {
					System.out.println("Nouvelle email mise a jour \n");
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
public void supprimerEtudiant(int id) {
	
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
				
				String sql = "delete from Etudiant where IdEtu ='"+id+"'";
				
				// Etape 4 : Ex�cution requ�te
				resultat= statement.executeUpdate(sql);
				
				if(resultat==0) {
					System.out.println("Aucun etudiant ne possède cet id \n");
				}else {
					System.out.println("L'etudiant a bien été supprimé \n");
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

public List<Etudiant> listerEtudiants() {
	
	
	// Information d'acc�s � la base de donn�es
	String url = "jdbc:mysql://localhost:8889/gestionecole";
	String login = "root";
	String password = "root";
	ResultSet rs=null;
	List<Etudiant> listeEtu = new ArrayList<Etudiant>();
	
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
		
		//String sql = "INSERT INTO 'Etudiant' VALUES ("+idEtudiant+","+nomEtudiant+","+prenomEtudiant+","+mailEtudiant+","+adresseEtudiant+","+telephoneEtudiant+","+dateNaissanceEtudiant+")\"";
		String sql ="Select * FROM Etudiant ";
		
		// Etape 4 : Ex�cution requ�te
		rs=statement.executeQuery(sql);
		while(rs.next()) {
			listeEtu.add(new Etudiant(rs.getInt("IdEtu"),rs.getString("NomEtu"),rs.getString("PrenomEtu"),rs.getString("EmailEtu")));
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
	return listeEtu;
}

public Etudiant getEtudiantById(int id) {
	// Information d'acc�s � la base de donn�es
	String url = "jdbc:mysql://localhost:8889/gestionecole";
	String login = "root";
	String password = "root";
	ResultSet rs=null;
	List<Etudiant> listeEtu = new ArrayList<Etudiant>();
	
	Connection connection = null;
	Statement statement = null;
	Etudiant etudiant = null;
	
	try
	{
		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Etape 2 : R�cup�ration de la connexion
		connection = DriverManager.getConnection(url, login, password);
		
		// Etape 3 : Cr�ation d'un statement
		statement = connection.createStatement();
		
		//String sql = "INSERT INTO 'Etudiant' VALUES ("+idEtudiant+","+nomEtudiant+","+prenomEtudiant+","+mailEtudiant+","+adresseEtudiant+","+telephoneEtudiant+","+dateNaissanceEtudiant+")\"";
		String sql ="Select * FROM Etudiant WHERE id ='"+id+"'";
		
		// Etape 4 : Ex�cution requ�te
		rs=statement.executeQuery(sql);
		rs.next();
		etudiant = new Etudiant(rs.getInt("IdEtu"),rs.getString("NomEtu"),rs.getString("PrenomEtu"),rs.getString("EmailEtu"));
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
	return etudiant;
}
}
