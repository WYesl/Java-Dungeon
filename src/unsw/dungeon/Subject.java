package unsw.dungeon;

public interface Subject {
	public void registerObserver(EnemyObserver o);
	public void registerObserver(GoalObserver o);
	public void removeObserver(EnemyObserver o);
	public void removeObserver(GoalObserver o);
	public void notifyEnemyObservers();
	public void notifyGoalObservers();
}
