# Scalable Arcade Simulation

* **Objective** - To extend a preexisting arcade with built-in infrastructure.
* **Purpose** - To gain familiarity the following features:
    * Generics
    * Design Patterns
* **Tip** - All modifications should take place in children of package named `arcade.game`.

<img src="https://raw.githubusercontent.com/curriculeon/maven.scalable-arcade/master/uml.png">



## Instructions

### Part 1 - Check Build
* Ensure that all test cases in `com.github.curriculeon` pass with 100% success rate.

### Part 2 - Create `HighLow` tests
1. Create tests for at least 5 of the methods of the classes in `arcade.game.cardgame.highlow`.
2. Ensure that all test cases in `com.github.curriculeon` pass with 100% success rate.

### Part 3 - Create `BlackJack` implementation
1. Implement `Blackjack` mimicking the same package and class structures of `arcade.game.cardgame.highlow`.
2. Create tests for at least 10 methods of the classes in `arcade.game.cardgame.blackjack`
3. Ensure that all test cases in `com.github.curriculeon` pass with 100% success rate.

### Part 4 - Create `HighLowGame` dice-game
1. Implement `HighLow` using `Dice` objects in a package named `arcade.game.dicegame.highlow`.
2. Create tests for at least 10 methods of the classes in `arcade.game.dicegame.highlow`.
3. Ensure that all test cases in `com.github.curriculeon` pass with 100% success rate.


<hr><hr>
 
## Developmental Notes
* The following documentation may be slightly [stale](https://stackoverflow.com/questions/1563319/what-is-stale-state).

### `Profile` class
* **Description:**
	* `Profile` stores a arcade-visitor's `id`, `name`, and `balance`.

### `PlayerInterface` interface
* **Description:**
	* `PlayerInterface` is a contract to ensure that all players have reference to a `profile`.

### `Player` class
* **Description:**
	* Represents a player within the context of a game.
 	* should [cease to exist](https://stackoverflow.com/questions/3798424/what-is-the-garbage-collector-in-java) upon termination of a game.
* `Player` should implement `PlayerInterface`
* `Player` objects should be created within the scope of a game.

### `GameInterface` interface
* **Description:**
	* Represents a game which handles some type of player.
* should be parameterized with a generic type whose upper bound is `PlayerInterface`.
	* e.g. - `SomePlayerType` is a subclass of `PlayerInterface`.
	* This restricts the types of players this game can interact with.
* `GameInterface` should declare each of the following methods:
	* `TypeOfPlayer[] getPlayers()`
	* `TypeOfPlayer getPlayer(Long playerId)`
	* `void addPlayer(TypeOfPlayer player)`
	* `void removePlayer(TypeOfPlayer player)`
	* `Boolean contains(TypeOfPlayer player)`


### `GameEngineInterface` interface
* **Description:**
	* `GameEngineInterface` is a contract which ensures a specific type of `GameEngine` operates on a specific type of `Player` and a specific type of `Game`

* should be parameterized with two generic types
	* `GameTypePlayer` a sub class of `PlayerInterface`
	* `GameType` a sub class of `GameInterface<GameTypePlayer>`

* should declare three method signatures
	* `GameType getGame()`
		* return the composite Game object to the client.
	* `void evaluateTurn(GameTypePlayer player)`
		* evaluate the turn of a player,
	* `void run()`
		* begin game


### `GameEngine` abstract class
* **Description**
	* `GameEngine` ensures all sub-classes provide a `Game` object upon instantiation.
* should be parameterized with two generic types
	* `GameTypePlayer` a sub class of `PlayerInterface`
	* `GameType` a sub class of `GameInterface<GameTypePlayer>`
* should implement a `GameEngineInterface<GameType, GameTypePlayer>`
* should defer the definition of `evaluateTurn` and `run` to sub-classes.



<hr><hr><hr>

## How to Download

#### Part 1 - Forking the Project
* To _fork_ the project, click the `Fork` button located at the top right of the project.


#### Part 2 - Navigating to _forked_ Repository
* Navigate to your github profile to find the _newly forked repository_.
* Copy the URL of the project to the clipboard.

#### Part 3 - Cloning _forked_ repository
* Clone the repository from **your account** into the `~/dev` directory.
  * if you do not have a `~/dev` directory, make one by executing the following command:
    * `mkdir ~/dev`
  * navigate to the `~/dev` directory by executing the following command:
    * `cd ~/dev`
  * clone the project by executing the following command:
    * `git clone https://github.com/MYUSERNAME/NAMEOFPROJECT`

#### Part 4 - Check Build
* Ensure that the tests run upon opening the project.
    * You should see `Tests Failed: 99 of 99 tests`







## How to Submit

#### Part 1 -  _Pushing_ local changes to remote repository
* from a _terminal_ navigate to the root directory of the _cloned_ project.
* from the root directory of the project, execute the following commands:
    * add all changes
      * `git add .`
    * commit changes to be pushed
      * `git commit -m 'I have added changes'`
    * push changes to your repository
      * `git push -u origin master`

#### Part 2 - Submitting assignment
* from the browser, navigate to the _forked_ project from **your** github account.
* click the `Pull Requests` tab.
* select `New Pull Request`
