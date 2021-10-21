package com.example.onepractice1.database;

import java.util.Arrays;
import java.util.List;

public class Address {
    private static int nextId = 0;
    private int id;
    private String landmark;
    private String city;
    private String street;
    private int houseNumber;
    private int flatNumber;

    public Address() {

    }

    public Address(String landmark, String city, String street, int houseNumber, int flatNumber) {
        this.landmark = landmark;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    {
        id = nextId++;
    }
//    public static AddressBuilder addressBuilder() {
//        return new Address().new AddressBuilder();
//    }
//
//    public class AddressBuilder {
//        private AddressBuilder() {
//        }
//
//        public AddressBuilder landmark(String landmark) {
//            Address.this.landmark = landmark;
//            return this;
//        }
//
//        public AddressBuilder city(String city) {
//            Address.this.city = city;
//            return this;
//        }
//
//        public AddressBuilder street(String street) {
//            Address.this.street = street;
//            return this;
//        }
//
//        public AddressBuilder houseNumber(int houseNumber) {
//            Address.this.houseNumber = houseNumber;
//            return this;
//        }
//
//        public AddressBuilder flatNumber(int flatNumber) {
//            Address.this.flatNumber = flatNumber;
//            return this;
//        }
//
//        public Address build() {
//            return Address.this;
//        }
//    }
//
//
//    public static List<Address> getAddresses() {
//        Address address1 = Address.addressBuilder()
//                .landmark("KZ")
//                .city("Shymkent")
//                .street("Zhibek zholy")
//                .houseNumber(2)
//                .flatNumber(11)
//                .build();
//
//        Address address2 = Address.addressBuilder()
//                .landmark("KZ")
//                .city("Taraz")
//                .street("Kenesary")
//                .houseNumber(21)
//                .flatNumber(61)
//                .build();
//
//        return Arrays.asList(address1, address2);
//    }
//
//    public static boolean saveAddress(Address address) {
//        return getAddresses().add(address);
//    }
//
//    public static Address getAddressById(int id) {
//        for (Address address : getAddresses()) {
//            if (address.getId() == id) {
//                return address;
//            }
//        }
//        return null;
//    }
//
//    public static void deleteAddressById(int id) {
//        getAddresses().removeIf(address -> address.getId() == id);
//    }


    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Address.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", landmark='" + landmark + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", flatNumber=" + flatNumber +
                '}';
    }

}
