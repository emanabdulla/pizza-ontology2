(defproject take-wing-pizza "0.0.1-SNAPSHOT"
  :description "An ontology for take-wing-pizza"
  :dependencies [[uk.org.russet/tawny-owl "2.0.0-SNAPSHOT"]
[org.clojure/clojure "1.10.1"]]
  :main take.wing

  :profiles
  {:light {:plugins [[nightlight/lein-nightlight "1.9.0"]]}}
  )
