package cannonsimulator;

import java.util.Random;

public class random {

	 private Random rand = new Random(); 
	 private int x;
	 
	 
     public int random(){
    	
    	 x = rand.nextInt(2000);
    	 return x;
     }
     
     public int randoms(){
     	
    	 x = rand.nextInt(20);
    	 return x;
     }
}
