(ns largest-sum
 (:gen-class))

(defn sum [xs]
 (reduce + 0 xs))

(defn maxl [ls]
 (reduce #(max %1 %2) (first ls) (rest ls)))

(defn largest_sum [ls]
 (maxl (map sum (filter #(not (empty? %)) (for [x (range 0 (inc (count ls))) y (range 0 (inc (count ls)))] (take x (drop y ls)))))))

(defn process [line]
 (if (not= "" line)
  (let [v (map #(Integer/parseInt (.trim %)) (.split line ","))]
   (if (not (empty? v))
    (println (largest_sum v))))))

(defn -main [args]
 (with-open [rdr (clojure.java.io/reader args)]
  (doseq [line (line-seq rdr)] (process line))))

(apply -main *command-line-args*)
