#%% Eserczio 1
# Scrivi una funzione che prende una stringa e ritorna True 
# se e' un palindrome. Ignorate i caratteri che non sono lettere
# del'alfabeto e il test deve essere case-insensitive.
# isPal('A man, a plan, a canal: Panama!') => True
# isPal('Ettore evitava le madame lavative e rotte.') => True
# isPal('Bolton') => false


def isPal(stringa):
    s = stringa.lower()
    for c in s:
        if not c.isalnum():
            s = s.replace(c, '')
    return (s == s[::-1])

def isPalL(stringa):
    s = stringa.lower()
    l =[]
    for c in s:
        if c.isalnum():
            l = l+[c]
    return (l == l[::-1])

#%% Eserczio 2
# 1) Scrivere una funzione righeColonne che prende in input una lista 
# di stringhe [r1,...,rn] tutte della stessa lunghezza m, e ritorna 
# la lista di stringhe [c1,...,cm] dove  ci=r1[i]r2[i]....rn[i]
# Se
   
righe=['olandesirap',
 'iiseraoimaa',
 'angelicosio',
 'tnvghrrcrtc',
 'oaacaeaeoai',
 'nrroilgonef',
 'ieirolagcei',
 'siosaiavaec',
 'svsirmaglia',
 'aatcramolap',
 'cboaicsaics'
]

# righeColonne(ls) deve ritornare
 

['oiatonissac',
 'linnareivab',
 'asgvariosto',
 'neegcorsica',
 'drlhaioarri',
 'eairellimac',
 'socragaaams',
 'iioceogvgoa',
 'rmsroncalli',
 'aaitaeeeiac',
 'paocificaps']       
 
 # SUGGERIMENTO: Come potete ottenere dalla lista inziale una sequenza
 # che raggruppi i caratteri che stanno in una specifica colonna??

def righeColonne(rows):
    cols=[]
    for x in zip(*rows):
        cols.append(''.join(x))
    return cols


#%% Eserczio 3
# Assumendo di avere una lista di triple (stringa, booleano, lista persone) in cui
# una tripla rappresenti una persona (nome, sesso, lista dei figli) con Donna associata 
# True e Uomo a False ad esempio:

paola =("Paola", True,[])
andrea =("Andrea", True,[paola])
giovanni =("Giovanni", False,[paola])
peter =("Peter", False,[])
giulia =("Giulia", True, [paola, peter, andrea])
persone = [paola, peter, giulia]
persone1 = [paola, peter, giulia,andrea]
persone2 = [paola, peter, giulia,giovanni]

# scrivere due funzioni che ritornano rispettivamente
# 1) la lista delle persone il cui nome inizia con un certo carattere (parametro)
# 2) la lista delle coppie (nome madre, nome figlia/o)  


def inizioLettera(ls,c):
    res=[]
    for x in ls:
        if x[0].startswith(c):
            res.append(x)
    return res

def listaCoppie(el,ls):
    res=[] 
    for x in ls:
        res.append((el,x[0]))
    return res
    
def listaMadreFigli(ls):
    res=[]
    for x in ls:
        if x[1] and x[2]:
            res.extend(listaCoppie(x[0],x[2]))
    return res
        
    






