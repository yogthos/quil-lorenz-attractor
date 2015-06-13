(defproject lorenz "0.1.0-SNAPSHOT"
  :description "a Lorenz attractor using Quil"
  :url "https://github.com/yogthos/quil-lorenz-attractor"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [quil "2.2.5"]
                 [org.clojure/clojurescript "0.0-3308"]]

  :plugins [[lein-cljsbuild "1.0.5"]
            [lein-figwheel "0.3.1"]]

  :hooks [leiningen.cljsbuild]

  :cljsbuild {
              :builds [{:source-paths ["src/"]
                        :figwheel true
                        :compiler {:main "lorenz.core"
                                   :asset-path "js/out"
				                           ;:optimizations :advanced
                                   :output-to "resources/public/js/lorenz.js"
                                   :output-dir "resources/public/js/out" }}]})
