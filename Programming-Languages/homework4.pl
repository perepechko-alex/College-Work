%facts
parent(pete,mike).
parent(pete,julie).
parent(pete,amanda).

parent(mary,mike).
parent(mary,julie).
parent(mary,amanda).

female(mary).
female(amanda).
female(julie).
male(mike).
male(pete).

sibling(mike,julie).
sibling(mike,amanda).
sibling(amanda,mike).
sibling(julie,mike).
sibling(julie,amanda).
sibling(amanda,julie).

%rules
father(X,Y):-male(X),parent(X,Y).
mother(X,Y):-female(X),parent(X,Y).
sibling(A,B):-parent(C,A),parent(C,B),A\=B.
sister(A,B):-sibling(A,B),female(A).
brother(A,B):-sibling(A,B),male(A).
son(S,P):-male(S),parent(P,S).
daughter(D,P):-female(S),parent(P,D).
aunt(X,Y):-sister(X,Z),parent(Z,Y).
uncle(X,Y):-brother(X,Z),parent(Z,Y).
grandParent(A,B):-parent(A,C),parent(C,B).
