
public class airport_main {

	public static void main(String[] args) {
		   simulation sim = new simulation(120,5,5);
		   sim.AirportSim();
		   //System.out.println(plane.getStart());
		   System.out.println(sim.getResults());
	}

}
