import java.util.*;
public class simulation {
	LinkedBlockingQueue landingQ,takeOffQ;
    Random rnd;
    airplane tmp;
    boolean runwayFree;
    int landed=0,tookOff=0,leftLand,leftTake,minutes,minToLand,
    	minToTake,interval=0,landSum=0,takeSum=0, planeIDLanding = 1, planeIDTakeOff = 2, temp;
    double avgLand,avgTake;
    
    // constructor
    public simulation(int minutesIn, int minToLandIn,int minToTakeIn) 
    {
        minutes = minutesIn;

        minToLand = minToLandIn;
        minToTake = minToTakeIn;
        landingQ = new LinkedBlockingQueue();
        takeOffQ = new LinkedBlockingQueue();
    } 
    
   
    int i =0;
    public void AirportSim() {
        rnd = new Random();
        while(interval <= minutes){
            temp = rnd.nextInt(4);
            //int randNum = rand.nextInt(4);
            //System.out.println(interval);
            if(landingQ.size() <= temp + 2) //+2 is arbitrary, but allows for the queues not to get overloaded
            {
            	while(i < temp)
            	{
                landingQ.add(new airplane(interval));
                i++;
            	}
                //System.out.println(temp);
            	
                //System.out.println(interval);
                //System.out.println(randNum);
                landed++;

            	System.out.println("The Landing Queue is: " + landingQ.size());
                System.out.println("The Take off Queue is: " + takeOffQ.size());
                System.out.println(interval + " minutes have passed:" + " Plane " + planeIDLanding + " is cleared to land");
            	planeIDLanding+=2;
                System.out.println();
                //System.out.println(temp);

                
            }
            int j = 0;
            temp = rnd.nextInt(4);
            if(takeOffQ.size() <= temp + 2)
            {
            	while(j < temp)
            	{
                takeOffQ.add(new airplane(interval));
                j++;
            	}
                //takeOffQ.add(new airplane(temp));
                tookOff++;

                //takeOffQ.add(new airplane(interval));
            	System.out.println("The Landing Queue is: " + landingQ.size());
                System.out.println("The Take off Queue is: " + takeOffQ.size());
                System.out.println(interval + " minutes have passed:" + " Plane " + planeIDTakeOff + " is cleared to take off");
            	planeIDTakeOff+=2;
                System.out.println();
                //System.out.println(takeOffQ.size());

            }
            
 
            
            if(!landingQ.isEmpty() && (takeOffQ.isEmpty()))
            {
                landSum += interval - ((airplane)landingQ.front()).getStart();
                landingQ.remove();
                interval += minToLand;
                
                
                //System.out.println(landSum);
            }
            else if((landingQ.isEmpty()) && (!takeOffQ.isEmpty()))
            {
                takeSum += interval - ((airplane)takeOffQ.front()).getStart();
                takeOffQ.remove();
                interval += minToTake;
                //System.out.println(takeOffQ.size());

                //System.out.println(takeSum);

            }
            else if((landingQ.isEmpty()) && (takeOffQ.isEmpty()))
            {
            	System.out.println("The Landing Queue is: " + landingQ.size());
                System.out.println("The Take off Queue is: " + takeOffQ.size());
                interval++;
            } 
            
            else if((!landingQ.isEmpty()) && (!takeOffQ.isEmpty()))
            {
            	if((landingQ.size() > takeOffQ.size()) || (landingQ.size() == takeOffQ.size()))
            	{
            		landSum += interval - ((airplane)landingQ.front()).getStart();
                    landingQ.remove();
                    interval += minToLand;
            	}
            	else if (landingQ.size() < takeOffQ.size())
            	{
            		  takeSum += interval - ((airplane)takeOffQ.front()).getStart();
                      takeOffQ.remove();
                      interval += minToTake;
            	}
            }
//            else
//            {
//            	landSum += interval - ((airplane)landingQ.front()).getStart();
//                landingQ.remove();
//                interval += minToLand;
//                
//            }
        } 
        leftLand = landingQ.size();
        leftTake = takeOffQ.size();
        if(landed == 0)
            avgLand = 0;
        else
            avgLand = landSum/landed;
        if(tookOff == 0)
            avgTake = 0;
        else
            avgTake = takeSum/tookOff;
    } 
    
  
    public String getResults() {
        return "Airplanes that landed: "+landed+"\nAirplanes that took off: "+tookOff+
        	"\nAverage wait time to land: "+avgLand+"\nAverage wait time to take off: "+
        	avgTake+"\nPlanes left in landing queue: "+leftLand+"\nPlanes left in take off queue: "+
        	leftTake;
    }
}
