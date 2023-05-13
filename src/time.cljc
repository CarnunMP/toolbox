(ns time
  (:require #?(:clj  [clojure.spec.alpha :as s]
               :cljs [cljs.spec.alpha :as s])
            [clojure.string :as str]
            [tick.core :as t]
            ; ---
            specs))


(defn day-of-month->abbrev [day]
  {:pre [(s/valid? :specs/non-blank-string day)]}
  (case day
    "1" "1st"
    "2" "2nd"
    "3" "3rd"
    "21" "21st"
    "22" "22nd"
    "23" "23rd"
    "31" "31st"
    (str day "th")))

(defn readable-date
  ([] (readable-date (t/inst)))
  ([inst]
   {:pre [(inst? inst)]}
   (let [date (t/date inst)
         weekday (-> date t/day-of-week str str/capitalize)
         day (-> date t/day-of-month str)
         month (-> date t/month str str/capitalize)
         year (-> date t/year str)]
     (str weekday " " (day-of-month->abbrev day) " " month ", " year))))

(comment
  (map (comp day-of-month->abbrev str) (range 1 32))
  (readable-date)
  )


(defn short-time
  ([] (short-time (t/time)))
  ([t]
   {:pre [(t/time? t)]}
   (re-find #"\d\d:\d\d" (str t))))
