/*The class that starts up the entire game*/
/*Enchanted Florist is a memory game where players must fulfill orders at a florist shop.
 * Upon starting up the game, there will be a menu with 4 options: play, settings, help, and quit
 * To play the game: clicking play takes the player to inside a florist shop, clicking the mail icon on
 * the laptop will randomly generate a order. After an order is accepted there will be a 10 second
 * count down after which the order will disappear. The player must then go the craft stations and create
 * the correct flower bouquet. After clicking complete the player will known how much of the order they 
 * got right.
 * Help has more information about the game and settings allows the player to enter their name and change displays
 * quit closes the program.*/
public class LaunchGame {

	public static void main(String[]args) {
		
		Game game = new Game("Enchanted Florist", 800, 600);
		game.start();
		
	}
}
