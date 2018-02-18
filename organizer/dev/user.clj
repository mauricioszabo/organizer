(ns user
  (:require [organizer.core :as core]))

(def server (atom nil))

(defn start! []
  (reset! server (core/start-server!)))

(defn stop! []
  (some-> @server .stop)
  (reset! @server nil))
