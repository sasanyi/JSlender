/**
 * @author Savanya Sándor József
 * @version 2.0
 */
package jslender;

import java.util.Scanner;

import characters.Player;
import characters.Position;
import characters.Slenderman;
import map.Map;
import map.Paper;
import math.JSlenderMath;

/**
 * @author user
 *
 */
public class GameLogic {
	private static Player player;
	private static Slenderman slenderman = null;
	private Scanner sc;
	public static void startGame() {
		//new Map();
		player = new Player();
		player.spawn();
		Paper.addPaper(new Position(2, 15));
		Paper.addPaper(new Position(5, 8));
		
		new Map();
		GameLogic game = new GameLogic();
		game.startGameLoop();

	}

	private void startGameLoop() {
		sc = new Scanner(System.in);
		Map.writeMapConsole();
		System.out.println("Úristen! Hova kerültem? Segítség!");
		String command = "";
		boolean gameStopped = false;
		while (!gameStopped) {
			System.out.print("\n Segíts! Merre menjek? (Félek):");
			command = sc.nextLine();
			// System.out.println(command);
			switch (command) {
			case "w":
				//System.out.println("W");
				if (!player.moveAsY(-1)) {
					System.out.println("Oda nem tudok menni!");
				}
				break;
			case "s":
				if (!player.moveAsY(1)) {
					System.out.println("Oda nem tudok menni!");
				}
				break;
			case "d":
				if (!player.moveAsX(1)) {
					System.out.println("Oda nem tudok menni!");
				}
				break;
			case "a":
				if (!player.moveAsX(-1)) {
					System.out.println("Oda nem tudok menni!");
				}
				break;
			case "stop":
				gameStopped = true;
				break;
			case "exit":
				gameStopped = true;
				break;
			case "help":
				this.help();
				break;
			default:
				System.out.println("Nem ismerem ezt a parancsot!");
				break;
			}

			Player.numofstep++;
			if (Paper.findPaper(player.getPosition())) {

				Paper.numOfFoundPapers++;
				System.out.println("Találtam itt valamit! Vajon mi ez? (8 / " + Paper.numOfFoundPapers + " cetli)");

			}

			if (Paper.numOfFoundPapers > 0 && slenderman == null) {

				slenderman = new Slenderman();
				slenderman.spawn();

			} else if (slenderman != null) {
				if (Player.numofstep % 5 == 0) {
					slenderman.randomTeleport();
				} else {
					// System.out.println(player.getPosition());
					slenderman.relativeTeleport(player.getPosition());
				}

			}

			Map.writeMapConsole();
			// System.out.println(JSlenderMath.manhattanDistance(slenderman.getPosition(),
			// player.getPosition()));
			if (slenderman != null && JSlenderMath.manhattanDistance(slenderman.getPosition(), player.getPosition()) == 0) {
				System.out.println("Vesztettél a Slnderman elkapott");
				gameStopped = true;
			}

			// System.out.println(Slenderman.nearToPlayer);
		}

		System.out.println("Játék leállt!");

	}

	public void help() {

		System.out.println(
				" w - 1 lépés előre \n s - 1 lépés hátra \n d - 1 lépés jobbra \n a - 1 lépés balra \n help - parancsok \n exit|stop - kilépés");

	}

}
