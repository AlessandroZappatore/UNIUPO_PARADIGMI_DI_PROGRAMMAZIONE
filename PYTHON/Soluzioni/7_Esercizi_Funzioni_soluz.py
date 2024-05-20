
#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Jan 11 18:24:12 2020

@author: Paola
"""
#%% 
# Scrivi una funzione comp che ha come parametri due funzioni, f e g,  e 
# ritorna una funzione che e' la composizione delle due funzioni. Per esempio, 
# se chiamo comp(f,g) dove f e' una funzione che ritorna il quadrato del suo 
# argomento, e g e' una funzione che ritorna il doppio del suo argomento, 
# allora comp(f,g) ritorna una funzione che ritorna il quadrato del doppio 
# del suo argomento.

def fCompg(f,g):
    return lambda x: f(g(x))

def doppio (x):
    return 2*x

def quadrato (x):
    return x*x

fun= fCompg(doppio,quadrato) 

fun(3)

#%% 
# Considera la seguente definizione della funzione foldLeft 

def foldLeft(lis,init,fn):
    res = init
    for x in lis:
        res = fn(res,x)
    return res

# foldLeft ha 3 parametri: una lista, lis, un valore iniziale di un 
# accumulatore, acc, e una funzione, fn che ha due parametri
#        un valore accumulatore e 
#        un elemento della lista
#        e ritorna un nuovo valore dell'accumulatore.
# L'idea e' che foldLeft applica la funzione fn agli elementi di lis, accumulando
# il risultato e ritornado il valore finale dell'accumulatore. Esempio:
#         foldLeft(lis,0,add) dove lis a add sono  
#

lis = [1,3,4,6,2]

def add (acc,x):
    return  acc+x
#
# cosa ritorna? 
# La somma di tutti gli elementi della lista
    
# Definite una funzione fn e un valore iniziale di accumulaotre init tale
# che  
#        foldLeft(lis,init,fn) => [2, 6, 4, 3, 1] 

# cioe' il risultato e' il reverse della lista di input  
    
def rev(acc,x):
    return [x]+acc

foldLeft(lis,[],rev)

#%%
# Scrivi una funziona che accetta come argomenti una sequenza di funzioni
# e un valore, applica ogni funzione a quel valore, e ritorna la funzione che
# ha ritornato il valore massimo. (Se c'e' un pareggio, ritorna la prima
# funzione che ritorna quel valore)


def max_f(x,funz):
    (f,v)= max([(f,f(x)) for f in funz],key=lambda x: x[1])
    return f
            
tuplaFunz=(lambda x: x + 3 ,lambda x: x * 2,lambda x: x % 2)  


print("res1:",max_f(4,tuplaFunz)(8))

print("res1:",max_f(1,tuplaFunz)(8))


    
#%% 
# Scrivi una funzione che accetta un iteratore e due funzioni booleane. 
# Ritorna un iteratore di tutti gli elementi dell'iteratore di input per
# cui entrambe le funzioni booleane ritornano un valore truthy

def itera(it,f1,f2):
    return (x for x in it if (f1(x) and f2(x)))
    
gen1 = itera(range(1, 11), lambda x: x-3, lambda x: x*3)
gen2 = itera(range(1, 11), lambda x: x**2, lambda x: x**3)
print(list(gen1))
print(list(gen2))

#%% 
# Scrivi una funzione che accetta due sequenze della stessa lunghezza.
# La prima sequenza rappresenta input, la seconda output. Crea e ritorna
# una funzione che dato un valore della sequenza di input, ritorna il
# corrispondente output. Se il valore di input non c'e', ritorna None
# Per esempio:
#  foo = makeFn([1,2,3,4,6],(7,6,5,4,3))
#  print(list(map(foo,range(10))))     
# Stamperebbe:
# [None, 7, 6, 5, 4, None, 3, None, None, None]

def genFunz(lIn,lOut):
    return lambda x: lOut[lIn.index(x)] if(x in lIn) else None
        
foo = genFunz([1,2,3,4,6],(7,6,5,4,3))
print(list(map(foo,range(10)))) 
