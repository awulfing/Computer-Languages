(defun palindromep(1st)
	
	(setq x(nth 0 1st))
	(setq y(nth 0(reverse 1st)))

	(if(eq x nil)
		(return-from palindromep t)
	)
	(if(equal x y)
		(progn
			(setq r(delete x 1st	:count 1))
			(setq r(delete y r	:count 1 :from-end t))
			(palindromep r)
		)
		(return-from palindromep nil)
	)
)

(print(palindromep '(a b b a)))

(print(palindromep '(a b b c b a)))

(print(palindromep '(a b c)))

(print(palindromep '(a (d e) b (d e) a)))

(print(palindromep '(a (d e) b (e d) a)))
(print "risetovotesir")
(print(palindromep '(r i s e t o v o t e s i r)))
