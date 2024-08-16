(ns tic-tac-toe.core)


(defn line-win-combinations [number-positions]
  (partition-all number-positions (range (* number-positions number-positions))))

(defn column-win-combinations [number-positions]
  (apply map vector (line-win-combinations number-positions)))

(defn diagonal-win-combinations [number-positions]
  [(map #(+ (* number-positions %) %) (range number-positions))
   (map #(- (dec (* number-positions (inc %))) %) (range number-positions))])


(defn all-win-combinations [number-positions]
  (concat
    (line-win-combinations number-positions)
    (column-win-combinations number-positions)
    (diagonal-win-combinations number-positions)))

(defn- winning-line? [board winning-positions]
  (and (apply = (map #(nth board %) winning-positions))
       (not (nil? (first winning-positions)))))

(defn- find-sequence-winner [board winning-positions]
  (when (winning-line? board winning-positions)
    (board (first winning-positions))))

(defn new-game-board
  ([]
   (new-game-board 3))
  ([board-size]
   (let [vector-size (* board-size board-size)]
     (vec (repeat vector-size nil)))))

(defn board-full? [board]
  (not-any? nil? board))

(defn find-game-winner [board]
  (let [game-winning-combinations (all-win-combinations
                                    (int (java.lang.Math/sqrt (count board))))
        game-winner (some #(find-sequence-winner board %) game-winning-combinations)]
    (or game-winner
        (board-full? board))))

(defn find-game-winner [board wining-combinations]
  (let [game-winner (some #(find-sequence-winner board %) wining-combinations)]
    (or game-winner
        (board-full? board))))
