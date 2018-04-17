package characters;

import java.util.Random;

import map.Map;
import map.MapObjects;
import map.Paper;
import math.JSlenderMath;

public class Slenderman extends MapObjects implements Character {
	public static int nearToPlayer = 0;
	private MapObjects slendermanOn;
	private int startCountFrom = 0;

	public MapObjects getSlendermanOn() {
		return slendermanOn;
	}

	public void setSlendermanOn(MapObjects slendermanOn) {
		this.slendermanOn = slendermanOn;
	}

	public Slenderman() {
		this.height = 1;
		this.width = 1;

		this.obstace = false;

		this.seeable = true;

		this.mark = "S";
		this.position = new Position(1,1);
	}

	public Position randomTeleport() {
		int oldPosX = position.getX();
		int oldPosY = position.getY();

		Random r = new Random();
		int Low = 1;
		int High = 15;
		int randomX = r.nextInt(High - Low) + Low;
		int randomY = r.nextInt(High - Low) + Low;
		this.move(randomX - oldPosX, randomY - oldPosY);

		// System.out.println("A slenderman pozicioja: "+this.position);
		return this.position;
	}

	public Position relativeTeleport(Position playerPosition) {
		if (Paper.numOfFoundPapers < 2) {
			int oldPosX = this.position.getX();
			int oldPosY = this.position.getY();
			// System.out.println((Map.getMapWidth()-oldPosX)+":"+(Map.getMapHeight()-oldPosY));
			// System.out.println(JSlenderMath.max(Map.getMapWidth()-playerPosition.getX(),
			// Map.getMapHeight()-playerPosition.getY())+"\n");
			int distance = JSlenderMath.randomNum(5, JSlenderMath.max(Map.getMapWidth() - playerPosition.getX(),
					Map.getMapHeight() - playerPosition.getY()));
			Position oldPosition = new Position(oldPosX, oldPosY);

			Position newPosition = JSlenderMath.manhattanDistancePoint(playerPosition, distance);
			this.position = newPosition;
			this.updatePosition(oldPosition, newPosition, this);

		} else if (Paper.numOfFoundPapers >= 2 && Paper.numOfFoundPapers < 4) {

			int oldPosX = this.position.getX();
			int oldPosY = this.position.getY();
			// System.out.println((Map.getMapWidth()-oldPosX)+":"+(Map.getMapHeight()-oldPosY));
			// System.out.println(JSlenderMath.max(Map.getMapWidth()-playerPosition.getX(),
			// Map.getMapHeight()-playerPosition.getY())+"\n");
			//int distance = 1;
			int distance = JSlenderMath.randomNum(1, 5);
			Position newPosition = JSlenderMath.manhattanDistancePoint(playerPosition, distance);

			if (distance == 1 && startCountFrom == 0) {
				Slenderman.nearToPlayer++;
				startCountFrom = Player.numofstep;
			}
			if (distance == 1 && (startCountFrom - Player.numofstep) <= 2) {
				Slenderman.nearToPlayer++;
				System.out.println(Slenderman.nearToPlayer);
			} else {

				startCountFrom = 0;
				Slenderman.nearToPlayer = 0;
			}

			if (Slenderman.nearToPlayer == 3) {
				if (JSlenderMath.probabilityOfEvent(33)) {
					newPosition = playerPosition;
					Slenderman.nearToPlayer = 0;
				} else {
					Slenderman.nearToPlayer = 0;

				}
			}
			Position oldPosition = new Position(oldPosX, oldPosY);

			this.position = newPosition;
			this.updatePosition(oldPosition, newPosition, this);

		} else if (Paper.numOfFoundPapers >= 4 && Paper.numOfFoundPapers < 6) {
			int oldPosX = this.position.getX();
			int oldPosY = this.position.getY();
			// System.out.println((Map.getMapWidth()-oldPosX)+":"+(Map.getMapHeight()-oldPosY));
			// System.out.println(JSlenderMath.max(Map.getMapWidth()-playerPosition.getX(),
			// Map.getMapHeight()-playerPosition.getY())+"\n");
			int distance = JSlenderMath.randomNum(1, 4);
			Position newPosition = JSlenderMath.manhattanDistancePoint(playerPosition, distance);
			if (distance == 1 && startCountFrom == 0) {
				Slenderman.nearToPlayer++;
				startCountFrom = Player.numofstep;
			}
			if (distance == 1 && (startCountFrom - Player.numofstep) <= 2) {
				Slenderman.nearToPlayer++;
			} else {

				startCountFrom = 0;
				Slenderman.nearToPlayer = 0;
			}

			if (Slenderman.nearToPlayer == 3) {
				if (JSlenderMath.probabilityOfEvent(50)) {
					newPosition = playerPosition;
					Slenderman.nearToPlayer = 0;
				} else {
					Slenderman.nearToPlayer = 0;

				}
			}
			Position oldPosition = new Position(oldPosX, oldPosY);

			this.position = newPosition;
			this.updatePosition(oldPosition, newPosition, this);
		} else if (Paper.numOfFoundPapers >= 6) {
			int oldPosX = this.position.getX();
			int oldPosY = this.position.getY();
			// System.out.println((Map.getMapWidth()-oldPosX)+":"+(Map.getMapHeight()-oldPosY));
			// System.out.println(JSlenderMath.max(Map.getMapWidth()-playerPosition.getX(),
			// Map.getMapHeight()-playerPosition.getY())+"\n");
			int distance = JSlenderMath.randomNum(1, 3);
			Position newPosition = JSlenderMath.manhattanDistancePoint(playerPosition, distance);

			if (distance == 1 && startCountFrom == 0) {
				Slenderman.nearToPlayer++;
				startCountFrom = Player.numofstep;
			}
			if (distance == 1 && (startCountFrom - Player.numofstep) <= 2) {
				Slenderman.nearToPlayer++;
			} else {

				startCountFrom = 0;
				Slenderman.nearToPlayer = 0;
			}

			if (Slenderman.nearToPlayer == 3) {
				if (JSlenderMath.probabilityOfEvent(66)) {
					newPosition = playerPosition;
					Slenderman.nearToPlayer = 0;
				} else {
					Slenderman.nearToPlayer = 0;

				}
			}
			Position oldPosition = new Position(oldPosX, oldPosY);

			this.position = newPosition;
			this.updatePosition(oldPosition, newPosition, this);
		}

		return this.position;
	}

	@Override
	public boolean move(int shiftx, int shifty) {
		int oldPosX = position.getX();
		int oldPosY = position.getY();
		Position oldPosition = new Position(oldPosX, oldPosY);
		int newPosX = oldPosX + shiftx;
		int newPosY = oldPosY + shifty;

		position.setX(newPosX);
		position.setY(newPosY);

		this.updatePosition(oldPosition, this.position, this);
		return false;
	}

	@Override
	public boolean moveAsX(int shift) {
		int oldPosX = position.getX();
		int oldPosY = position.getY();
		Position oldPosition = new Position(oldPosX, oldPosY);
		int newPosX = oldPosX + shift;
		position.setX(newPosX);
		this.updatePosition(oldPosition, this.position, this);
		return false;
	}

	@Override
	public boolean moveAsY(int shift) {
		int oldPosX = position.getX();
		int oldPosY = position.getY();
		Position oldPosition = new Position(oldPosX, oldPosY);
		int newPosY = oldPosY + shift;
		position.setY(newPosY);
		this.updatePosition(oldPosition, this.position, this);
		return false;
	}

	@Override
	public boolean movable() {
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void spawn() {
		this.slendermanOn = Map.getMapObject(new Position(1, 1));
		this.setPosition(1, 1);
	}

}
