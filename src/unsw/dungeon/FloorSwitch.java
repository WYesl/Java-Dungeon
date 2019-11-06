package unsw.dungeon;

import java.util.List;

public class FloorSwitch extends Entity implements GoalObserver {
	
	private Dungeon dungeon;
	private Player player;
	private boolean on;  // doesn't do anything yet.
	
	/**
	 * 
	 * @param dungeon
	 * @param x
	 * @param y
	 * @param movement
	 */
	public FloorSwitch(Dungeon dungeon, int x, int y, Movement movement) {
		super(x, y, movement);
		this.dungeon = dungeon;
		this.player = null;
		this.on = checkOnOff();
		
	}
	
	/**
	 * register - registers the switch to an observer.
	 */
	public void register() {
		this.player = dungeon.getPlayer();
    	player.registerObserver(this);
    	startingGoal(player.getGoals());
    }
	
	/**
	 * startGoal - runs at the start of the dungeon, and reduces goal of switch activations
	 * by 1 if a switch is already on.
	 * @param goals - the player's goal.
	 */
	private void startingGoal(PlayerGoal goals) { 
		// only run at the start, if the switch starts on, then it reduces goal by 1.
		if (this.on == true) {
			goals.addComplete("switch");
		}
	}
	
	/**
	 * @return true if floor switch is triggered, false if not
	 */
	public boolean checkOnOff() {  
		List<Entity> entities = dungeon.getCurrentEntity(this.getX(), this.getY());
		for (Entity entity : entities) {
			if (entity instanceof Boulder) {
				// System.out.println("There is a boulder now");
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void update(PlayerGoal goals, int[] playerXY) {
		boolean prevOn = this.on;
		this.on = checkOnOff();
		if (prevOn != on && on == true) {
			goals.addComplete("switch");
		} else if (prevOn != on && on == false) {
			goals.removeComplete("switch");
		}
		
	}

	
	
}
