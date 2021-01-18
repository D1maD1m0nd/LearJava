package books.Lesson4;

public class ElectroGuitar {
    String brand;
    int numOfPickups;
    boolean rockStarUsesIt;

    String getBrand(){
        return brand;
    }
    void setBrand(String aBrand){
        brand = aBrand;
    }

    int getNumOfPickups(){
        return numOfPickups;
    }

    void setNumOfPickups(int aNumOfPickups){
        numOfPickups = aNumOfPickups;
    }

    boolean getRockStarUsesIt(){
        return rockStarUsesIt;
    }

    void setRockStarUsesIt(boolean aRockStarUsesIt){
        rockStarUsesIt = aRockStarUsesIt;
    }
}
