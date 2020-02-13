package presentation;

import java.util.List;
import java.util.Scanner;

import metier.Etudiant;
import service.EtudiantService;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
			
		do {
			System.out.println("1 - Ajouter");
			System.out.println("2 - Modifier");
			System.out.println("3 - Supprimer");
			System.out.println("4 - Lister");
			System.out.println("5 - Quitter");
			System.out.println("Veuillez entrer votrer choix");
			 
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
					int num;
					do {
						System.out.println("Entrer le numero");
						num = sc.nextInt();
						etudiant = etudiantService.getById(num);
					} while (etudiant==null);
					
					System.out.println("Entrer l'email");
					String newEmail = sc.next();
					etudiantService.updateEtudiant(num,newEmail);
					break ;
				case 3:
					System.out.println("Entrer le numero");
					int nume = sc.nextInt();
					etudiantService.deleteEtudiant(nume);
					break ;
				case 4:
					System.out.println("Liste des étudiants");
					List<Etudiant> listEtudiant = etudiantService.getAllEtudiant();
					for (Etudiant etudiant2 : listEtudiant) {
						System.out.println(etudiant2.getNom() + " " + etudiant2.getPrenom()+ " " + etudiant2.getEmail());
						
					}
					break ;
				case 5:
					System.exit(0);
					
				default:
					break;
				}
			
		} while (sc.nextInt()!=1 ||sc.nextInt()!=2 || sc.nextInt()!=3 || sc.nextInt()!=4 || sc.nextInt()!=5 );
		
		

	}

}
