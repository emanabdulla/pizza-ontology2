(ns pizza.pizza
(:use [tawny.owl])
  (:require [tawny.owl :refer :all]))


(defontology pizza
  :iri "http://example.com/pizza")




(as-disjoint
(defclass pizza
:label "pizza"
:comment "A type of prepared food")
(defclass pizzacomponent
:label "pizza component"
:comment "food that is part of pizza"))


(as-subclasses
pizzacomponent
:disjoint :cover
(defclass pizzaBase)
(defclass pizzaTopping))

(as-inverse
(defproperty hasComponent)
(defproperty isComponentOf))

(defoproperty hasTopping
:super hasComponent
:range pizzaTopping
:domain pizza)

(defproperty has Base
:super hasComponent
:characteristic :functional
:range pizzaBase
:domain pizza)



(as-subclasses
 PizzaTopping
 :disjoint
(defclass CheeseTopping)
(defclass FishTopping)
(defclass FruitTopping)
(defclass HerbSpiceTopping)
(defclass MeatTopping)
(defclass NutTopping)
(defclass SauceTopping)
(defclass VegetableTopping))

(as-subclasses 
CheeseTopping 
:disjoint
(declare-classes
 GoatsCheeseTopping
GorgonzolaTopping 
MozzarellaTopping
ParmesanTopping))

(as-subclasses 
VegetableTopping 
:disjoint

(defclassn 
[PepperTopping
:label "Pepper Topping"]
 [GarlicTopping
:label "Garlic Topping"]
 [PetitPoisTopping]
 [AsparagusTopping]
 [TomatoTopping]
 [ChilliPepperTopping]))


(as-subclasses
MeatTopping
:disjoint
(defclass HamTopping)
(defclass PepperoniTopping))

(as-subclasses
FruitTopping
(defclass PineappleTopping))

(owl-class pizza
:super
(owl-some hasTopping pizzaTopping)
(owl-some hasBase pizzaBase))

(defclass MargheritaPizza
 :super
Pizza
(owl-some hasTopping MozzarellaTopping)
(owl-some hasTopping TomatoTopping)
(only hasTopping (owl-or MozzarellaTopping TomatoTopping)))

(defclass HawaiianPizza
 :super

Pizza
(owl-some hasTopping MozzarellaTopping)
(owl-some hasTopping TomatoTopping)
(owl-some hasTopping HamTopping) 
(owl-some hasTopping PineappleTopping) 
(only hasTopping
(owl-or MozzarellaTopping TomatoTopping HamTopping PineappleToppin))
