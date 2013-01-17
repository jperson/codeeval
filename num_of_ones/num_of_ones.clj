(ns num-of-ones
 (:gen-class)
 (:use clojure.pprint))

(defn process [line]
 (if (not= "" line)
    (println (count (filter #(= \1 %) (seq (cl-format nil "~B" (Integer/parseInt line))))))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
