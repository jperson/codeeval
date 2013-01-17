(ns dollars
 (:gen-class)
 (:use clojure.pprint))

(def amts {0 "" 1 "One" 2 "Two" 3 "Three" 4 "Four" 5 "Five" 6 "Six" 7 "Seven" 8 "Eight" 9 "Nine"
           10 "Ten" 11 "Evelen" 12 "Twelve" 13 "Thirteen" 14 "Forteen" 15 "Fifteen" 16 "Sixteen" 17 "Seventeen" 18 "Eightteen" 19 "Nineteen" 
           20 "Twenty" 30 "Thirty" 40 "Forty" 50 "Fifty" 60 "Sixty" 70 "Seventy" 80 "Eighty" 90 "Ninety"
           100 "Hundred" 1000 "Thousand" 1000000 "Million"})

(defn foo [n acc]
 (cond
  (>= n 1000000) (foo (/ n 1000000) (apply str (concat acc (get amts (/ n 1000000)) "Million")))
  (>= n 100000) (foo (/ n 1000) (apply str (concat acc (get amts (/ n 1000)) "Thousand"))
