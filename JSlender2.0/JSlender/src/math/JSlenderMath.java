package math;

import java.util.Random;

import characters.Position;

public final class JSlenderMath {

	public static final Position manhattanDistancePoint(Position startPoint, int distance) {
		// System.out.println("Teleport");
		int direction = JSlenderMath.randomNum(1, 4);
		Position position = null;
		switch (direction) {
		case 1:
			position = new Position(startPoint.getX() + distance, startPoint.getY());
			break;
		case 2:
			position = new Position(startPoint.getX() - distance, startPoint.getY());
			break;
		case 3:
			position = new Position(startPoint.getX(), startPoint.getY() + distance);
			break;
		case 4:
			position = new Position(startPoint.getX(), startPoint.getY() - distance);
			break;

		}

		// System.out.println(position);
		if (map.Map.isRealPosition(position)) {
			return position;
		} else {
			return JSlenderMath.manhattanDistancePoint(startPoint, distance);
		}
	}

	public static final int manhattanDistance(Position pos1, Position pos2) {
		int x1 = pos1.getX();
		int y1 = pos1.getY();

		int x2 = pos2.getX();
		int y2 = pos2.getY();

		return Math.abs(x1 - x2) + Math.abs(y1 - y2);

	}

	public static final int randomNum(int low, int hight) {
		if (low > hight) {
			throw new IllegalArgumentException("Első paraméter a minimum! A minimum nem lehet nagyobb mint a maximum!");
		}
		Random r = new Random();
		return r.nextInt((hight - low) + 1) + low;
	}

	public static final boolean probabilityOfEvent(int percent) {
		int num = JSlenderMath.randomNum(1, 6);
		if (percent == 50) {
			if (num % 2 == 0) {
				return true;
			}
		} else if (percent == 33) {
			if (num % 3 == 0) {
				return true;
			}
		} else if (percent == 66) {
			if (num > 2) {
				return true;
			}
		}

		return false;
	}

	public static final int max(int a, int b) {
		if (a < b)
			return b;
		return a;
	}
	/*
	 * public static void main(String[] args) { //for(int i = 0; i < 20; i++)
	 * //System.out.println(math.JSlenderMath.max(10, 4)); }
	 */

}
