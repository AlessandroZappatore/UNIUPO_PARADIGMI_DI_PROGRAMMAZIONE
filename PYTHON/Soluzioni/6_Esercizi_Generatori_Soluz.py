

#%% Esercizio 1
# Definisci un generatore mioRange(start,end,step) 
# che ha 3 parametri e che produce i numeri che 
# produrrebbe una chiamata di range
# list(mioRange(3,7,1)) => [3,4,5,6]
# list(mioRange(7,3,1)) => []
# list(mioRange(3,7,2)) => [3,5]
# list(mioRange(3,7,-2)) => []
# list(mioRange(3,7,-1)) => []
# list(mioRange(7,3,-1)) => [7, 6, 5, 4]
# list(mioRange(3,7,-2)) => []
# list(mioRange(7,3,-2)) => [7,5]

def mioRange(start,end,step):
    if step>0:
        while start<end:
            yield start
            start +=step
    else:        
        while start>end:
            yield start
            start +=step

assert(list(mioRange(3,7,1))==list(range(3,7,1)))
assert(list(mioRange(7,3,1))==list(range(7,3,1)))
assert(list(mioRange(3,7,2))==list(range(3,7,2)))
assert(list(mioRange(3,7,-2))==list(range(3,7,-2)))
assert(list(mioRange(3,7,-1))==list(range(3,7,-1)))
assert(list(mioRange(7,3,-1))==list(range(7,3,-1)))
assert(list(mioRange(3,7,-2))==list(range(3,7,-2)))
    

# I due cicli while differiscono per il controllo che si fa
# possiamo definire una funzione check di due variabili che se step e' >0
# facc            



        
# Possiamo anche fissare il default per lo step  a 1 e il generatore puo'
# essere chiamato con 2 argomenti.       
    
def mioRange2(start,end,step=1):
    check=(lambda inizio,fine:inizio<fine) if step>0 else (lambda inizio,fine:inizio>fine)
    while check(start,end):
        yield start
        start +=step

assert(list(mioRange2(3,7))==list(range(3,7)))
assert(list(mioRange2(3,7))==list(range(3,7)))

#%% Esercizio 2
# Definisci un generatore genFib(n) che produce i primi n numeri Fibonacci
#list(genFib(7))  # => [1, 1, 2, 3, 5, 8, 13]
# for x in genFib(7):
#    print(x)
# stampa 1 1 2 3 5 8 13
        
def genFib(n):
    prec,cor=0,1
    i=1
    while (i<=n):
        yield(cor)       
        prec,cor=cor,prec+cor
        i =i+1

#%% Esercizio 3
# Definisci un generatore genFibInf() che produce una enuerazione di tutti i numeri 
# Fibonacci
# Per testare il generatore non potete usare come nel caso precedente
# list(genFibInf())       
# for x in genFibInf():
#    print(x)
# ma potete usare la funzione next
# fib=genFibInf()
# for x in range(1,10):
#     print(next(fib))        
        

def genFibInf():
    prec,cor=0,1
    i = 0
    while (True):
        yield(i,cor)
        prec,cor=cor,prec+cor
        i =i+1

# Il generatore produce la coppia (i,fib(i))
        
#%% Esercizio 4
# Definisci un generatore genFibN(n) che produce una generalizzazione dei 
# numeri di Fibonacci:
#   Ogni numero della serie e' uguale alla somma degli N numeri precedenti        
#   I primi N numeri sono 0,0,...,0,1  
#   Questo sara' un generatore per una sequenza infinita!  
#
#   Per esempio, genFibN(3) produce 1, 1, 2, 4, 7, 13, 24, 44, 81, 149...
#                genFibN(4) produce 1, 1, 2, 4, 8, 15, 29, 56, 108, 208, ...
#                genFibN(2) produce i normali numeri Fibonacci		
#
#   Di nuovo se provate a scrivere le seguenti espressioni
#     list(genFibN(4)) oppure
#     [x for x in genFibN(3) if x < 100]		
#   producete un loop infinito. Come in precedenza potete usare next, 
#     g5 = genFibN(5)
#     next(g5)
#     next(g5)
#     next(g5)  
#
#   Ogni chiamata produce l'elemento successivo.oppure con (il generatore) zip 
#   produrre una lista di coppie (ad esempio 10):
#
#     list(zip(range(10),genFibN(3)))	 
#   
#   il secondo elemento sara' il numero di Fibonacci. Questo funziona perche' 
#   zip si ferma quando la lista piu' corta (fra) dei suoi argomenti finisce.
#

def genFibN(n):
    history = (0,)*(n-1) + (1,)
    while True:
        yield history[n-1]
        history = history[1:] + (sum(history),)
        
        
        