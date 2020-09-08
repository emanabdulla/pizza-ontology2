(ns take.wing.pizza-test
    (:use [clojure.test])
    (:require
     [take.wing.pizza :as ont]
     [tawny.owl :as o]
     [tawny.reasoner :as r]
     [tawny.fixture :as f]))

(use-fixtures :each (f/reasoner :hermit))

(deftest reasonable
  (is (r/consistent? take.wing.pizza/take-wing-pizza))
  (is (r/coherent? take.wing.pizza/take-wing-pizza)))
