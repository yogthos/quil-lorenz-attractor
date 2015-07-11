(defproject lorenz "0.1.0-SNAPSHOT"
  :description "a Lorenz attractor using Quil"
  :url "https://github.com/yogthos/quil-lorenz-attractor"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [quil "2.7.1"]
                 [org.clojure/clojurescript "1.10.238"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.15"]]

  :hooks [leiningen.cljsbuild]

  :profiles
  {:dev
   {:cljsbuild
    {:builds
     {:dev
      {:source-paths ["src"]
       :figwheel true
       :compiler {:main "lorenz.core"
                  :optimizations :none
                  :asset-path "js/out"
                  :output-dir "resources/public/js/out"
                  :output-to "resources/public/js/lorenz.js"}}}}}
   :min
   {:cljsbuild
    {:builds
     {:min
      {:source-paths ["src"]
       :figwheel true
       :compiler {:main "lorenz.core"
                  :optimizations :advanced
                  :output-dir "resources/public/js"
                  :output-to "resources/public/js/lorenz.min.js"}}}}}})
