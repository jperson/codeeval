(ns nrc
 (:gen-class))

(defn nrc [line]
 (if (not= "" line)
  (let [nrc-map (reduce #(assoc %1 %2 (inc (get %1 %2 0))) nil (seq line))]
   (println (first (filter #(= 1 (get nrc-map %)) (seq line)))))))

(defn -main [args]
    (with-open [rdr (clojure.java.io/reader args)]
        (doseq [line (line-seq rdr)] (nrc line))))

(apply -main *command-line-args*)
