
(ns take.wing.pizza
  (:use [tawny.owl]
        [tawny.reasoner])
  (:refer-clojure :only []))

(defontology pizza
  :iri "http://purl.org/ontolink/take-wing/pizza")

(as-disjoint
 (defclass Pizza
   :label "Pizza"
   :comment "A type of prepared food")
 (defclass PizzaComponent
   :label "pizza Component"
   :comment "food that is part of pizza."))

(as-subclasses
 PizzaComponent
 :disjoint  :cover
 (defclass PizzaBase)
 (defclass PizzaTopping))

(as-inverse
 (defoproperty hasComponent)
 (defoproperty isComponentOf))

(defoproperty hasTopping
  :super hasComponent
  :range PizzaTopping
  :domain Pizza)

(defoproperty hasBase
  :super hasComponent
  :characteristic :functional
  :range PizzaBase
  :domain Pizza)

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

(owl-class Pizza
           :super
           (owl-some hasTopping PizzaTopping)
           (owl-some hasBase PizzaBase))

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
        (owl-or MozzarellaTopping TomatoTopping HamTopping PineappleTopping)))

(defclass AmericanPizza
  :super
  Pizza
  (owl-some hasTopping MozzarellaTopping
             TomatoTopping PepperoniTopping)
  (only hasTopping (owl-or MozzarellaTopping TomatoTopping PepperoniTopping)))

(defclass AmericanHotPizza
  :super
  Pizza
  (some-only hasTopping MozzarellaTopping TomatoTopping
              PepperoniTopping ChilliPepperTopping))
(defclass VegetarianPizza
  :equivalent
  (owl-and Pizza
            (only hasTopping
                   (owl-not (owl-or MeatTopping FishTopping)))))
