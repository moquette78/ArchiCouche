package service;

import java.util.ArrayList;
import java.util.List;

import dao.EtudiantDao;
import metier.Etudiant;

public class EtudiantService {

	//EtudiantDao etudiantDao = new EtudiantDao();
	private EtudiantDao etudiantDao;
	
	/**
	 * construction
	 */
	public EtudiantService() {
		etudiantDao = new EtudiantDao();
	}

	/**
	 * ajout etudiant
	 * @param etudiant
	 */
	public void addEtudiant(Etudiant etudiant) {
		
		etudiantDao.insererEtudiant(etudiant);
		
	}
	
	public Etudiant getById(int id) {
		return etudiantDao.getEtudiantById(id);
	}
	
	/**
	 * update etudiant
	 * @param id
	 * @param email
	 */
	public void updateEtudiant(int id ,String email) {
			
			etudiantDao.modifierEtudiant(id,email);
			
		}
	
	/**
	 * delete etudiant
	 * @param id
	 */

	public void deleteEtudiant(int id ) {
		
		etudiantDao.supprimerEtudiant(id);
		
	}
	
	/**
	 * lister all etudiant
	 */
	public List<Etudiant> getAllEtudiant() {
		return etudiantDao.listerEtudiants();
	
	}
	
	
}
