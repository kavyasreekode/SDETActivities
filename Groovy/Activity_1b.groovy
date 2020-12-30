package APIActivities

class Activity_1b {
	
	public static void main(def args) {
		
		File file = new File("src/input.txt");
		file.createNewFile();
		
		def inputText = "A quick brown Fox jumped over the lazy Cow\nJohn Jimbo jingeled happily ever after\nTh1\$ 1\$ v3ry c0nfus1ng"
		
		file.write(inputText);
		
		println "Match Operations:"
		
		//printing line ends with Cow
		file.eachLine {line ->
			if(line ==~ /^.*Cow$/) {
			println "$line"
		}
		}
		//printing line starts with J
		file.eachLine {line ->
			if(line ==~ /^J.*/) {
			println "$line"
		}
		}
		
		//printing line that has one number 
		file.eachLine {line ->
			if(line ==~ /.*\d.*/) {
			println "$line"
		}
		}
		
		//printing line that has two numbers one after the other
		file.eachLine {line ->
			if(line ==~ /.*\d\d.*/) {
			println "$line"
		}
		}
		
		println "\nFind Operations:"
		
		//Find string \S+er
       def match1 = file.getText() =~ /\S+er/
	   println "${match1.findAll()}"
		
	   //Find string \S*\d\W
	   def match2 = file.getText() =~ /\S*\d\W/
	   println "${match2.findAll()}"
	
		
}

}