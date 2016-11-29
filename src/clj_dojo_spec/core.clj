(ns clj-dojo-spec.core)

(defn trim
  "trim string"
  [string]
  (clojure.string/trim string)
  )

(defn csv-parse [data]
  (map #(clojure.string/split % #",")
       (clojure.string/split data #"\r\n")
       )
  )


(defn read-presidents-to-map
  "I don't do a whole lot."
  [filename]
  (let [csv-data (slurp filename)]
    (map #(map trim %)
         (csv-parse csv-data)
         )
    )
  )
        
