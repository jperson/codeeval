(ns pangrams
 (:gen-class)
 (:use clojure.set))

(defn pangram [s]
 (let [s (apply str (difference (set (apply list "abcdefghijklmnopqrstuvwxzy")) (set (filter #(and (< 96 (int %)) (> 123 (int %))) (sort (.toLowerCase s))))))]
    (if (= s "") (println "NULL") (println s))))

(defn -main [args]
    (with-open [rdr (clojure.java.io/reader args)]
        (doseq [line (line-seq rdr)] (pangram line))))

(apply -main *command-line-args*)
