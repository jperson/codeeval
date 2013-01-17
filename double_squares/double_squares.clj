(ns double_squares
 (:gen-class))

(defn squares [n]
 (for [x (range 0 (inc (Math/sqrt n)))] (* x x)))

(defn squares-map [n]
 (reduce #(assoc %1 (* %2 %2) %2) nil (range (inc (Math/sqrt n)))))

(defn dbl-s [smap s n]
 (let [count (reduce + 0 (for [y s :when (get smap (- n y))] 1))]
    (if (= 1 count) 1 (if (odd? count) (- count 1) (/ count 2))))) 

(defn process [line smap s]
 (let [n (Integer/parseInt line)]
  (println (dbl-s smap s n))))

(defn -main [args]
 (let [smap (squares-map 2147483647)
       s (squares 2147483647)]
  (with-open [rdr (clojure.java.io/reader args)]
   (let [c (line-seq rdr)]
    (doseq [line (line-seq rdr)] (process line smap s))))))

(apply -main *command-line-args*)
