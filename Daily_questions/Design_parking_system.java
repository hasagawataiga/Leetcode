public class Design_parking_system {
    class ParkingSystem {
        int[] parkingSlots;
        public ParkingSystem(int big, int medium, int small) {
            parkingSlots = new int[3];
            parkingSlots[0] = big;
            parkingSlots[1] = medium;
            parkingSlots[2] = small;
        }
        
        public boolean addCar(int carType) {
            if (parkingSlots[carType - 1] > 0){
                parkingSlots[carType - 1]--;
                return true;
            } else {
                return false;
            }
        }
    }
}
