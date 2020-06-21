
public class CSOMain {

	public static void main(String[] args) {
		
		Worker worker = new Worker();
		
		Employee plovdiv = new CityEmployee();
		Employee bg = new CountryEmployee();
		Employee europe = new InternationalEmployee();
		
		WaitingState wait = new WaitingState();
		
		worker.setName("PT");
		plovdiv.setName("PB");
		bg.setName("BG");
		europe.setName("EU");
		
		plovdiv.setNextEmployee(bg);
		bg.setNextEmployee(europe);
		
		wait.applyState(plovdiv);
		wait.applyState(bg);
		wait.applyState(europe);
		
		plovdiv.subscribe(worker);
		bg.subscribe(worker);
		europe.subscribe(worker);
		
		System.out.println("ORDER 1 - LEVEL 3");
		plovdiv.acceptShipment(3);
		System.out.println("ORDER 2 - LEVEL 2");
		plovdiv.acceptShipment(2);
		System.out.println("ORDER 3 - LEVEL 1");
		bg.acceptShipment(1);
		System.out.println("ORDER 4 - LEVEL 3");
		europe.acceptShipment(3);

	}

}
