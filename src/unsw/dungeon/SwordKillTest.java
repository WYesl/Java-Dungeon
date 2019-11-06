package unsw.dungeon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SwordKillTest {

	
	@Test
	// kill enemy with sword 
	// kill max 5 enemy
	// only 5 max swings 
	void testKillEnemysWithSword() {
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 1, 1, new Moveable());
		dungeon.setPlayer(player);
		PlayerGoal gS = new PlayerGoal(player);
		SingleGoal s1 = new SingleGoal("enemy", 7);
		gS.addGoal(s1);
		player.addGoals(gS);
		
		Sword sword = new Sword(dungeon, 1, 2, 1, new Collectable());
		dungeon.addEntity(sword);
		
		Enemy enemy1 = new Enemy(dungeon, 1, 0, new Interactable() );
		dungeon.addEntity(enemy1);
		Enemy enemy2 = new Enemy(dungeon, 0, 2, new Interactable());
		dungeon.addEntity(enemy2);
		Enemy enemy3 = new Enemy(dungeon, 2, 2, new Interactable());
		dungeon.addEntity(enemy3);
		Enemy enemy4 = new Enemy(dungeon, 1, 3, new Interactable());
		dungeon.addEntity(enemy4);
		dungeon.registerNoMove();
		//player starts at 1,1
		
		// Attempts to kill enemy1 so above player with no sword 
		// Should not be able to kill player one 
		// and other players shouldn't die as well
		//System.out.println("--------------Test 1: NO kill if NO Sword----------------");
		assertEquals(player.getSword(), null);
		
		player.attackW();
		//check if enemies are still there
		//System.out.print("Test should NOT kill enemy1: ");
		if (dungeon.isEnemy(1, 0)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(1, 0), true);
		System.out.print("Test should NOT kill enemy2: ");
		if (dungeon.isEnemy(0, 2))System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(0, 2), true);
		System.out.print("Test should NOT kill enemy3: ");
		if (dungeon.isEnemy(2, 2)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(2, 2), true);
		System.out.print("Test should NOT kill enemy4: ");
		if (dungeon.isEnemy(1, 3)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(1, 3), true);
		
		
		//move down to 1,2 
		player.moveDown();
		
		//attempt to kill the enemy with sword should pass
		//kill enemy2 swing left 
		System.out.println("\n--------------Test 2: Kill enemy to the left----------------");
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		player.attackA();
	
		System.out.print("Test should NOT kill enemy1: ");
		if (dungeon.isEnemy(1, 0)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(1, 0), true);
		System.out.print("Test should kill enemy2: ");
		if (!dungeon.isEnemy(0, 2)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(0, 2), false);
		System.out.print("Test should NOT kill enemy3: ");
		if (dungeon.isEnemy(2, 2)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(2, 2), true);
		System.out.print("Test should NOT kill enemy4: ");
		if (dungeon.isEnemy(1, 3)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(1, 3), true);
		//kill enemy3 swing right
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("\n--------------Test 3: Kill enemy to the right----------------");
		player.attackD();
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		
		System.out.print("Test should NOT kill enemy1: ");
		if (dungeon.isEnemy(1, 0)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(1, 0), true);
		System.out.print("Test enemy2 is still dead: ");
		if (!dungeon.isEnemy(0, 2)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(0, 2), false);
		System.out.print("Test should kill enemy3: ");
		if (!dungeon.isEnemy(2, 2)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(2, 2), false);
		System.out.print("Test should NOT kill enemy4: ");
		if (dungeon.isEnemy(1, 3)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(1, 3), true);
		//kill enemy4 swing down
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		
		System.out.println("\n--------------Test 4: Kill enemy below----------------");
		player.attackS();
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		
		System.out.print("Test should NOT kill enemy1: ");
		if (dungeon.isEnemy(1, 0)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(1, 0), true);
		System.out.print("Test enemy2 is still dead: ");
		if (!dungeon.isEnemy(0, 2)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(0, 2), false);
		System.out.print("Test enemy3 is still dead: ");
		if (!dungeon.isEnemy(2, 2)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(2, 2), false);
		System.out.print("Test should kill enemy4: ");
		if (!dungeon.isEnemy(1, 3)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(1, 3), false);
		
		//move up to 1,1
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		
		System.out.println("\n--------------Test 5: Kill enemy above----------------");
		player.moveUp();
		//attempt to kill enemy1
		player.attackW();
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		//check if enemies are still there
		System.out.print("Test should kill enemy1: ");
		if (!dungeon.isEnemy(1, 0)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(1, 0), false);
		System.out.print("Test enemy2 is still dead: ");
		if (!dungeon.isEnemy(0, 2)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(0, 2), false);
		System.out.print("Test enemy3 is still dead: ");
		if (!dungeon.isEnemy(2, 2)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(2, 2), false);
		System.out.print("Test should kill enemy4: ");
		if (!dungeon.isEnemy(1, 3)) System.out.println("PASS");
		else System.out.println("FAIL");
		
		System.out.println("\n--------------Test 6: Kill 5th Enemy and can't kill 6th----------------");
		//then add new enemy 5 and 6
		Enemy enemy5 = new Enemy(dungeon, 2, 1, new Immovable());
		dungeon.addEntity(enemy5);
		Enemy enemy6 = new Enemy(dungeon, 3, 1, new Immovable());
		dungeon.addEntity(enemy6);
		dungeon.registerNoMove();
		// should kill enemy 5 but not enemy 6 as no sword.
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		player.attackD();
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		
		System.out.print("Test should kill enemy5: ");
		if (!dungeon.isEnemy(2, 1)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(2, 1), false);
		System.out.print("Test should NOT kill enemy6: ");
		if (dungeon.isEnemy(3, 1)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(3, 1), true);
		//move right
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		player.moveRight();
		player.attackD();
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		//get current entity in dun should help to see if entity exists
		
		System.out.print("Test enemy5 is still dead: ");
		if (!dungeon.isEnemy(2, 1)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(2, 1), false);
		
		System.out.print("Test should NOT kill enemy6: ");
		if (dungeon.isEnemy(3, 1)) System.out.println("PASS");
		else System.out.println("FAIL");
		assertEquals(dungeon.isEnemy(3, 1), true);
		
		System.out.println("\n--------------Test 7: MAX 5 swings of sword----------------");
		Sword swordNew = new Sword(dungeon, 2, 2, 2, new Collectable());
		dungeon.addEntity(swordNew);
		
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		System.out.println("Pick up sword");
		
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		player.moveDown();
		
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		
		
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		player.attackD();
		System.out.print("After Swing 1: ");
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		player.attackD();
		System.out.print("After Swing 2: ");
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		player.attackD();
		System.out.print("After Swing 3: ");
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		player.attackD();
		System.out.print("After Swing 4: ");
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		
		try
		{
		    Thread.sleep(400);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		player.attackD();
		System.out.print("After Swing 5: ");
		if (player.getSword() == null) System.out.println("I have NO sword");
		if (player.getSword() != null) System.out.println("I have sword ");
		assertEquals(player.getSword(), null);
	}
}