(ns toolbox.strings
  (:require [clojure.string :as str]))


(defn non-blank-string? [s]
  {:pre [(string? s)]}
  (not (str/blank? s)))
