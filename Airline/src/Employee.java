import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Employee extends Traveler {
	protected double salary;
	
	public Employee(String _name, Seat _seat, double _salary) {
		super(_name, _seat);
		salary = _salary;
	}

	public double getSalary(){
		return salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Employee)) {
			return false;
		}

		Employee newEmployee = (Employee) obj;

		if (this.name.equals(newEmployee.getName()) && this.salary == newEmployee.getSalary()) {
			return true;
		}

		return false;
	}
	
	@Override
	public String toString(){
		
		DecimalFormat formatter = new DecimalFormat("#,###.00");
		String sumValue = "$" + formatter.format(salary);
		
//		DecimalFormat dFormat = new DecimalFormat("#.00");
//		String sumValue = "$ " + dFormat.format(salary);
		
		
		return super.toString() + " | " + sumValue;
	}
}
