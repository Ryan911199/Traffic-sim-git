import java.util.Random;

class TrafficLight{
    public TrafficLight(){
        int Time = 7;
        printLight intersection = new printLight();
        boolean Running = true;
        int numOfCars = 5;
        boolean printEmergency = false;
        boolean nsLight = false;
        boolean ewLight = false;
        Vehicle[] NS = new Vehicle[5];
        Vehicle[] SN = new Vehicle[5];
        Vehicle[] WE = new Vehicle[5];
        Vehicle[] EW = new Vehicle[5];
        fillLight(numOfCars, NS, printEmergency);
        fillLight(numOfCars, SN, printEmergency);
        fillLight(numOfCars, WE, printEmergency);
        fillLight(numOfCars, EW, printEmergency);
        printEmergency = true;
        intersection.print(nsLight, NS, SN, WE, EW);
        Run(nsLight, Time, WE, EW);
        intersection.print(nsLight, NS, SN, WE, EW);

        Running = false;
    }
    public void fillLight(int numOfCars, Vehicle[] NS, boolean F) {
        Random rand = new Random();
        numOfCars--;
        int num = 0;
        while (0 <= numOfCars) {
            if (F){num = rand.nextInt(4) + 1;}
            else{num = rand.nextInt(3) + 1;}
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
                case 4:
                    Emergency E = new Emergency();
                    NS[numOfCars] = E;
                    break;
                default:
                    System.out.println("there was a problem");
                    break;
            }
            numOfCars--;
        }
        return;
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
    public void Run(Boolean nsLight, int Time, Vehicle[] NS, Vehicle[] SN){
        int time = Time;
        int comp1;
        int comp2;
        int i = 0;
        int j;
        //this is a test to see if git hub is working
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
        fillLight(1, NS,true);
//        fillLight(1, SN,true);
//        while (i < 4){
//            if (NS[i] == null){
//                NS[i]= NS[0];
//                i--;
//                j = i -1;
//                while(i > 0){
//                    NS[i] = NS
//                }
//
//                break;
//            }
//            i++;
//        }

        if (!nsLight){nsLight = true;}
        else { nsLight = false;}

    }









//    Object[] C = NS;
//    int J = 0;
//        for (int i = 4; i > 0; i--) {
//        for (int x = 0; x <= 4; x++) {
//            C[x] = (" ");
//        }
//        J++;
//        if (J == 1) {
//            C = SN;
//        } else if (J == 2) {
//            C = WE;
//        } else if (J == 3) {
//            C = EW;
//        }
//    }
//        intersection.print(nsLight, ewLight, NS, SN, WE, EW);
//    Boolean Test = noVehicle(NS, SN, WE, EW);
//        if (Test){
//        System.out.println("this is to easy");
//    }

//    if (emergency(NS, SN, WE, EW)){
//        System.out.println("winning");
//    }
//        else if (!emergency(NS, SN, WE, EW)){
//        System.out.println("this could be good");
//    }
//    Emergency E = new Emergency();
//    NS[1] = E;
//    NS[0] = " ";
//        intersection.print(nsLight, ewLight, NS, SN, WE, EW);
//        if (emergency(NS, SN, WE, EW)){
//        System.out.println("winning");
//    }
//        else if (!emergency(NS, SN, WE, EW)){
//        System.out.println("this is bad");
//    }
}