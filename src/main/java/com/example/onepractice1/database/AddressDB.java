package com.example.onepractice1.database;

import java.util.ArrayList;
import java.util.List;

public class AddressDB {
    private static AddressDB addressDB;
    private static List<Address> addressList = new ArrayList<>();

    private AddressDB() {
    }

    static {
        addressList.add(new Address("KZ","Shymkent","Zhibek",11,2));
        addressList.add(new Address("KZ","Shymkent","Zholy",21,6));
    }

    public static List<Address> getAddresses(){
        return addressList;
    }

    public static boolean saveAddress(Address address) {
        return addressList.add(address);
    }

    public static Address getAddressById(int id) {
        for (Address address : addressList) {
            if (address.getId() == id) {
                return address;
            }
        }
        return null;
    }

    public static void deleteAddressById(int id) {
        addressList.removeIf(address -> address.getId() == id);
    }

    public static AddressDB getInstance() {
        if (addressDB == null) {
            addressDB = new AddressDB();
        }
        return addressDB;
    }
}
