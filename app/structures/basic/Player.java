package structures.basic;

/**
 * A basic representation of of the Player. A player
 * has health and mana.
 * 
 * @author Dr. Richard McCreadie
 *
 */
public class Player {

	int health;
	int mana;
	private Unit avatar;
	private int artifactRobustness = 0; // 0 means no artifact is equipped
    private boolean hasArtifact = false;
//	private int id;
	
	public Player() {
		super();
		this.health = 20;
		this.mana = 0;
	}
	public Player(int health, int mana) {
		super();
		this.health = health;
		this.mana = mana;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}

    public Unit getAvatar() {
		return avatar;
    }

	public void setAvatar(Unit avatar) {
		this.avatar = avatar;
	}
	
	public void equipArtifact(int robustness) {
        this.artifactRobustness = robustness;
        this.hasArtifact = true;
    }

    public void takeDamage(int damage) {
        // Reduce avatar's health
        this.health -= damage;

        // If an artifact is equipped, decrease its robustness
        if (hasArtifact) {
            artifactRobustness--;

            // Check if the artifact is destroyed
            if (artifactRobustness <= 0) {
                hasArtifact = false; // Remove the artifact
                artifactRobustness = 0;
            }
        }
    }

    public boolean hasArtifact() {
        return hasArtifact;
    }

    public int getArtifactRobustness() {
        return artifactRobustness;
    }

}

