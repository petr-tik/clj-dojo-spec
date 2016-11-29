(ns clj-dojo-spec.sdefs
  (:require [clojure.spec :as s]))

(s/def ::president-name string?)
(s/def ::birth-year int?)
(s/def ::death-year int?)

(defn valid-dates [president]
  "Checks that president died after he was born, if the death-year is provided"
  (or (nil? (::death-year president))
      (< (::birth-year president) (::death-year president))))

(defn correct-age [president]
  "Assumes that all presidents were at least 35 years old when taking office"
  (or (nil? (::death-year president))
      (>= (- (::death-year president)
            (::birth-year president))
         35)))

(s/def ::president (s/and (s/keys :req [::president-name ::birth-year]
                                  :opt [::death-year])
                          valid-dates
                          correct-age))

(def p1 {::president-name "Jim" ::birth-year 1920 ::death-year 1960})
(def p2 {::president-name "Jim" ::birth-year 1920 ::death-year 1860})
(def p3 {::president-name "Jim" ::birth-year 1920})
(def p4 {::president-name "Jim" ::birth-year 1920 ::death-year 1930})

