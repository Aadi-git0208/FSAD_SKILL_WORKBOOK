package Week3.week3;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class App {


private static final Session HibernateUtil = null;
static SessionFactory factory = HibernateUtil.getSessionFactory();

public static void main(String[] args) {

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

    sc.close();
    factory.close();
}

private static void insertProduct() {
    Scanner sc = new Scanner(System.in);
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();

    Product p = new Product();

    System.out.print("Enter Product Name: ");
    p.setName(sc.nextLine());

    System.out.print("Enter Description: ");
    p.setDescription(sc.nextLine());

    System.out.print("Enter Price: ");
    p.setPrice(sc.nextDouble());

    System.out.print("Enter Quantity: ");
    p.setQuantity(sc.nextInt());

    session.persist(p);

    tx.commit();
    session.close();

    System.out.println("Product inserted successfully.");
}

private static void viewProduct() {

    Scanner sc = new Scanner(System.in);
    Session session = factory.openSession();

    System.out.print("Enter Product ID: ");
    int id = sc.nextInt();

    Product p = session.get(Product.class, id);

    if (p != null) {
        System.out.println("Name: " + p.getName());
        System.out.println("Description: " + p.getDescription());
        System.out.println("Price: " + p.getPrice());
        System.out.println("Quantity: " + p.getQuantity());
    } else {
        System.out.println("Product not found");
    }

    session.close();
}

private static void updateProduct() {

    Scanner sc = new Scanner(System.in);
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();

    System.out.print("Enter Product ID to update: ");
    int id = sc.nextInt();

    Product p = session.get(Product.class, id);

    if (p != null) {
        System.out.print("Enter new price: ");
        p.setPrice(sc.nextDouble());

        tx.commit();
        System.out.println("Product updated successfully.");
    } else {
        System.out.println("Product not found.");
        tx.rollback();
    }

    session.close();
}

private static void deleteProduct() {

    Scanner sc = new Scanner(System.in);
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();

    System.out.print("Enter Product ID to delete: ");
    int id = sc.nextInt();

    Product p = session.get(Product.class, id);

    if (p != null) {
        session.remove(p);
        tx.commit();
        System.out.println("Product deleted successfully.");
    } else {
        System.out.println("Product not found.");
        tx.rollback();
    }

    session.close();
}


}
