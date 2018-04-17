package map;

import characters.Position;
import characters.Slenderman;

public class MapObjects {
	public Position position = new Position(0, 0);
	protected int width;
	protected int height;
	protected String mark;
	protected boolean obstace;
	protected boolean seeable;
	protected boolean slenderman = false;
	// public static int id = 0;

	int getWidth() {
		return this.width;

	}

	int getHeight() {
		return this.height;
	}

	String getMark() {
		return this.mark;
	}

	public Position getPosition() {
		return this.position;
	}

	boolean isObstace() {
		return this.obstace;
	}

	boolean isSeeable() {
		return this.seeable;
	}

	public void setPosition(int x, int y) {
		this.position.setX(x);
		this.position.setY(y);
		Map.updateMap(x, y, this);
	}

	public boolean updatePosition(Position oldpos, Position pos, MapObjects obj) {
		if(Map.isRealPosition(pos)) {
			if (obj instanceof Slenderman) {
				MapObjects slendermanOn = ((Slenderman) obj).getSlendermanOn();
				Map.updateMap(oldpos, slendermanOn);
				((Slenderman) obj).setSlendermanOn(Map.getMapObject(pos));
			} else {
				Map.updateMap(oldpos, new Grass());
				
			}
	
			if (Map.updateMap(pos, obj)) {
				return true;
			} else {
				Map.updateMap(oldpos, obj);
				return false;
			}
		}else {
			return false;
		}
	}

}
