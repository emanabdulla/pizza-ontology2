(ns take.wing
  [:use [tawny.owl]]
  [:require [take.wing.pizza]])


(defn -main [& args]
  (save-ontology take.wing.pizza/take-wing-pizza "take-wing-pizza.omn"))
