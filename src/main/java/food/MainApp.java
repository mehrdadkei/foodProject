package food;

import food.enums.OrderStatus;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    private static List<Product> productList;
    private static List<Order> orderList;

    public static void main(String[] args) {
        productList = new ArrayList<Product>();
        orderList = new ArrayList<Order>();
        while (true) {
            try {
                showMenu();
                Integer menu = intGetInput();

                switch (menu) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        changeStatus();
                        break;
                    case 4:
                        showProductList();
                        break;
                    case 5:
                        showOrderList();
                        break;
                    case 6:
                        showProductDetails();
                        break;

                    case 7:
                        print("have a nice time");
                        return;
                }
                if (menu < 1 || menu > 6) {
                    print("the number you have entered is invalid ");
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                print("please enter a valid number ");
            }

        }
    }

    private static void showProductDetails() throws IOException {
        showProductList();
        print("please enter the code of your product");
        Integer details = intGetInput();
        for (Product product : productList) {
            if (details == product.getCode()) {
                System.out.println("name : " + product.getName());
                System.out.println("type : " + product.getTypes());
                System.out.println("price(tooman) : " + product.getPrice());
                System.out.println("address : " + product.getAddress());
                System.out.println("keeping conditions : " + product.getKeepingCondition());

            } else {
                System.out.println("the code you have entered is not match with any of the products");
            }
        }

    }

    private static void showOrderList() {
        for (Order order : orderList) {
            print("your order id is" + order.getId());
            print("1-name: " + order.toString());
            print("2-type: " + order.getType());
            print("3-count: " + order.getCount());
            print("4-status: " + order.getStatus());
            print("5-release day: " + order.getReleaseDay());

        }
        if (orderList.size() == 0) {
            print("there is no product");
        }
    }

    private static void showProductList() {
        for (Product product : productList) {
            print(product.getName() + " => " + "code: " + product.getCode());
        }
        if (productList.size() == 0) {
            print("there is no any order");
        }
    }

    private static void showMenu() {
        print("please enter one of these numbers");
        print("1- Add a new product");
        print("2- Add an order");
        print("3- Change order status");
        print("4- show product list ");
        print("5- show order list");
        print("6- show product details");
        print("7- Exit");


    }


    private static void addOrder() throws Exception {
        print("please enter code product of your order");
        Product productOrder = null;
        Integer codeOrder = intGetInput();
        for (Product product : productList) {
            if (codeOrder == product.getCode()) {
                productOrder = product;
            }
        }
        if (productOrder == null) {
            throw new Exception("product not found");
        }

        Order order = new Order();
        print("please enter the count ");
        Long count = Long.valueOf(getInput());
        order.setCount(count);

        order.setStatus(OrderStatus.InQueue);
        order.setProduct(productOrder);
        order.setType(productOrder.getTypes());
        print("please enter the release day");
        order.setReleaseDay(intGetInput());
        for (int i = 0; i <= orderList.size(); i++) {
            order.setId(i);
        }
        print("the product id is" + order.getId());
        orderList.add(order);
        print("order added successfully");


    }


    private static void addProduct() throws IOException {
        productMenu();
        Product product;

        int types = intGetInput();

        try {
            switch (types) {
                case 1:
                case 2:
                case 4:
                    product = new IncorruptibleProduct();
                    print(" please enter the maximum days we can keep it in store");
                    ((IncorruptibleProduct) product).setMaxDayKeep(intGetInput());
                    break;
                case 3:
                case 5:
                    product = new CorruptibleProduct();
                    print(" please enter the maximum temperature we can keep it in the store");
                    ((CorruptibleProduct) product).setMaxTemperature(intGetInput());
                    print(" please enter the minimum temperature we can keep it in the store");
                    ((CorruptibleProduct) product).setMinTemperature(intGetInput());
                    break;
                default:
                    throw new IllegalStateException(" please enter valid number from 1 to 5 ");
            }

            print("please enter product name");
            product.setName(getInput());
            print("please enter product code");
            product.setCode(intGetInput());
            print("please enter product keepingCondition");
            product.setKeepingCondition(getInput());
            print("please enter product price");
            product.setPrice(intGetInput());
            print("please enter product address");
            product.setAddress(getInput());

            product.setTypes(types);

            productList.add(product);
            print("your product added successfully");

        } catch (IllegalStateException e) {
            print("please enter a valid number ");
        }
    }

    private static void productMenu() {
        print("enter the number that is related to your product");
        print("1- can");
        print("2- health");
        print("3- dairy");
        print("4- snacks");
        print("5-protein");
    }

    private static void changeStatus() throws IOException {
        print("please enter the id");
        int id = intGetInput();

        for (Order order : orderList) {
            if (order.getId() == id) {
                print("please enter the number according to your order status");
                print("1-in progress");
                print("2-done");
                switch (intGetInput()) {
                    case 1:
                        order.setStatus(OrderStatus.InProgress);

                        break;
                    case 2:
                        order.setStatus(OrderStatus.Done);
                        break;

                }
                print("status:" + order.getStatus());

            }
        }


    }

    private static void print(String msg) {
        System.out.println(msg);
    }

    private static String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static Integer intGetInput() throws IOException {
        return Integer.parseInt(getInput());
    }

}