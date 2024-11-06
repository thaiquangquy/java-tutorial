package org.example.SOLID;

public class Open_Closed {
    public class Vehicle {
        public double getNumber() {
            return 0;
        }
    }

    public class Car extends Vehicle {
        public double getNumber() {
            return 0;
        }
    }

    public class Bike extends Vehicle {
        public double getNumber() {
            return 0;
        }
    }

    public class VehicleInfo {
        public double vehicleNumber(Vehicle vcl) {
            // below implement violates open-closed principle
            if (vcl instanceof Car) {
                return vcl.getNumber();
            } else if (vcl instanceof Bike) {
                return vcl.getNumber();
            }
            return 0;
        }
    }

    public class VehicleInfoOpenClosed {
        public double vehicleNumber() {
            // return number
            return 0;
        }
    }

    public class CarInfo extends VehicleInfoOpenClosed {
        @Override
        public double vehicleNumber() {
            // return car number
            return 1;
        }
    }

    public class BikeInfo extends VehicleInfoOpenClosed {
        @Override
        public double vehicleNumber() {
            // return car number
            return 2;
        }
    }

    public void main(String[] args) {
        Open_Closed open_closed = new Open_Closed();
        VehicleInfo vehicleInfo = open_closed.new VehicleInfo();
        VehicleInfoOpenClosed vehicleInfoOpenClosed = open_closed.new VehicleInfoOpenClosed();
        CarInfo carInfo = open_closed.new CarInfo();
        BikeInfo bikeInfo = open_closed.new BikeInfo();
        System.out.println(vehicleInfo.vehicleNumber(new Car()));
        System.out.println(vehicleInfo.vehicleNumber(new Bike()));
        System.out.println(carInfo.vehicleNumber());
        System.out.println(bikeInfo.vehicleNumber());
    }
}
