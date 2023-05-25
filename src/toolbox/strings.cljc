(ns toolbox.strings
  (:require [clojure.string :as str]))


(defn non-blank? [s]
  {:pre [(string? s)]}
  (not (str/blank? s)))
