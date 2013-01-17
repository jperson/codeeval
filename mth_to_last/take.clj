(ns take
 (:gen-class))

(defn mthLast [l mth]
 (if (>= (count l) mth)
    (println (nth l (- (count l) mth)))))

(defn process [line]
 (if (< 0 (.length line))
    (let [l (seq (.split line " "))]
        (if (< 0 (count l))
            (mthLast (butlast l) (Integer/parseInt (last l)))))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
