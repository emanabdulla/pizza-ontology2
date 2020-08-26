(ns pizza.core
  [:use [tawny.owl]]
  [:require [pizza.pizza]])


(defn -main [& args]
  (save-ontology pizza.pizza/pizza "pizza.omn")
(save-ontology pizzaontology "pizza.owl" :owl))


