(ns clj-dojo-spec.core
  (:require [clojure.spec :as s])
  (:require [clojure.java.io :as io])
  (:require [clj-time.format :as f]))


(java.util.Locale/getDefault)

(def custom-formatter (f/with-locale
                        (f/formatter "MMM dd yyyy")
                        java.util.Locale/ENGLISH))

; example
(f/parse custom-formatter "July 11 1767")


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
        

