package lex;

import java.util.ArrayList;

public class semantique {
	syntax s=new syntax();
	
	
	boolean exist(String mot,ArrayList<String> tab,int x) {
		for(int i=0;i<x;i++) {
			if(mot==tab.get(i)) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	
	ArrayList<String>sm=new ArrayList<String>();
	
	
	public ArrayList<String> semantiques() {
		int l = 0;
		ArrayList<String>  entiers = new ArrayList<String>();
		ArrayList<String>  reels = new ArrayList<String>();
		int y = 0;
		int r =0;
		int e = 0;
		
		while(l<lex.valeur.size()||l<s.istruction.size()) {
			if(l<s.istruction.size()&&s.istruction.get(l).equals(" ")) {
				l++;
			}
			else if(l<s.istruction.size()&&s.istruction.get(l).equals("INT")) {
				
				String[] mot=lex.valeur.get(l).split(" ");
				
				while(y<mot.length ) {
					if(!exist(mot[y],reels,r)&&!exist(mot[y],entiers,e)) {
				entiers.add(mot[y]);
				y++; e++;
				}
					else if(exist(mot[y],reels,y)){
						System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[0]+" est declarer comme un reel deja )");
						sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[0]+" est declarer comme un reel deja )");

					}
					else if(exist(mot[y],entiers,e)){
						System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[0]+" est declarer comme un entier deja )");
						sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[0]+" est declarer comme un entier deja )");

					}
				
				}
				l++;y=0;
			}
			else if(l<s.istruction.size()&&s.istruction.get(l).equals("FLOAT")) {
				String[] mot=lex.valeur.get(l).split(" ");
				
				while(y<mot.length ) {
					if(!exist(mot[y],reels,r)&&!exist(mot[y],entiers,e)) {
						reels.add(mot[y]);
						y++; r++;
					}
					else if(exist(mot[y],reels,y)){
						System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[0]+" est declarer comme un reel deja )");
						sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[0]+" est declarer comme un reel deja )");

					}
					else if(exist(mot[y],entiers,e)){
						System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[0]+" est declarer comme un entier deja )");
						sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[0]+" est declarer comme un entier deja )");

					}
				}
				l++;y=0;
			}
			else if(l<s.istruction.size()&&s.istruction.get(l).equals("GIVE")) {
				
				String[] mot=lex.valeur.get(l).split(" ");
				if(mot[y].equals("IVAR")&&(exist(mot[y],reels,r)&&!exist(mot[y],entiers,e))||(!exist(mot[y],reels,r)&&exist(mot[y],entiers,e))) {
					l++;
				}
				
				else if(mot[y+1].equals("FVAR")&&exist(mot[y],reels,r)) {
					
					l++;
				}
				else if(mot[y+1].equals("FVAR")&&exist(mot[y],entiers,e)) {
					System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "(affectation de reel a l entier  "+ mot[y]+" )");
					sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "(affectation de reel a l entier  "+ mot[y]+" )");
					l++;
				}
				else {
					System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[y]+" n'est pas declarer)");
					sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "( "+ mot[y]+" n'est pas declarer)");
					l++;
				}
				
				
			}
					
			else if(l<s.istruction.size()&&s.istruction.get(l).equals("AFFECT")) {
				
				String[] mot=lex.valeur.get(l).split(" ");

				if(exist(mot[y],entiers,e)&&exist(mot[y+1],entiers,e)) {
					l++;
				}
				else if(exist(mot[y],entiers,e)&&exist(mot[y+1],reels,r)) {
					l++;
				}
				else if(exist(mot[y],reels,r)&&exist(mot[y+1],reels,r)) {
					l++;
				}
				else if(exist(mot[y],reels,r)&&exist(mot[y+1],entiers,e)){ 
					System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "( affectation d'un reel "+ mot[y]+" a un entier "+mot[y+1]+")");
					sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "( affectation d'un reel "+ mot[y]+" a un entier "+mot[y+1]+")");
					l++;
				}
				else {
					System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "( variable  non declarer)");
					sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "( variable  non declarer)");
					l++;
				}
			}
			else if(l<s.istruction.size()&&s.istruction.get(l).equals("IF")) {
				String[] mot=lex.valeur.get(l).split(" ");

				
				 if(exist(mot[y],reels,r) && exist(mot[y+1],entiers,e)){
					System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "( testé un reel "+ mot[y]+" avec un entier "+mot[y+1]+")");
					sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "( testé un reel "+ mot[y]+" avec un entier "+mot[y+1]+")");
					
				}
				else if((!exist(mot[y],reels,r) && !exist(mot[y+1],entiers,e))) {
					System.out.println("erreur semantique dans la ligne "+lex.valeur.size()+ "( variable  non declarer)");
					sm.add("erreur semantique dans la ligne "+lex.valeur.size()+ "( variable  non declarer)");
					
				}
				if(mot.length<2) {
				l++; y=2;;
				}
				
			}
			
			
		}
	



		
	return sm;	
	}
	
}
