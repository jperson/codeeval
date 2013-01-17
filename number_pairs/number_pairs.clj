(ns number_pairs 
 (:gen-class)
 (:use clojure.pprint))

(defn sublists [ls]
 (map #(drop % ls) (range 0 (count ls))))

(defn number_pairs [ls v]
 (map flatten (map #(let [x (first %1)] (for [y (rest %1) :when (= (+ x y) v)] [x y])) (sublists ls))))

(defn output [ls]
 (if (empty? ls) (println "NULL") (cl-format true "~{~{~a~^,~}~^;~}~%" ls)))

(defn process [line]
 (if (not= "" line)
  (let [v (.split line ";")]
   (if (> (count v) 0)
    (let [ns (.split (nth v 0) ",")]
     (output (filter (fn [l] (not (empty? l))) (number_pairs (map #(Integer/parseInt %) ns) (Integer/parseInt (nth v 1))))))))))
    
(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
