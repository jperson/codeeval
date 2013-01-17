(ns email
 (:gen-class))

(defn email? [s]
 (re-seq #"\w[\w|\d+]+@\w[\w|\d+]+.\w" s))

(defn process [line]
 (if (not= "" line)
  (println (if (email? line) "true" "false"))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
