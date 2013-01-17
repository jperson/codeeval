(ns register
 (:gen-class)
 (:use clojure.pprint))

(def values {1 "PENNY" 5 "NICKEL" 10 "DIME" 25 "QUARTER" 50 "HALF DOLLAR" 100 "ONE" 200 "TWO" 500 "FIVE" 1000 "TEN" 2000 "TWENTY" 5000 "FIFTY" 10000 "ONE HUNDRED"})
    
(defn change [pp ch acc]
 (if (= pp ch) acc
  (let [c (- ch pp) amt (last (sort (filter #(>= c %) (map first values))))]
   (recur pp (- ch amt) (conj acc (get values amt))))))

(defn make-change [pp ch]
 (if (< ch pp) (println "ERROR") (cl-format true "~{~#[ZERO~:;~@{~A~^,~}~]~:}~%" (sort (change (int (* 100 pp)) (int (* 100 ch)) nil)))))

(defn process [line]
 (if (not= "" line)
  (let [[pp ch] (map #(Float/parseFloat %) (.split line ";"))]
   (make-change pp ch))))

(defn -main [args]
 (let [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
