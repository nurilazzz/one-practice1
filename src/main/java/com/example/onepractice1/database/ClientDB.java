package com.example.onepractice1.database;

import com.example.onepractice1.models.enumuration.PostStatus;

import java.util.ArrayList;
import java.util.List;

public class ClientDB {
    private static ClientDB clientDB;
    private static List<Client> clientList = new ArrayList<>();

    private ClientDB() {
    }

    static {
        clientList.add(new Client("Nurila","Zharkynbek","nurila@gmail.com",AddressDB.getAddressById(0)));
        clientList.add(new Client("Assem","Meldebekova","assem@gmail.com",AddressDB.getAddressById(1)));
    }

    public static List<Client> getClients() {
        return clientList;
    }

    public static boolean saveClient(Client client) {
        return clientList.add(client);
    }


    public static Client getClientById(int id) {
        for (Client client : clientList) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    public static void deleteClientById(int id) {
        clientList.removeIf(post -> post.getId() == id);
    }

    public static ClientDB getInstance() {
        if (clientDB == null) {
            clientDB = new ClientDB();
        }
        return clientDB;
    }
}
