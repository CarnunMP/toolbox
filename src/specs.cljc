(ns specs
  (:require #?(:clj  [clojure.spec.alpha :as s]
               :cljs [cljs.spec.alpha :as s])
            [clojure.string :as str]))


(s/def ::non-blank-string (s/and string? (complement str/blank?)))
