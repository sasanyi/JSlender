package characters;

public interface Character {
	// Move methods
	boolean move(int shiftx, int shifty);

	boolean moveAsX(int shift);

	boolean moveAsY(int shift);

	boolean movable();

	void spawn();

	String getName();

	String setName();
}
