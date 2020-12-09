package JavaActivity1_3;

	
		//Abstract class
		abstract class Book {
		    String title;
		    //Abstract method
		    abstract void setTitle(String k);
		    
		    //Concrete method
		    String getTitle() {
		        return title;
		    }
		}

		class MyBook extends Book {
		    //Define abstract method
		    public void setTitle(String k) {
		        title = k;
		    }
		}

		public class Activity2_1 {
		    
		    public static void main(String []args) {
		        //Initialize title of the book
		        String title = "Harry Potter and the Dealthy Hallows";
		        //Create object for MyBook
		        Book newNovel = new MyBook();
		        //Set title
		        newNovel.setTitle(title);
		        
		        //Print result
		        System.out.println("The title is: " + newNovel.getTitle());
		    }
		}
