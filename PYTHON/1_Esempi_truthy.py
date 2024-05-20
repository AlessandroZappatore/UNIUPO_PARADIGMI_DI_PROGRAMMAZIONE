# -*- coding: utf-8 -*-
"""
Created on Sun Jun 14 18:49:18 2020

@author: Paola
"""

#%% 0. indentation, tf

def ifs(a,b,c):
    if a:
        if b:
            print('happy')
        else:
            print('doc')
    elif c:
        print('sneezy')
    else:
        print('grumpy')    

ifs(True,True,True)
ifs(True,False,True)
ifs(False,False,True)
ifs(False,True,False)
ifs(7,[],())          
ifs((),'x','y')
ifs((),0,0)

def ifs2(a,b,c):
    if a:
        if b:
            print('happy')
        else:
            print('doc')
    if c:
        print('sneezy')
    else:
        print('grumpy')    
        
ifs2(1,2,3) 
ifs2('a',0,'')  #  ifs2('a',0,'')
ifs2([],None,-1)
ifs2(-1,{},[0])  

#%%








#%%
