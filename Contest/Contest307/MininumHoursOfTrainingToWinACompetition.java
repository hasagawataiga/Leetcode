public class MininumHoursOfTrainingToWinACompetition {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int hours = 0;
        for(int i = 0; i < energy.length; i++){
            while(initialEnergy - energy[i] < 1){
                initialEnergy++;
                hours++;
            }
            initialEnergy -= energy[i];
            while(initialExperience - experience[i] < 1){
                initialExperience++;
                hours++;
            }
            initialExperience += experience[i];
        }
        return hours;
    }
}
