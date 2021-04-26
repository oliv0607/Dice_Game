# Dice_Game

A program that simulates a game of dice. There are two players in the game named: first, second. Each player takes 5 turns. 
The player's turns are played alternately - the first player starts the game, then the second player's turn, the first player's turn, etc. 
The first player always starts the game. During each turn, the player collects penalty points according to the rules described below. 
Each player's total points before the start of the game is zero. The player with the lowest number of points wins.

Each turn, a player rolls a maximum of 10 two dice simultaneously. The possible results of a single die roll are one of the following numbers {1, 2, 3, 4, 5, 6}.

Game rules:
1. If, on the first roll of a turn, a player gets a total of 7 or 11 on both dice, he wins the turn ahead of time (the opponent's turn begins).
2. If the player on the first throw of the turn gets a total of 2 or 12 on both dice, they lose the turn ahead of time (the opponent's turn begins). 
    The maximum is added to the player's points possible number of penalty points per turn (as many as he would have received in the most pessimistic course of his turn).
3. If a player has both dice total of 5, he wins the turn ahead of time (the opponent's turn begins).
4. If a player gets the total number of dice from both dice other than those described above, 
    the sum of the dice obtained on the given throw divided by the number of dice on the given turn is added to his points.

After the end of all turns of both players, the standard output is displayed with a message about the total points scored by each player and information about the winner.
