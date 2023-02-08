public class Rocket implements SpaceShip{

    int cargoCarried;
    int cargoLimit;


    public Rocket(int cargoCarried, int cargoLimit) {
        this.cargoCarried = cargoCarried;
        this.cargoLimit = cargoLimit;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if(cargoCarried < cargoLimit){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int carry(Item item) {
        return cargoCarried += item.getWeight();
    }
}
