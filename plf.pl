room(X,Y) :- X is (Y+1).
room(X,Y) :- X is (Y-1).


adj([room(_,5),room(_,4),room(_,3),room(_,2),room(_,1)]).

layout(X) :- adj(X),
	member(room(hunter,A), X), 
	A \= 5,
	member(room(laura,B), X),   
	B \= 1,
	member(room(addiley,C), X),
	member(room(ramey,D), X),   
	D > B,
	member(room(arnie,E), X),   
	E \= 1, 
	E \= 5, 
	\+(room(E,B)), 
	\+ (room(E,C)).