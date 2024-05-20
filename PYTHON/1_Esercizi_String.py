    # -*- coding: utf-8 -*-
"""

@author: Paola
"""
#%%
a = "Winter"
b = "is coming"

#%%
# crea un variabile c con valore "Winter is coming" utilizzando string 
c=a+b
c
# crea un variabile d con valore "WinterWinterWinter"
d=a*3
d
# stampa la lunghezza di c
len(c)
# controlla se c contiene il carattere 'a'
"a" in c
# controlla se c contiene il carattere 'g'
'g' in c
# controlla se c contiene il carattere 'w'
'w' in c
# stampa il terzo e il terzultimo carattere di c
c[2]
c[-3]
# provate cosa ritorna min(c) e max(c)
max(c)
# stampa quanti 'i' ci sono in c
c.count('i')
# stampa l'indice del primo 'i' in c
c.index('i')
# stampa quanti 'in' ci sono in c
c.count('in')

#%%
# Crea una funziona che prende una stringa come parametro, e ritorna 
# la stringa in cui i caratteri di indice dispari sono rimossi. 
# Se la stringa e' vuota ritorna None
# Attenzione le stringhe sono immutabili
# Esempio: fn2('abcdefg') = 'aceg'
def fn2(stringa):
    return stringa[::2]
    
#%% 
# Crea una funziona come quella sopra, ma rimuove i caratteri con indice
# pari e ritorna il resto in ordine inverso. Se la lista non ha almeno 
# 2 caratteri ritorna None    
# Esempio: fn3('abcdefg') = 'fdb'    
def fn3(stringa):
    return stringa[1::2][::-1]

#%%
# Da fare dopo aver introdotto le liste
# Applica le due funzioni precedenti alla stringa 'teovruoj'
str1=fn2('teovruoj')
str2=fn3('teovruoj')

# Ora crea una funzione per fare l'inverso; cioe' per mescolare due 
# stringhe della stessa lunghezza, la prima nell'ordine originale
# e la seconda al rovescio. Se gli input non sono idonei, ritorna None
# Esempio: fn4(str1,str2) = 'teovruoj'
def fn4(stringa1, stringa2):
    if len(stringa1)!=len(stringa2): return None
    res=[None]*(len(stringa1)+len(stringa2))
    res[::2]=stringa1
    res[1::2]=stringa2[::-1]
    return ''.join(res)
    

    