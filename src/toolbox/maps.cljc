(ns toolbox.maps)

(defn remove-nils [m]
  (into {} (filter second m)))
