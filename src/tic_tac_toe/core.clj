(ns tic-tac-toe.core)

(def win-combinations
  [[0 1 2]
   [3 4 5]
   [6 7 8]
   [0 3 6]
   [1 4 7]
   [2 5 8]
   [0 4 8]
   [2 4 6]])

(defn- winning-line? [board winning-positions]
  (and (apply = (map #(nth board %) winning-positions))
       (not (nil? (first winning-positions)))))

(defn- find-sequence-winner [board winning-positions]
  (when (winning-line? board winning-positions)
    (board (first winning-positions))))

(defn new-game-board []
  (vec (repeat 9 nil)))

(defn board-full? [board]
  (not-any? nil? board))

(defn find-game-winner [board]
  (let [game-winner (some #(find-sequence-winner board %) win-combinations)]
    (or game-winner
        (board-full? board))))
