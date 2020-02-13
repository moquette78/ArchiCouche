package service;

import java.util.ArrayList;
import java.util.List;

import dao.EtudiantDao;
import metier.Etudiant;

public class EtudiantService {

	EtudiantDao etudiantDao;
	
	public void addEtudiant(Etudiant etudiant) {
		
		etudiantDao.insererEtudiant(etudiant);
		
	}
	
	public void updateEtudiant(int id ,String email) {
			
			etudiantDao.modifierEtudiant(id,email);
			
		}

	public void deleteEtudiant(int id ) {
		
		etudiantDao.supprimerEtudiant(id);
		
	}
	public void getAllEtudiant() {
		List<Etudiant> listEtudiant = etudiantDao.listerEtudiants();
		for (Etudiant etudiant2 : listEtudiant) {
			System.out.println(etudiant2.getNom() + " " + etudiant2.getPrenom()+ " " + etudiant2.getEmail());
			
		}
		
		
	}
	
	
}
