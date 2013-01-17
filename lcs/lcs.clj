(ns lcs
 (:gen-class))

(defn maxl [ls hs] (if (> (count ls) (count hs)) ls hs))

(def lcs
 (memoize 
  (fn [w1 w2]
   (when-let [[x & xs] (seq w1)]
    (when-let [[y & ys] (seq w2)]
     (if (= x y)
      (cons x (lcs xs ys))
      (maxl (lcs w1 ys) (lcs xs w2))))))))

(defn process [line]
 (if (not= "" line)
  (let [[v1 v2] (.split line ";")]
   (println (apply str (lcs v1 v2))))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
