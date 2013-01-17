(ns prefix
 (:gen-class))

(defn prefix [s ops vals]
 (if (nil? s)
  (if (not (nil? (first vals))) (int (first vals)) "")
  (let [[x & xs] (seq s)]
   (if (and (> (count vals) 0) (or (not= x "*") (not= x "+") (not= x "/") (not= x " ")))
    (let [[o & op] (seq ops)
          [v & vs] (seq vals)]
      (cond
       (= o "*") (prefix xs op (cons (double (* v (Double/parseDouble x))) vs))
       (= o "+") (prefix xs op (cons (double (+ v (Double/parseDouble x))) vs))
       (= o "/") (prefix xs op (cons (double (/ v (Double/parseDouble x))) vs))))
    (cond
     (= x "*") (prefix xs (cons x ops) vals)
     (= x "+") (prefix xs (cons x ops) vals)
     (= x "/") (prefix xs (cons x ops) vals)
     (= x " ") (prefix xs ops vals)
     :else (prefix xs ops (cons (Double/parseDouble x) vals)))))))
  
(defn process [line]
 (if (not= "" line)
  (println (prefix (vec (.split line " ")) nil nil))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)

