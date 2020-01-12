# Compila
MiniCompilateur
Mini Compilateur 


1.partie lexicale
En a charger et lire le fichier line par line après en a couper les ligne mot par mot par la méthode split() ;
Avant sa en a essayé d’écrire le programme LEX « .L »
 


A l’aide de ce principe on a écrit notre fonction « lexical() » en utilisant « switch » pour la reconnaissance de type de tous les mot existant .


L’exécution :
 

 



2.partie Syntaxique :

	Dans cette étape on a essayé d’écrire la grammaire du programme est on a obtenu :
  
A l’aide ce cette Grammaire et le Principe de Procédures récursives une List insts de class lexical () qui contient les tokens, on a créé notre class « syntax () » Commençant par le procédure principale « P » jusqu’à la dernière procédure.





L’exécution :
 





3.partie Sémantique :
Dans cette partie on a essayé d’utiliser deux List, une de la classe « syntax » s’appelle istruction qui contient les tokens qu’on veut les analysés {GIVE, AFFECT, IF, INT, FLOAT} et l’autre List de la class « lexical () » s’appelle valeur  
Ex :
Le code	Istruction	valeur
Give i : 23 ;;	GIVE	  i   IVAR

Est en test fi i est déjà déclarer ainsi de suite ...

