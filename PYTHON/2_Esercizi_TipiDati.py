#%%
# Scrivi una funzione che accetta una lista di numeri
# e ritorna true se e solo se (sse) tutti i numeri sono distinti 
# Esempi: distinti([1,2,3,4]) -> True
#         distinti([1,2,3,2]) -> False
def distinti(lista):
    return len(lista)==len(set(lista))
#%%
# Scrivi una funzione che ritorna il numero cifre di un intero
# Esempi: cifre(0) -> 1
#         cifre(1003) => 4
def cifre(num):
    return len(str(num))
#%% 
# Scrivi una funziona che accetta un int e ritorna il numero
# di zeri consecutivi con cui finisce.
# Esempi: lessZero(123) -> 0
#         lessZero(1200086000) -> 3
#         lessZero(-100) -> 2
#         lessZero(0) = 1
def lessZero(num):
    return len(str(num))-len(str(num).rstrip('0'))
#%%
# Scrivi una funziona che conta la frequenza di tutte la parole in una stringa
# input: stringa con parole separati da spazi 
# output: dizionario con coppie (parola, numero di occorenza)  
# Se str="mele  rab  dfgghh mele arance   ddfsfs arance"
# freq(str) => {'mele': 2, 'rab': 1, 'dfgghh': 1, 'arance': 2, 'ddfsfs': 1}
def freq(stringa):
    dict={}
    for parola in stringa.split():
        dict[parola]=stringa.count(parola)
    return dict

#%%
# Crea una funzione che ha due parametri, assumi che siano stringhe.
# Ritorna una tupla con due stringhe che sono le due stringhe di input
# con il loro primo carattere swappato (l'uno con l'altro).
# Se uno dei due parametri e' una stringa vuota ritorna None
# Esempio: fn1('foo','bar') ritorna ('boo','far')
def fn1(stringa1, stringa2):
    if not stringa1 or not stringa2: return None
    return (stringa2[0]+stringa1[1:], stringa1[0]+stringa2[1:])

#%%
# Data una stringa di lunghezza divisibile per 3, ritorna una tupla con 
# il primo terzo, il terzo di mezzo, e l'ultimo terzo della stringa.
# Se la lunghezza non e' divisibile per 3, oppure e' 0, ritorna None
# Esempio: fn('abcdef') => ('ab','cd','ef')
#    st = st + 'x' * ((3-len(st)) % 3)
def fn(stringa):
    if len(stringa)%3!=0: return None
    dim=len(stringa)//3
    return (stringa[:dim], stringa[dim:dim*2], stringa[dim*2:])

#%%   
# Scrivere una funzione che prende un parametro intero e una stringa produce
# lo shift della stringa a destra con ingresso di caratteri bianchi e perdita
# dei caratteri che eccedono la lunghezza
# Esempi:  spostaDx(6,'questaeraunastringa') ->  '      questaeraunas' 
#          spostaDx(2,'domani') ->  '  doma'
def spostaDx(num, stringa):
    return ' '*num+stringa[:-num]

#%%   
# Scrivere una funzione che prende un parametro intero e una stringa produce
# lo shift della stringa a sinistra con ingresso di caratteri bianchi e perdita
# dei caratteri che eccedono la lunghezza
# Esempi:  spostaSx(6,'questaeraunastringa') ->  'eraunastringa      ' 
#          spostaSx(2,'domani') ->  'mani  '
def spostaSx(num, stringa):
    return stringa[num:]+' '*num





