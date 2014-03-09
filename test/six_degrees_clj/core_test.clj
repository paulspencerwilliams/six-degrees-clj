(ns six-degrees-clj.core-test
  (:use expectations
        [six-degrees-clj.core :refer :all]))

;; can retrieve values for Keanu Reeves
(expect "Keanu Reeves > Street Kings > Forest Whitaker > The Air I Breathe > Kevin Bacon" 
        (find-shortest-path "Keanu Reeves"))

;; can retreive values for another arbitory actor
(expect "Tom Cruise > A Few Good Men > Kevin Bacon" 
        (find-shortest-path "Tom Cruise"))

;; prints output to standard out
(expect 
  (interaction 
    (println "Keanu Reeves > Street Kings > Forest Whitaker > The Air I Breathe > Kevin Bacon"))
  (-main "Keanu Reeves"))



