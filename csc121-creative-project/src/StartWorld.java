import processing.core.PApplet;
import processing.event.KeyEvent;

public class StartWorld implements IWorld{

	@Override
	public PApplet draw(PApplet w) {
		w.background(173, 216, 230);
		w.textSize(25);
		w.fill(0);
		w.text("Press spacebar to start", 180, 180);
		return w;
	}

	@Override
	public IWorld update() {
		return this;
	}

	@Override
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == ' ')
		{
			//(Math.random() * ((max - min) + 1)) + min;
			Apple apple = new Apple(
					new Posn( (float)  (Math.random() * ((540 - 60) + 1)) + 60, 
							(float) (Math.random() * ((540 - 60) + 1)) + 60));
			Posn mid = new Posn(200/2, 200/2);
			PosnList segs = new PosnList().append(mid)
			                    .append(mid.translate(SnakeWorld.LEFT))
			                    .append(mid.translate(SnakeWorld.LEFT).translate(SnakeWorld.LEFT));
			return new SnakeWorld(new Snake(segs), apple);
		} else 
		{
			return this;
		}
		
	}
	
	@Override 
	public IWorld gameOver()
	{
		return this; 
	}

}