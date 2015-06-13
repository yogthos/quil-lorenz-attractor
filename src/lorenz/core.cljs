(ns ^:figwheel-no-load lorenz.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]
            [lorenz.app :as app]))

(enable-console-print!)

(q/defsketch hello-quil
  :host "canvas"
  :size [app/width app/height]
  ; setup function called only once, during sketch initialization.
  :setup #'app/setup
  ; update-state is called on each iteration before draw-state.
  :update #'app/update-state
  :draw #'app/draw-state
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.

  :features [:global-key-events]
  :middleware [m/fun-mode])
