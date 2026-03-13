package WorkbookWeek2.Week2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {

    static SessionFactory factory;

    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        factory = md.getSessionFactoryBuilder().build();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== Product Menu ======\n");
            System.out.println("1. Insert Product");
            System.out.println("2. View Product details");
            System.out.println("3. Update Product details");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertProduct();
                    break;
                case 2:
                    viewProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
            }

        } while (choice != 5);

        factory.close();
        sc.close();
    }

    private static void insertProduct() {
        Scanner sc = new Scanner(System.in);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product prod = new Product();

        System.out.print("Enter the Name of the product: ");
        String name = sc.nextLine();
        prod.setName(name);

        System.out.print("Enter the Description of the product: ");
        String des = sc.nextLine();
        prod.setDescription(des);

        System.out.print("Enter the Price of the product: ");
        double price = sc.nextDouble();
        prod.setPrice(price);

        System.out.print("Enter the Quantity of the product: ");
        int quant = sc.nextInt();
        prod.setQuantity(quant);

        session.persist(prod);
        tx.commit();
        session.close();

        System.out.println("Record inserted successfully.");
    }

    private static void viewProduct() {
        Scanner sc = new Scanner(System.in);
        Session session = factory.openSession();

        System.out.print("Enter the ID of the product to be viewed: ");
        int id = sc.nextInt();

        Product prod = session.get(Product.class, id);

        if (prod != null) {
            System.out.println("Name: " + prod.getName());
            System.out.println("Description: " + prod.getDescription());
            System.out.println("Price: " + prod.getPrice());
            System.out.println("Quantity: " + prod.getQuantity());
        } else {
            System.out.println("Product not found!");
        }

        session.close();
    }

    private static void updateProduct() {
        Scanner sc = new Scanner(System.in);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter the Product ID: ");
        int id = sc.nextInt();

        Product prod = session.get(Product.class, id);

        if (prod != null) {
            System.out.print("Enter the new product price: ");
            prod.setPrice(sc.nextDouble());
            tx.commit();
            System.out.println("Price updated successfully.");
        } else {
            System.out.println("Product not found!");
            tx.rollback();
        }

        session.close();
    }

    private static void deleteProduct() {
        Scanner sc = new Scanner(System.in);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter the ID of the product to be deleted: ");
        int id = sc.nextInt();

        Product prod = session.get(Product.class, id);

        if (prod != null) {
            session.remove(prod);
            tx.commit();
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found!");
            tx.rollback();
        }

        session.close();
    }
}