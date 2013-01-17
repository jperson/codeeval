(ns sameend
 (:gen-class))

(defn sameend [s1 s2]
 (= (apply str (drop (- (count s1) (count s2)) s1)) s2))

(defn process [line]
 (if (not= "" line)
  (let [v (.split line ",")]
   (if (> (count v) 0)
    (println (if (sameend (nth v 0) (nth v 1)) 1 0))))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
