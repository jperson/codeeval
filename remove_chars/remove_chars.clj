(ns remove_chars
 (:gen-class))

(defn elem [s c]
 (reduce #(and %1 (not= c %2)) true (seq s)))

(defn remove-chars [cs s]
 (apply str (filter #(elem cs %) (seq s))))

(defn process [line]
 (when (not= "" line)
  (let [v (.split line ", ")]
   (if (> (count v) 0)
    (println (.trim (remove-chars (nth v 1) (nth v 0))))))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
