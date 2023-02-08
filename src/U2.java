public class U2 extends Rocket {
    private int rocketCost;

    public U2(int cargoCarried, int cargoLimit) {
        super(cargoCarried, cargoLimit);
        this.rocketCost = 120_000_000;
    }

    int explosion = (int) (Math.random() * 100) + 1;
    int crash = (int) (Math.random() * 100) + 1;


    public int getRocketCost() {
        return rocketCost;
    }

    @Override
    public boolean launch() {
        if (explosion > 4) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean land() {
        if (crash < 8) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "U2{" +
                "explosion=" + explosion +
                ", crash=" + crash +
                ", cargoCarried=" + cargoCarried +
                ", cargoLimit=" + cargoLimit +
                '}';
    }
}