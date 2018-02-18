(ns organizer.routes
  (:refer-clojure :exclude [get])
  (:require [compojure.core :as compojure]
            [organizer.controllers.documents :as docs]))
;
; (macroexpand-1 '
;                (defroutes foobar
;                  (GET "/" []
;                       "FOO")))

(def foobar (compojure/routes (compojure/GET "/" [] "FOO")))
;
; (macroexpand '(GET "/foo" [] "FOO"))
;
; (def a (GET "/foo" [] "FOO"))
;
; (a {:request-method :get :compojure/path "/foo"})

(defn get [path handler]
  (compojure/GET path req (handler req req)))

(defn routes* [routes]
  (apply compojure/routes routes))

(defmacro def-routes [name & routes]
  `(def ~name (routes* ~(vec routes))))

(def-routes routes
  (get "/" docs/hello))
