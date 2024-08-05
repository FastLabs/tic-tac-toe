(ns tic-tac-toe.core-test
  (:require [clojure.test :refer [deftest testing is are]]
            [tic-tac-toe.core :as game]))

(deftest tic-tac-toe-game-test
  (testing "the finite set of winning combinations"
    (is (= #{[0 1 2]
             [3 4 5]
             [6 7 8]
             [0 3 6]
             [1 4 7]
             [2 5 8]
             [0 4 8]
             [2 4 6]}
           (set game/win-sets))))

  (testing "board allocation"
    (is (= [nil nil nil
            nil nil nil
            nil nil nil]
           (game/new-game-board))))

  (testing "board-full? returns true when the game board is filled by the players"
    (let [game-board [:x :o :x :o :x :x :o :x :x]]
      (is (game/board-full? game-board))))

  (testing "board-full? returns false for an incomplete or  empty board"
    (testing "an empty new board"
      (is (not (game/board-full? (game/new-game-board)))))

    (testing "a partially filled game board"
      (let [game-board [:x :o :x :o nil :x :o :x nil]]
        (is (not (game/board-full? game-board))))))

  (testing "winning combinations"
    (are [board] (= :x (game/find-game-winner board))
                 [:x :x :x
                  nil :o :o
                  nil nil nil]
                 [:o :o nil
                  :x :x :x
                  nil nil nil]
                 [nil nil nil
                  :o nil :o
                  :x :x :x]
                 [:x nil :o
                  :x :o nil
                  :x nil nil]
                 [:o :x :o
                  nil :x nil
                  nil :x nil]
                 [:o nil :x
                  nil :o :x
                  nil nil :x]
                 [:x nil :o
                  nil :x nil
                  :o nil :x]
                 [:o nil :x
                  nil :x :o
                  :x nil nil]))
  (testing "look for the winner when the game is not over"
    (let [board [:o :x :x
                 :x :o :o
                 :x :o nil]]
      (is (not (game/find-game-winner board)))))
  (testing "look for the winner when it is a draw"
    (let [board [:o :x :x
                 :x :o :o
                 :x :o :x]]
      (is (game/find-game-winner board)))))


