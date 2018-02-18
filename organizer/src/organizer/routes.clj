(ns organizer.routes
  (:refer-clojure :exclude [get])
  (:require [compojure.core :as compojure]
            [organizer.controllers.documents :as docs]
            [ring.middleware.defaults :as defaults]
            [ring.middleware.json :as json]))

(defn get [path handler]
  (compojure/GET path req (handler req req)))

(defn routes* [routes]
  (-> (apply compojure/routes routes)
      (defaults/wrap-defaults defaults/api-defaults)
      json/wrap-json-response
      json/wrap-json-params))

(defmacro def-routes [name & routes]
  `(def ~name (routes* ~(vec routes))))

(def-routes routes
  (get "/" docs/hello))
