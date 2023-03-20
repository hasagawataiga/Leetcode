package Daily_questions;


public class Can_place_flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++){
            if (n == 0){
                return true;
            }
            if (flowerbed[i] == 1){
                i++;
            } else {
                if (i + 1 < flowerbed.length){
                    if (flowerbed[i + 1] == 0){
                        n--;
                        i++;
                    }
                } else {
                    n--;
                }
            }
        }
        return n == 0 ? true : false;
    }
}
