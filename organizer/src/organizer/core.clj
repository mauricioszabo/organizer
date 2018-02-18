(ns organizer.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [organizer.routes :as r]))

(def app-routes nil)

(defn start-server! []
  (let [handler r/routes]
    (jetty/run-jetty handler {:port 3000
                              :join? false})))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
