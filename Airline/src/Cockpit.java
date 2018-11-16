
public class Cockpit extends Seat {

	protected Cockpit() {
		super("Cockpit");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cockpit) {
			return true;
		}
		return false;
	}

	public String toString(){
		return getLocation();
	}
}
