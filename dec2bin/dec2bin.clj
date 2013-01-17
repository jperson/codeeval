(ns dec2bin
 (:gen-class)
 (:use clojure.pprint))

(defn process [line]
 (if (not= "" line)
    (cl-format true "~B~%" (Integer/parseInt line))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
