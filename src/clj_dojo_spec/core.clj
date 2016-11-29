(ns clj-dojo-spec.core
  (:require [clojure.spec :as s])
  (:require [clojure.java.io :as io])
  (:require [clj-time.format :as f]))

(def presidents-file
  (slurp "https://raw.githubusercontent.com/petr-tik/clj-dojo-spec/master/presidents_births.csv"))



(java.util.Locale/getDefault)

(def custom-formatter (f/with-locale
                        (f/formatter "MMM dd yyyy")
                        java.util.Locale/ENGLISH))

(f/parse custom-formatter "July 11 1767")

