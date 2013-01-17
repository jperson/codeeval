(ns reverse-add
 (:gen-class)
 (:use clojure.pprint))

(defn palindrome? [n]
 (= n (Integer/parseInt (apply str (reverse (str n))))))


(defn reverse+ [n]
 (+ n (Integer/parseInt (apply str (reverse (str n))))))

(defn palindrome [n acc]
 (if (palindrome? n) [n acc] (recur (reverse+ n) (inc acc))))

(defn process [line]
 (if (not= "" line)
  (let [[p acc] (palindrome (Integer/parseInt line) 0)]
   (println acc p))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))
    
(apply -main *command-line-args*)
