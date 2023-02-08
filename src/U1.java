public class U1 extends Rocket  {

    private int rocketCost;

    public U1(int cargoCarried, int cargoLimit) {
        super(cargoCarried, cargoLimit);
        this.rocketCost = 100_000_000;;
    }

    int explosion = (int) (Math.random() * 100) + 1;
    int crash = (int) (Math.random() * 100) + 1;


    public int getRocketCost() {
        return rocketCost;
    }

    @Override
    public boolean launch() {
        if (explosion > 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean land() {
        if (crash < 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "U1{" +
                "explosion=" + explosion +
                ", crash=" + crash +
                ", cargoCarried=" + cargoCarried +
                ", cargoLimit=" + cargoLimit +
                '}';
    }
}
