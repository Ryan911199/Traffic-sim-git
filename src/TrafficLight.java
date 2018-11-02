import java.util.Random;

class TrafficLight{
    public TrafficLight(){
        int Time = 7;
        printLight intersection = new printLight();
        boolean Running = true;
        int numOfCars = 5;
        boolean nsLight = false;
        boolean ewLight = false;
        Vehicle[] NS = new Vehicle[5];
        Vehicle[] SN = new Vehicle[5];
        Vehicle[] WE = new Vehicle[5];
        Vehicle[] EW = new Vehicle[5];
        fillLight(numOfCars, NS);
        fillLight(numOfCars, SN);
        fillLight(numOfCars, WE);
        fillLight(numOfCars, EW);
        intersection.print(nsLight, NS, SN, WE, EW);
        while (Running == true) {
	        Run(nsLight, Time, NS, SN);
	        intersection.print(nsLight, NS, SN, WE, EW);
	        if (noVehicle(NS, SN, WE, EW)) {
		        break;
	        }
//	        if (emergency(NS, SN, WE, EW)){
//	        	//TODO
//	        }
	        Running = false;
        }
        Running = false;
    }
    public void fillLight(int numOfCars, Vehicle[] NS) {
        Random rand = new Random();
        numOfCars--;
        int num = 0;
        while (0 <= numOfCars) {
            num = rand.nextInt(3) + 1;
            switch (num) {
                case 1:
                    Car C = new Car();
                    NS[numOfCars] = C;
                    break;
                case 2:
                    Truck T = new Truck();
                    NS[numOfCars] = T;
                    break;
                case 3:
                    Semi S = new Semi();
                    NS[numOfCars] = S;
                    break;
                default:
                    System.out.println("there was a problem");
                    break;
            }
            numOfCars--;
        }
        return;
    }
    public Vehicle addCar(){
	    Random rand = new Random();
	    int num;
	    num = rand.nextInt(4) + 1;
	    switch (num) {
		    case 1:
			    return new Car();
		    case 2:
			    return new Truck();
		    case 3:
			    return new Semi();
		    case 4:
			    return new Emergency();
		    default:
			    System.out.println("there was a problem");
			    return null;
	    }
    }
    public boolean noVehicle(Vehicle[] NS, Vehicle[] SN, Vehicle[] WE, Vehicle[] EW){
        int T = 0;
        int F = 4;
        Object[] C = NS;
        int J = 0;
        for (int i = 4; i > 0; i--) {
            for (int x = 0; x <= 4; x++){
                if (C[x]== null){
                    T++;
                }
            }
            J++;
            if (J == 1){
                C = SN;
            }
            else if (J == 2){
                C = WE;
            }
            else if (J == 3){
                C = EW;
            }
        }
        if (T >= F){
            System.out.println("you are amazing");
            return true;
        }
        else {return false;}
    }
    public boolean emergency(Vehicle[] NS, Vehicle[] SN, Vehicle[] WE, Vehicle[] EW){

        Vehicle[] C = NS;
        int J = 0;
        for (int i = 4; i > 0; i--) {
            for (int x = 0; x <= 4; x++)
                if (C[x].equals(" ")) { }
                else if (C[x].toString().equals("E")){
                    System.out.println("success");
                    return true;
                }
            J++;
            if (J == 1){
                C = SN;
            }
            else if (J == 2){
                C = WE;
            }
            else if (J == 3){
                C = EW;
            }
        }
        return false;
    }
    public void moveEmergency(Vehicle[] NS, Vehicle[] SN, Vehicle[] WE, Vehicle[] EW){

    }
    public void Run(Boolean nsLight, int Time, Vehicle[] NS, Vehicle[] SN){
        int time = Time;
        int comp1 = 0;
        int comp2 = 0;
        int i = 0;
        int j = 0;
        while (time > 0) {
            if (NS[0] == null) {comp1 = 0;}
            else {comp1 = NS[0].getTime();}
            if (SN[0] == null){comp2 = 0;}
            else {comp2 = SN[0].getTime();}
            if (comp1 == 0 && comp2 == 0){return;}
            else if (comp1 > comp2 ){time = time - comp1;}
            else if (comp2 > comp1){time = time - comp1;}
            else {time = time - comp1;}
            SN[0] = SN[1];
            SN[1] = SN[2];
            SN[2] = SN[3];
            SN[3] = SN[4];
            SN[4] = null;
            NS[0] = NS[1];
            NS[1] = NS[2];
            NS[2] = NS[3];
            NS[3] = NS[4];
            NS[4] = null;
        }
	    if (comp1 != 0) {
		    while (NS[i] != null) {
			    i++;
		    }
		    NS[i] = addCar();
	    }
	    if (comp2 != 0) {
		    while (SN[j] != null) {
			    j++;
		    }
		    SN[j] = addCar();
	    }
    }

}