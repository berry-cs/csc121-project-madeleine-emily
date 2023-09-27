import java.util.Objects;

import processing.core.PApplet; 

/* 
 * Represents an apple in the Snake game
 */
public class Apple {


	/** the position of the apple */
	Posn loc;
	int size;


	public Apple(Posn loc) {
		this.loc = loc;
		this.size = 30;
	}

	/* draws the apple */
	public PApplet draw(PApplet a) {
		a.fill(255, 0, 0);
		a.square((int) this.loc.getX(), (int) this.loc.getY(), size);
		return a;
	}

	/* if the snake eats the apple, then the apple updates to a random location */
	//	public AppleWorld update(SnakeWorld s) {
	//		
	//		if (this.inRange(s.x, s.y, 30))
	//		{
	//			return new AppleWorld(Math.random() * 601, Math.random() * 601);
	//		} 
	//		
	//		else if (this.inRange(s.x + 30, s.y, 30)) {
	//			return new AppleWorld(Math.random() * 601, Math.random() * 601);
	//		}
	//		
	//		else if (this.inRange(s.x, s.y + 30, 30)) {
	//			return new AppleWorld(Math.random() * 601, Math.random() * 601);
	//		}
	//		
	//		else if (this.inRange(s.x + 30, s.y + 30, 30)) {
	//			return new AppleWorld(Math.random() * 601, Math.random() * 601);
	//		}
	//		
	//		else {
	//			return this;
	//		}
	//		
	//	}


	/* if the snake eats the apple, then the apple updates to a random location */
	public Apple update(Snake s) {

		if (this.hitBySnake(s.loc)) {
			return new Apple(
					new Posn((float) Math.random() * 601,
							(float) Math.random() * 601));
		}
		else {
			return this;
		}

	}





	//deterimines if the snake has hit the apple by comparing the apple's lacation to the snake's location
	public boolean hitBySnake(Posn sLoc) 
	{	
		return sLoc.inRange(this.loc, this.size, this.size);

	}


	/* returns the apple's position */
	public Posn getLoc() {
		return loc;
	}

	@Override
	public String toString() {
		return "Apple [loc=" + loc + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(loc, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		return Objects.equals(loc, other.loc) && size == other.size;
	}






}
