package characters;

import map.MapObjects;

public class Player extends MapObjects implements Character {
	public static int numofstep = 0;

	public Player() {
		this.height = 1;
		this.width = 1;

		this.obstace = false;

		this.seeable = true;

		this.mark = "P";

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

		if (this.updatePosition(oldPosition, this.position, this)) {
			return true;
		}
		this.position = oldPosition;
		return false;
	}

	@Override
	public boolean moveAsX(int shift) {
		int oldPosX = position.getX();
		int oldPosY = position.getY();
		// System.out.println(oldPosX+";"+oldPosY);
		Position oldPosition = new Position(oldPosX, oldPosY);
		int newPosX = oldPosX + shift;
		position.setX(newPosX);
		// System.out.println(this.position.getX()+";"+this.position.getY());
		if (this.updatePosition(oldPosition, this.position, this)) {
			return true;
		}
		this.position = oldPosition;
		return false;
	}

	@Override
	public boolean moveAsY(int shift) {
		int oldPosX = position.getX();
		int oldPosY = position.getY();
		Position oldPosition = new Position(oldPosX, oldPosY);
		int newPosY = oldPosY + shift;
		position.setY(newPosY);
		if (this.updatePosition(oldPosition, this.position, this)) {
			return true;
		}
		this.position = oldPosition;
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
		this.setPosition(1, 15);
	}

}
