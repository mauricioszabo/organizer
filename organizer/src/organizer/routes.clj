(ns organizer.routes
  (:refer-clojure :exclude [get])
  (:require [compojure.core :as compojure]
            [organizer.controllers.documents :as docs]))

(defn get [path handler]
  (compojure/GET path req (handler req req)))

(defn routes* [routes]
  (apply compojure/routes routes))

(defmacro def-routes [name & routes]
  `(def ~name (routes* ~(vec routes))))

(def-routes routes
  (get "/" docs/hello))
