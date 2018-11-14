package karl_rushford_tp1;
import java.io.*;
import java.util.*;

/************************
cours: IFT1176
TP1  
Karl Rushford



**************************/

public class Tp1{

	public static void main(String[] args) throws IOException {

		Signatures BdDonnees = new Bdd();

		BdDonnees.lireBddAut("Auteurs.txt");
                //si on utilise le dossier fichierTXT
                //BdDonnees.lireBddAut("fichierTXT/Auteurs.txt");
                //System.out.println("avant add livre bd");
		BdDonnees.lireBddLivre("Livres.txt");
                //BdDonnees.lireBddLivre("fichierTXT/Livres.txt");
                
		Auteur unAuteur = new Auteur("KING, STEPHEN", 1,"USA");
		BdDonnees.addAuteur(unAuteur); //code existe d�j�, doit �tre ignor�
                

		unAuteur = new Auteur("KING, STEPHEN", 321,"USA");
		BdDonnees.addAuteur(unAuteur);

		Livre unLivre = new Livre("Carrie", 222, 0,"Roman",645, 7.99);
		BdDonnees.addLivre(unLivre); //auteur inexistant, � ignorer

        unLivre = new Livre("Carrie", 222, 321,"Roman",645, 7.99);
		BdDonnees.addLivre(unLivre);

        unLivre = new Livre("LISTE MORTELLE", 232, 154,"Roman",439, 17.99);
		BdDonnees.addLivre(unLivre);


		//Pour afficher les livres d'un auteur par son nom
		unAuteur = BdDonnees.getAuteur("VERNE, JULES");
                System.out.println("le nom de unAuteur est "+unAuteur.getNom());
		Collection oeuvres = BdDonnees.getColLivresAut(unAuteur);
               // System.out.println("la baleur de oeuvre "+ oeuvres);
		if(oeuvres != null)  /* pr�voyez la m�thode getNom dans Auteur */
		   System.out.println("Les oeuvres de " + unAuteur.getNom() + "\n"+ oeuvres);

		//Pour afficher les livres d'un auteur par son code
		unAuteur = BdDonnees.getAuteur(39);
                System.out.println("le code de unAuteur est "+unAuteur.getCode());
		oeuvres = BdDonnees.getColLivresAut(unAuteur);
		if(oeuvres != null)
		   System.out.println("Les oeuvres de " + unAuteur.getNom() + "\n"+ oeuvres);

        //afficher un livre selon son titre et afficher aussi le nom l'auteur (pas si �vident)
		unLivre = BdDonnees.getLivre("ROBINSON CRUSOE");
		if(unLivre != null)
		{  int codeNum = unLivre.getCodeAuteur();  //pr�voyez cette m�thode dans Livre
		   System.out.println(unLivre + " de " + BdDonnees.getAuteur(codeNum).getNom());
		}

		//Cr�er les fichiers de rapports
		BdDonnees.rapportParAuteurs();
		BdDonnees.rapportParLivres();

		System.out.println(BdDonnees);  //Pr�voyez un toString dans Bdd pour faire afficher
										//en ordre de saisie des auteurs


	}

}

