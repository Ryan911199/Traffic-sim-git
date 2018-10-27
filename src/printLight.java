public class printLight {

    public void print(boolean nsLight, Vehicle[] NS, Vehicle[] SN, Vehicle[] WE, Vehicle[] EW){
        if (nsLight == false){
            System.out.println("NS Light: Red");
            System.out.println("EW Light: Green");
        }
        else {
            System.out.println("NS Light: Greed");
            System.out.println("EW Light: Red");
        }

        printNS(NS);
        printLightLeft(WE);
        printLightRight(EW);
        printLightBottom(SN);
    }
    public void printNS(Vehicle[] NS){

        int i = 4;
        while (i > 0){
            if (NS[i] != null){System.out.println("            |  " + NS[i] + "  |         ");}
            else {System.out.println("            |  " + " " + "  |         ");}
            i--;
        }
        if (NS[i] != null) {System.out.println("------------|  " + NS[i] + "  |-------------");}
        else {System.out.println("------------|  " + " " + "  |-------------");}
    }
    public void printLightLeft(Vehicle[] WE){
        int i = 4;
        System.out.print("  ");
        while (i >= 0){
            if (WE[i] != null) {System.out.print(WE[i] + " "); }
            else {System.out.print("  ");}
            i--;
        }
    }
    public void printLightRight(Vehicle[] EW){
        System.out.print("        ");
        int i = 0;
        while (i < 5){
            if (EW[i] != null) {
                System.out.print(EW[i] + " ");
            }
            else {System.out.print("  ");}
            i++;
        }
        System.out.println("");
    }
    public void printLightBottom(Vehicle[] SN){
        if (SN[0] != null) {System.out.println("------------|  " + SN[0] + "  |-------------");}
        else {System.out.println("------------|  " + " " + "  |-------------");}
        int i = 1;
        while (i < 5){
            if (SN[i] != null) {System.out.println("            |  " + SN[i] + "  |         ");}
            else {System.out.println("            |  " + " " + "  |         ");}
            i++;
        }
    }
}
