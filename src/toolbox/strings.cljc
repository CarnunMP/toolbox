(ns toolbox.strings
  (:require [clojure.string :as str]))


(defn non-blank-string? [s]
  (and (string? s)
       (not (str/blank? s))))
