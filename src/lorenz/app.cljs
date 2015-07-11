(ns lorenz.app
  (:require [quil.core :as q :include-macros true]))

(def width (.-innerWidth js/window))
(def height (.-innerHeight  js/window))
(def dt 0.01)
(def prandtl 10)
(def rayleigh 28)
(def beta (/ 8 3))
(def xmin -25)
(def xmax 25)
(def ymin 0)
(def ymax 50)
(def dx (- xmax xmin))
(def dy (- ymax ymin))

(defn append-state [states new-state]
  (vec (reverse (take 10 (reverse (conj states new-state))))))

(defn next-position [[x y z]]
  (let [dx (* (- prandtl) (- x y))
        dy (- (+ (- (* rayleigh x) (* x z))) y)
        dz (- (* x y) (* beta z))]
    [(+ x (* dt dx))
     (+ y (* dt dy))
     (+ z (* dt dz))]))

(defn setup []
  [(take 30
         (map (fn [color value] {:color color :value value})
              (repeatedly (fn[] [(rand 255) (rand 255) (rand 255)]))
              (iterate (fn [col] [(rand 30), (rand 30), (rand 30)]) [0.0, 0.0, 0.0])))])

(defn update-state [states]
  (append-state
   states
   (map #(update % :value next-position) (last states))))

(defn draw-state [states]
  (q/background 0)
  (doseq [state states]
    (doseq [{[x r y] :value, color :color} state]
      (apply q/fill color)
      (let [xs (/ (* width (- x xmin)) dx)
            ys (/ (* height (- ymax y)) dy)
            r2 (/ r 2)]
        (if (> r 1)
          (q/ellipse (- xs r2) (- ys r2) r r)
          (q/rect (Math/round xs) (Math/round ys) 1 1))))))
