abstract class Vehicle{
    private int Time;
    private boolean isEmergency;
    public Vehicle() {
        Time = 0;
        isEmergency = false;
    }
    public Vehicle(int A, boolean B) {
        Time = A;
        isEmergency = B;
    }
    public int getTime(){
        return Time;
    }
    public Boolean getEmergency(){
        return isEmergency;
    }
    public String toString(){
        return "V";
    }
}