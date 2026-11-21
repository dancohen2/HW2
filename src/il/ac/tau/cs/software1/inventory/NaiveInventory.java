package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;
	private Collectible[] collectibles;
	private int itemsCounter;

	public NaiveInventory() {
		this.collectibles = new Collectible[INITIAL_CAPACITY];
		this.itemsCounter = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		if (itemsCounter == collectibles.length) {
			Collectible[] newCollectibles = new Collectible[collectibles.length * 2];
			for (int i = 0; i < collectibles.length; i++) {
				newCollectibles[i] = collectibles[i];
			}
			collectibles = newCollectibles;
		}

		collectibles[itemsCounter] = collectible;
		itemsCounter++;
	}

	@Override
	public float getTotalWeight() {
		float sumWeight = 0;
		for(int i = 0; i < itemsCounter; i++)
			sumWeight += collectibles[i].getWeight();
		return sumWeight;
	}

	@Override
	public int getCurrentCount() {
		return itemsCounter;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return collectibles;
	}
}
