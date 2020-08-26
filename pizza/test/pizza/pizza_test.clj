(ns pizza.pizza-test
    (:use [clojure.test])
    (:require
     [pizza.pizza :as ont]
     [tawny.owl :as o]
     [tawny.reasoner :as r]
     [tawny.fixture :as f]))

(use-fixtures :each (f/reasoner :hermit))

(deftest reasonable
  (is (r/consistent? pizza.pizza/pizza))
  (is (r/coherent? pizza.pizza/pizza)))
