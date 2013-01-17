(ns substrings
 (:gen-class))

(defn parse [st acc sts]
 (if (empty? st)
  (reverse (map #(apply str %) (cons acc sts)))
  (let [[s & ss] st]
   (if (= \* s) 
    (if (= (last acc) \\) 
     (parse ss (concat (drop-last acc) [s]) sts)
     (parse ss nil (cons acc sts)))
    (parse ss (concat acc [s]) sts)))))

(defn substring2 [s, subs]
 (if (empty? subs)
  true
  (if (empty? s)
   false
   (if (= (apply str (take (count (first subs)) s)) (first subs)) (recur (drop (count (first subs)) s) (rest subs)) (recur (drop 1 s) (first subs))))))

(defn substring [s, sub]
 (if (empty? s) 
  "false" 
  (if (= (apply str (take (count sub) s)) sub) "true" (recur (drop 1 s) sub))))

(defn process [line]
 (if (not= "" line)
  (let [[s sub] (.split line ",")]
   (println (substring s sub)))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

;(apply -main *command-line-args*)
