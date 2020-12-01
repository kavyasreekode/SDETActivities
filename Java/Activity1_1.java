package JavaActivity1;

public class Activity1_1 {

	public static void main(String[] args) {

		Car Toyota = new Car();
		Toyota.Make = 2014;
		Toyota.Color = "Black";
		Toyota.Transmission = "Manual";
		
		Toyota.DisplayCharacterstics();
        Toyota.accelerate();
        Toyota.brake();
			
	}

}
