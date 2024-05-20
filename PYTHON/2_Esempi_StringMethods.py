# -*- coding: utf-8 -*-
"""
Created on Fri Oct  4 16:41:27 2019

@author: Paola
"""

#%%
s1 = "The quick brown fox"
s2 = "jumps over a lazy dog."
s3 = "Thishasan&init"
s4 = "This has 1 number"
s5 = "1234"
s6 = "1.2"
s7 = "Nospaceshere8"
s8 = "Nospacesornumbers"
s9 = "Una\tstring\tcon\t\ttab"
s10 = "  \t\n \t  "

#%%
# metodi per creare una stringa tutta maiuscola o tutta minuscola
s1.upper()
s1.lower()

# metodi booleani
s1.isalnum()        # True se solo caratteri alfanumerici
s3.isalnum()
s7.isalnum()
s8.isalnum()

s1.isalpha()        # True se solo caratteri alfabetici
s7.isalpha()
s8.isalpha()


s5.isdigit()
s6.isdigit()

s1.center(30)       # Ritorna una stringa centrata nella lunghezza desiderato.
s1.center(30,'.')   # Si puo' specificare il carattere di riempimento
s1.ljust(30,'.')    # left justify: allineato a sinistra
s1.rjust(30,'.')    # right justify: allineato a destra

s1.startswith('The')    # True se la stringa inizia con l'argomento
s1.endswith('fox')      # True se la stringa finisce con l'argomento
s2.endswith('dog')

s9.expandtabs()     # Converte tab in spazi
s9.expandtabs(4)    # Default tab size e' 8, ma puoi specificare

# find e' come index, ma ritorna -1 se non c'e' invece di un errore
s1.index('brown')
s1.find('brown')
s1.index('blue')
s1.find('blue')

#%%

# rfind e rindex iniziano dalla fine
'a..b..c..d..e'.find('..')
'a..b..c..d..e'.rfind('..')

s1.isspace()        # Ritorna True se tutti i caratteri sono whitespace
s10.isspace()
''.isspace()        # La stringa vuota non e' considerata whitespace

# split divida una stringa. Ritorna una lista
'a 4,b,c,d,e'.split(",")
# il separatore di default e' qualsiali whitespace (tab, space)
'a b c       d e'.split()

# join concatena gli elementi separati dalla stringa
'.'.join("abc")
# funziona anche con qualsiasi sequenza
'.'.join(['a','b','c'])
# se voglio solo metterli insieme, posso usare la stringa vuota
''.join(['a','b','c'])

# strip toglie caratteri davanti e dietro. L'argomento e interpretato
# come un insieme di caratteri
"!!!@@@string@@@!".strip('!@')
"!!!@@@string@@@!".lstrip('!@')     # lstrip toglie solo quelli davanti
"!!!@@@string@@@!".rstrip('!@')     # rstrip toglie solo quelli dietro

# replace sostituisce tutte le occorenza di un string con un'altra
"Sneed's feed and seed.".replace('eed','og')
"Sneed's feed and seed.".replace('eed','')

s = "Sneed's feed and seed."
s.replace('eed','og')              # s NON e' modifcata
s


#%%
