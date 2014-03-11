(ns six-degrees-clj.core
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.relationships :as nrl]
            [clojurewerkz.neocons.rest.cypher :as cy]))

(defn find-shortest-path
  [actor-name]
  (nr/connect! "http://localhost:7474/db/data/")
  (let [res (cy/tquery (format "START
                       bacon=node(759),
                       other=node:Person(name=\"%s\") 
                       MATCH p = shortestPath(other-[*..16]-bacon)
                       RETURN extract(n in nodes(p): COALESCE(n.title?,n.name?)) 
                       AS `shortest`" actor-name))]
    (clojure.string/join " > " (get (first res) "shortest" ))))

(defn -main [actor-name] (println(find-shortest-path actor-name)))
