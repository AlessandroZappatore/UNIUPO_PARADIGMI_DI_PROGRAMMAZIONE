#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb 18 11:22:58 2024

@author: alessandrozappatore
"""

def cond(a,b,c):
    if a:
        if b and c:
            print("a")
        elif b or c:
            print("b")
        else:
            print("c")
    else:
        if b:
            print("d")
        if c:
            print("e")
        else:
            print("f")
    if c:
        print("g")

# Cosa stampano queste espressioni:
         
cond({},[],())       
cond(0,tuple(),7)
cond([],[0],None)
cond({},(3,4),-1)
cond(-1,[],0)
cond(True, [],[0])
cond([[]],-5,{})
cond(({0}),max(0,1),max)

x = list(range(-5,5,2))

# quale e' il risultato della valutazione di queste espressioni?
x[0]
x[-1]
x[10]

x[2:]
x[2:4]
x[2:3]
x[2:2]

x[::-1]
x[-2:-4]
x[-2:-4:-1]
x[-2::-2]
x[0:-1]

def fn(x,y=5,z=2):
    print(x,y,z)
    
# Cosa stampano queste chiamate:

fn(1,2,3)    
fn(1,2,3,4)
fn(1,2)
fn(1)
fn()
fn(y=5, 1)
fn(y=1,x=2)
fn(1,y=4,x=3)
fn([4,5,6])
fn(*[4,5,6])
fn(*[4,8])
fn({'z':9,'x':7})
fn(**{'z':9,'x':7})
fn(**{'z':9,'x':7,'p':2})


[x*2 for x in range(3,7)]
'!'.join(['one','two','three'])
[2 for x in range(3,8)]
[x % 3 for x in range(1,9)]
[x[1]*x[0] for x in [(3,1),(4,3),(7,-1)]]
[max(y) for y in zip([1,2,3],[4,3,2],[3,8,-2])]
[d[0]+d[1] for d in enumerate([4,7,2,0,-1])]

list(zip([1,2,3],[4,3,2],[3,8,-2]))