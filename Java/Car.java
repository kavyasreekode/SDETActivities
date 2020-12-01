package JavaActivity1;

public class Car {

    String Color;
    int Make;
    String Transmission;
    int Tyres;
    int Doors;
    
     public Car() {
        // Default values to be set
    	Tyres = 4;
    	Doors = 4;
    	}
    
    public void DisplayCharacterstics(){
    	System.out.println("Color of the Car: " +  Color);
    	System.out.println("Car made in : " +  Make);
    	System.out.println("Transmission of the Car: " +  Transmission);
    	System.out.println("Number of doors : " + Doors);
    	System.out.println("Number of tyres : " + Tyres);
        }
    
    public void accelerate(){
    	System.out.println("Car is moving forward.");
        }
    
    public void brake(){
    	System.out.println("Car has stopped.");
        }
}
