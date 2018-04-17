package map;

import java.util.*;


import characters.Position;
import math.JSlenderMath;

public class Map {
	private static MapObjects[][] map = new MapObjects[15][15];
	private static int mapWidth = 15;
	private static int mapHeight = 15;
	private static ArrayList<MapObjects> objects = new ArrayList<>();
	static {

		for (int y = 0; y < mapHeight; y++) {
			for (int x = 0; x < mapWidth; x++) {
				Grass g = new Grass();
				map[y][x] = g;

			}
		}

	}

	public static int getMapWidth() {
		return mapWidth;
	}

	public static void setMapWidth(int mapWidth) {
		Map.mapWidth = mapWidth;
	}

	public static int getMapHeight() {
		return mapHeight;
	}

	public static void setMapHeight(int mapHeight) {
		Map.mapHeight = mapHeight;
	}

	public Map() {
		
		objects.add(new House());
		objects.add(new Tree());
		objects.add(new BigTree());
		
		Map.mapRender();
	}

	public static void mapRender() {
		
		Iterator<MapObjects> iterator = objects.iterator();
		while(iterator.hasNext()) {
			MapObjects actObj = iterator.next();
			int height = actObj.getHeight();
			int width = actObj.getWidth();
			int x = JSlenderMath.randomNum(0, 14-width);
			int i = JSlenderMath.randomNum(0, 14-height);
			if(isRealPosition(i,x)) {
				if(actObj instanceof House) {
					int walls = JSlenderMath.randomNum(2, 4);
					for(int c = 0; c < height; c++) {
						for(int d = 0; d < width; d++) {
							if((c == 0 && (d == 1 || d == width-2)) || (c == height-1 && (d == 1 || d == width-2))){
								actObj = new Door();
							}else if((c == 0 || c == height-1) || (d == 0 || d == width-1 || d == walls)) {
								actObj = new Wall();
							}else {
								actObj = new House();
							}
							map[i+c][x+d] = actObj;
							//System.out.println(i+c);
						}
					}
					
				}else {
					for(int c = 0; c < height; c++) {
						for(int d = 0; d < width; d++) {
							map[i+c][x+d] = actObj;
							//System.out.println(i+c);
						}
					}
				}
			}
		}	
	}

	public static boolean updateMap(int x, int y, MapObjects ob) {
		try {
			map[y - 1][x - 1] = ob;
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public static boolean updateMap(Position pos, MapObjects ob) {
		int x = pos.getX();
		int y = pos.getY();
		try {
			map[y - 1][x - 1] = ob;
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public static void writeMapConsole() {
		for (int y = 0; y < mapHeight; y++) {
			for (int x = 0; x < mapWidth; x++) {
				System.out.print(map[y][x].getMark() + "  ");

			}

			System.out.print("\n");
		}

	}

	public static boolean isRealPosition(Position pos) {
		if ((pos.getX() > mapWidth || pos.getX() < 1) || (pos.getY() > mapHeight || pos.getY() < 1) || map[pos.getY()-1][pos.getX()-1].obstace) {
			return false;
		}

		return true;
	}
	
	public static boolean isRealPosition(int i, int x) {
		if ((x > mapWidth-1 || x < 0) || (i > mapHeight-1 || i < 0) || map[i][x].obstace) {
			return false;
		}

		return true;
	}

	public static MapObjects getMapObject(Position pos) {
		int posx = pos.getX() - 1;
		int posy = pos.getY() - 1;

		return Map.map[posy][posx];
	}

}
