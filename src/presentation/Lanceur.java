package presentation;

import java.util.Scanner;

import metier.Etudiant;
import service.EtudiantService;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Veuillez entrer votrer choix");
		System.out.println("1 - Ajouter");
		System.out.println("2 - Modifier");
		System.out.println("3 - Supprimer");
		System.out.println("4 - Lister");
		Scanner sc = new Scanner (System.in);
		Etudiant etudiant;
		EtudiantService etudiantService=new EtudiantService();
		
		switch (sc.nextInt()) {
		case 1:
			System.out.println("Entrer le numero");
			int numero = sc.nextInt();
			System.out.println("Entrer le nom");
			String nom = sc.next();
			System.out.println("Entrer le prenom");
			String prenom = sc.next();
			System.out.println("Entrer l'email");
			String email = sc.next();
			etudiant=new Etudiant(numero, nom, prenom, email);
			etudiantService.addEtudiant(etudiant);
			break ;
		case 2:
			System.out.println("Entrer le numero");
			int num = sc.nextInt();
			System.out.println("Entrer l'email");
			String newEmail = sc.nextLine();
			etudiantService.updateEtudiant(num,newEmail);
			break ;
		case 3:
			System.out.println("Entrer le numero");
			int nume = sc.nextInt();
			etudiantService.deleteEtudiant(nume);
			break ;
		case 4:
			System.out.println("Liste des �tudiants");
			etudiantService.getAllEtudiant();
			break ;

		default:
			break;
		}

	}

}
