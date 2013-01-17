(ns least-common-ancestor
 (:gen-class)
 (:use clojure.set))

(defstruct binary-tree :data :left :right)

(defn insert [tree val]
 (if tree
  (cond
   (> (tree :data) val)
    (let [left (insert (tree :left) val)]
     (assoc tree :left left))
   (< (tree :data) val)
    (let [right (insert (tree :right) val)]
     (assoc tree :right right)))
  (struct binary-tree val)))

(defn lookup [tree val ancestors]
 (if tree
  (cond
   (= (tree :data) val)
    ancestors
   (> (tree :data) val)
    (lookup (tree :left) val (cons (tree :data) ancestors))
   (< (tree :data) val)
    (lookup (tree :right) val (cons (tree :data) ancestors)))
   ancestors))

(defn elem? [v list]
 (if (not= '() list)
  (if (= v (first list)) true (elem? v (rest list)))
  false))

(defn first= [l1 l2]
 (if (elem? (first l1) l2) (first l1) (first= (rest l1) l2)))

(defn lca [tree v1 v2]
 (if tree
  (let [v1-ancestors (lookup tree v1 nil)
        v2-ancestors (lookup tree v2 nil)]
    (first= v1-ancestors v2-ancestors))))

(defn process [tree line]
 (if (< 0 (.length line))
  (let [l (map #(Integer/parseInt %) (seq (.split line " ")))]
   (if (< 0 (count l))
    (println (lca tree (nth l 0) (nth l 1)))))))

(defn -main [args]
 (let [tree (reduce #(insert %1 %2) nil '(30 8 52 3 20 10 29))]
  (with-open [rdr (clojure.java.io/reader args)]
   (doseq [line (line-seq rdr)] (process tree line)))))

(apply -main *command-line-args*)
