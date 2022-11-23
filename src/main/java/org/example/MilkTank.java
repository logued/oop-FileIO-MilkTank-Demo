package org.example;

public class MilkTank {
    public static final int STANDARD_TANK_CAPACITY = 2000;
    private String name;
    private double capacity;
    private double amountInTank;

    MilkTank() {
        this.name ="unnamed tank";
        this.capacity = STANDARD_TANK_CAPACITY;
        this.amountInTank=0;
    }

    MilkTank(String name, int capacity) {
        this.name=name;
        this.capacity = capacity;
        this.amountInTank=0;
    }

    public String getName() { return this.name; }
    public double getCapacity() { return this.capacity;}
    public double getAmountInTank() { return amountInTank; }
    public double freeSpace() {
        return this.capacity - this.amountInTank;
    }

    /**
     * Extract/Remove milk from this tank.
     * @param amountRequested
     * @return amount of milk removed from the tank.
     * Note, there may not be enough milk in the tank to satisfy the requested amount.
     */
    public double removeFromMilkTank(double amountRequested ) {
        double amountRemoved=amountRequested;

        if( this.amountInTank >= amountRequested ){
            amountInTank -= amountRequested;
        }
        else {   // there is not enough milk in the tank to satisfy the amount requested
                 // so, we remove what is available in the tank
            amountRemoved = this.amountInTank;
            this.amountInTank = 0.0;
        }
        return amountRemoved;
    }

    /**
     * Add milk to this tank.
     * @param amountPresented amount of milk in litres that we want to add to tank
     * @return amountAdded - the amount actually added to the tank
     */
     public double addMilkToTank( double amountPresented ){
        double amountAdded = amountPresented;

        if(amountInTank + amountPresented > capacity)  { // amount will overfill the tank!
            amountAdded = capacity - amountInTank;
            amountInTank = capacity;  // set tank as full

            //TODO - should we raise a warning if the amount is greater than the
            // remaining space in the tank.  Discuss!
            // As this code currently stands, if tank is filled beyond capacity
            // the overflow is just ignored (dumped).
        }
        else {  // case where the tank can take the full amount being added
            amountInTank += amountPresented;
        }
        return amountAdded;
    }

    @Override
    public String toString() {
        return "MilkTank{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", amountInTank=" + amountInTank +
                '}';
    }
}
