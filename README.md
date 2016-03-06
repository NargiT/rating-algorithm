# Rating algorithm Library

The Rating Algorithm library implement a rating system (Based on ELO) in order to handle the following type of games:

* 1 vs 1
* 2 vs 2
* n vs n
* 1 vs 1 vs 1 vs ...
* 2 vs 2 vs 2 vs ...


You decide about the K factor and provide the player current elo points with it's 'position' (see **How to choose position** ?) in the game, and
 the algorithm calculates the new elo points.

It is a very low level library, so make sure you are using it correctly.

## Examples : 1 winner 1 loser
  The winner wins points, whereas the loser loses points
```java
EloAlgorithm eloAlgorithm = new EloAlgorithm(new DefaultEloPerformance());
Double winner = eloAlgorithm.calculateNewQuotation(1400, 1350, 1, 20);
Double looser = eloAlgorithm.calculateNewQuotation(1350, 1400, 2, 20);
```

  If we change the situation, the loser wins more points that the winner in the previous case, because he is weaker
```java
EloAlgorithm eloAlgorithm = new EloAlgorithm(new DefaultEloPerformance());
Double winner = eloAlgorithm.calculateNewQuotation(1350, 1400, 1, 20) {
Double looser = eloAlgorithm.calculateNewQuotation(1400, 1350, 2, 20) {
```

## Examples : Draw
   The looser will win points, whereas the winner will lose points
```java
EloAlgorithm eloAlgorithm = new EloAlgorithm(new DefaultEloPerformance());
Double winner = eloAlgorithm.calculateNewQuotation(1400, 1350, 1.5, 20) {
Double looser = eloAlgorithm.calculateNewQuotation(1350, 1400, 1.5, 20) {
```

## Examples : Multiplayer game
   The looser will win points, whereas the winner will lose points
```java
EloAlgorithm eloAlgorithm = new EloAlgorithm(new DefaultEloPerformance());
int K_FACTOR = 20;
List<Double> opponents = // you need to generate the list of opponents rating yourself

double player1NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 1, K_FACTOR);
double player2NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 2, K_FACTOR);

// player3 and player4 are in a draw
double player3NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 3.5, K_FACTOR);
double player4NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 3.5, K_FACTOR);

// player5 is in position 5 not 4
double player5NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 5, K_FACTOR);

double player6NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 6.5, K_FACTOR);
double player7NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 6.5, K_FACTOR);
```

## <div id="position">How to choose position ?
Well, the library is at the very low level, let say if you have the following results from your tournament

Position | Player | Result
--- | --- | ---
1 | Alex | 15
2 | Michelle | 12
3 | David | 10
3 | James | 10
5 | John | 8

In order for rating algorithm to understand that there is a draw, you need to use the following position for
David, James and John

Real position | Player | Technical Position
--- | --- | ---
3 | David | 3.5
3 | James | 3.5
5 | John | 5

## Links
* https://en.wikipedia.org/wiki/Elo_rating_system
* http://sradack.blogspot.ch/2008/06/elo-rating-system-multiple-players.html
* And everything else on internet that helped me to implement something that I think is ok


