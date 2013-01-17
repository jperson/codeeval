(ns jolly
 (:gen-class))

(defn is-jolly? [n ls]
 (let [js (range 1 n)]
  (= js (sort ls))))

(defn jolly [f ls acc]
 (if (empty? ls) acc (recur (first ls) (rest ls) (conj acc (Math/abs (- f (first ls)))))))
 
(defn process [line]
 (if (not= "" line)
  (let [[n f & ls] (map #(Integer/parseInt %) (.split line " "))]
   (println (if (is-jolly? n (jolly f ls nil)) "Jolly" "Not jolly")))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))
   
(apply -main *command-line-args*)
