import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Pilot extends Employee {

	public Pilot(String _name, Seat _seat, double _salary) {
		super(_name, _seat, _salary);
		
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pilot)) {
			return false;
		}

		Pilot newPilot = (Pilot) obj;

		if (this.name.equals(newPilot.getName())) {
			return true;
		}

		return false;
	}
	
	@Override
	public String toString(){
		
//		DecimalFormat formatter = new DecimalFormat("#,###.00");
//		String sumValue = "$  " + formatter.format(salary);
		
		
//		DecimalFormat formatter = new DecimalFormat("#,###.00");
//		String salaryValue = formatter.format(salary);
//		
		return String.format("%-20s", getName()) + " | " + getSeat() + " | " + "$" + String.format("%10s", String.format("%,.2f", getSalary()));
		
	}
}
