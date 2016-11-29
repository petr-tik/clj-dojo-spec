(ns clj-dojo-spec.sdefs
  (:require [clojure.spec :as s]))

(s/def ::president-name string?)
(s/def ::birth-year int?)
(s/def ::death-year int?)

(defn valid-dates [president]
  (or (nil? (::death-year president))
      (< (::birth-year president) (::death-year president))))

(s/def ::president (s/and (s/keys :req [::president-name ::birth-year]
                                  :opt [::death-year])
                          valid-dates))


