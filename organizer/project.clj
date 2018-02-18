(defproject organizer "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [prismatic/schema "1.1.7"]
                 [compojure "1.6.0"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-jetty-adapter "1.2.1"]]
  :main ^:skip-aot organizer.core
  :target-path "target/%s"
  ; :plugins [[lein-ring "0.9.7"]]
  ; :ring {:handler bank-account-clj.handler/app}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]
                                  [midje "1.9.0"]]
                   :source-paths ["dev"]
                   :plugins [[lein-midje "3.2.1"]
                             [lein-cloverage "1.0.9"]]}
             :uberjar {:aot :all}})
