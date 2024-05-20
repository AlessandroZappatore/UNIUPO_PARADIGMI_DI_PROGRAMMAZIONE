# -*- coding: utf-8 -*-


    
#%%   
# Scrivi una funzione che trova una lista di parole in una matrice di lettere
# La matrice di lettere viene letta dal file di testo "WordSquare.txt"x.    
# La parola puo' essere orizontale o verticale e puo' essere
# in un qualsiasi orientamento (sinistra=> destra, destra=>sinistra,
# alto=>basso, basso => alto)
#
# La funzione ritorna un dizionario con chiave le parole da cercare
# se la parola c'e', viene associata alla coppia di indici di inizio e
# fine della parola nella matrice, se non c'e' viene associata a -1.    

# Prima scrivere una funzione: leggiFile(direct,nomeFile)
# che prende in input il nome della directory e quello del file nelle 
# directory in cui si trovano le stringhe che rappresentano le righe
# della matrice di lettere e ritorna la lista di tali stringhe 
    
def leggiFile(baseDir, file):
    try:
        with open(baseDir + '/' + file,'r') as myFile:
            res = []
            for line in myFile:
                line = line.rstrip()
                if line:
                    res.append(line)
    except FileNotFoundError:
        print("File doesn't exist")       
    return res

baseDir= "/home/alessandrozappatore/Desktop/PARADIGMI/PYTHON"

leggiFile(baseDir,'WordSquare.txt')

# Poi scrivere una funzione cercaInRighe(parola,righe) che prende in input 
# una parola e una lista di stringhe (le righe della matrice di lettere) 
# e cerca la parola nelle stringhe sia da sinistra a destra che 
# da destra a sinistra e ritorna gli indici di inizio e fine della parola
# e -1 se non la trova
# cioe' il risultato se diverso da -1 e'  ((i,j1),(i,j2))
# l'indice j1, quando si cerca da sinistra a destra, e' quello ritornato da
# find (se diversa da -1) e j2 si calcola sommando la lunghezza della parola
# meno uno.
# per cercare la parola da destra a sinistra si puo' cercare l'inverso della
# parola e poi l'indice di inizio diventa quello di fine e si calcola come
# per il caso della ricerca da sinistra a destra dove la parola inizia.

def cercaInRighe(word,rows):
    for i,r in enumerate(rows):
        c=r.find(word)
        if (c!=-1):
           return ((i,c),(i,len(word)+c-1))
        c=r.find(word[::-1])
        if (c!=-1):
            return((i,len(word)+c-1),(i,c))
    return -1

# Usare la funzione precedente per definire una funzione
# cercaInColonne(parola,righe) per cercare nelle colonne della matrice
# di lettere come la precedente la parola puo' essere dall'alto in basso
# o dal basso in alto e come la precedente ritorna le coordinate di inizio
# e fine oppure -1.    
# se la ricerca per riga ritorna ((i,j1),(i,j2)) allora i e' l'indice
# della colonna e j1 e j2 l'indice della riga di inizio e fine della parola
# cioe' dobbiamo ritornare ((j1,i),(j2,i))

def cercaInColonne(word,rows):
    res=cercaInRighe(word,[''.join(x) for x in zip(*rows)])
    if res!=-1:
        return ((res[0][1],res[0][0]),(res[1][1],res[0][0]))
    return -1
 
# Usare le 2 funzioni precedenti per definire la funzione 
# cercaParole (parole, righe) => dizionario con chiavi le stringhe in parole
# e valore -1 o gli indici di inizio e fine della parole    
    
    

def cercaParole(parole,righe):
    res ={}
    for parola in parole:
        cR = cercaInRighe(parola,righe)
        cC = cercaInColonne(parola,righe)
        if cR!=-1:
            res[parola]=cR
        elif cC!=-1:
            res[parola]=cC 
        else:
            res[parola]=-1
    return res      
      
      
parole =['angelico','ariosto','baviera', 'camilleri','cassino','corsica',
           'fenoglio','maglia','notaio','olandesi','pacifico',
          'palomar','parise','roncalli','sciascia','serao']


righe = leggiFile(baseDir,'WordSquare.txt')
      
    
{'angelico': ((2, 0), (2, 7)),
 'ariosto': ((4, 2), (10, 2)),
 'baviera': ((10, 1), (4, 1)),
 'camilleri': ((10, 5), (2, 5)),
 'cassino': ((10, 0), (4, 0)),
 'corsica': ((4, 3), (10, 3)),
 'fenoglio': ((5, 10), (5, 3)),
 'maglia': ((8, 5), (8, 10)),
 'notaio': ((5, 0), (0, 0)),
 'olandesi': ((0, 0), (0, 7)),
 'pacifico': ((9, 10), (2, 10)),
 'palomar': ((9, 10), (9, 4)),
 'parise': ((0, 10), (0, 5)),
 'roncalli': ((3, 8), (10, 8)),
 'sciascia': ((10, 10), (10, 3)),
 'serao': ((1, 2), (1, 6))}



  
      
      