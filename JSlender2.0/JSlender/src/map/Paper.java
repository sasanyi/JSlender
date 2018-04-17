package map;

import java.util.*;

import characters.Position;

public class Paper extends MapObjects {
	public static int numOfFoundPapers = 0;
	public static List<String> papers = new ArrayList<String>();

	public Paper() {
		this.height = 1;
		this.width = 1;

		this.obstace = false;

		this.seeable = true;

		this.mark = "C";
	}

	public static void addPaper(Position paperPos) {
		String pos = paperPos.getX() + ";" + paperPos.getY();
		papers.add(pos);
		Paper p = new Paper();
		p.setPosition(paperPos.getX(), paperPos.getY());
	}

	public static boolean findPaper(Position playerPos) {
		String possiblePos = playerPos.getX() + ";" + playerPos.getY();

		if (papers.contains(possiblePos)) {

			return true;

		}
		return false;
	}

}
