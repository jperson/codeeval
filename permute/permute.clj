(ns permute
 (:gen-class)
 (:use clojure.pprint))

(defn permute [ls]
 (if (= 1 (count ls))
  (list ls)
  (for [x ls, ps (permute (remove #(= x %) ls))] (cons x ps))))

(defn process [line]
 (if (not= "" line)
  (cl-format true "~{~a~^,~}~%" (sort (map #(apply str %) (permute line))))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)        
