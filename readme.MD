### Tic-Tac-Toe

Simple take on tic-tac-toe game implementation in clojure

### Requirements 
- [clojure deps]( https://clojure.org/guides/deps_and_cli) 

#### Project structure
The namespace ```tic-tac-toe.core``` contains the main game operations such as:
- new game board: ```new-game-board``` - will generate a new board (a vector of 9 positions) filled with ```nil```- the default value of a not populated position
- is board full ``board-full?`` - checks if all positions of the board were filled: ```true``` meaning the game is over 
- find game winner ``find-game-winner`` - takes a board data structure and looks for the winner. Returns: 
  - ``false`` if the game is not over
  - ``true`` if it is a draw
  -  the winner of the game: ``:x`` or ``:o``  
  

#### Give it a try
- run repl from the project directory: ```clj```
- change namespace: ``` (use 'tic-tac-toe.core)```
- define a partial filled board: ```(def board [:x nil nil :o nil nil nil nil nil])```
- check if the board is full: ```(board-full? board)```
- make the ```:x``` player as winner ```(def board (reduce (fn [board position] (assoc board position :x)) board [1 2]))```
- check the winner: ```(find-game-winner board1)``` should return : ``:x``

### For developers
Running the unit tests: from the project directory execute ``clj -M:test`` 
