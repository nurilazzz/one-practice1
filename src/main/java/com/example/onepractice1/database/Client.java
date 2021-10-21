package com.example.onepractice1.database;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    private static int nextId = 0;
    private int id;
    private String name;
    private String surname;
    private String email;
    private Address addressId;
    private List<Post> posts;

    public Client() {
    }

    public Client(String name, String surname, String email, Address address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.addressId = address;
    }

    {
        id = nextId++;
    }
//    public static Client.ClientBuilder clientBuilder() {
//        return new Client().new ClientBuilder();
//    }
//
//    public class ClientBuilder {
//        private ClientBuilder() {
//        }
//
//        public ClientBuilder name(String name) {
//            Client.this.name = name;
//            return this;
//        }
//
//        public ClientBuilder surname(String surname) {
//            Client.this.surname = surname;
//            return this;
//        }
//
//        public ClientBuilder email(String email) {
//            Client.this.email = email;
//            return this;
//        }
//
//        public ClientBuilder addressId(Address addressId) {
//            Client.this.addressId = addressId;
//            return this;
//        }
//
//        public ClientBuilder posts(List<Post> posts) {
//            Client.this.posts = posts;
//            return this;
//        }
//
//        public Client build() {
//            return Client.this;
//        }
//    }
//
//
//    public static List<Client> getClients(){
//        Client client1 = Client.clientBuilder()
//                .name("Nurila")
//                .surname("Zharkynbek")
//                .email("nurila@gmail.com")
//                .addressId(Address.getAddressById(0))
//                .posts(new ArrayList<>())
//                .build();
//
//        Client client2 = Client.clientBuilder()
//                .name("Assem")
//                .surname("Meldebekova")
//                .email("assem@gmail.com")
//                .addressId(Address.getAddressById(1))
//                .posts(new ArrayList<>())
//                .build();
//
//        return Arrays.asList(client1, client2);
//    }
//
//    public static boolean saveClient(Client client) {
//        return getClients().add(client);
//    }
//
//    public static Client getClientById(int id) {
//        for (Client client : getClients()) {
//            if (client.getId() == id) {
//                return client;
//            }
//        }
//        return null;
//    }
//
//    public static void deleteClientById(int id) {
//        getClients().removeIf(client -> client.getId() == id);
//    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Client.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", addressId=" + addressId;
    }
}
