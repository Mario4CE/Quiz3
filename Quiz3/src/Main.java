import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        LinkedList linkedList = new LinkedList();

        Random random = new Random();

        // Generar 100 elementos aleatorios e insertarlos en la lista y el árbol
        for (int i = 0; i < 100; i++) {
            int element = random.nextInt(1000);
            linkedList.add(element);
            tree.insert(element);
        }
        System.out.println("LinkedList");
        for (int i = 0; i < 100; i++) {
            System.out.println(linkedList.get(i));
        }
        System.out.println("---------------------------------------------------");
        System.out.println("BStree");
        tree.printKeysInOrder();

        System.out.println("---------------------------------------------------");

        System.out.println("Lista aleatoria");
        int counter = 0; // Contador para imprimir cada 10 elementos
        for (Object number : linkedList) {
            System.out.print(number + " ");
            counter++;
            if (counter % 10 == 0) { // Si el contador es múltiplo de 10, imprimir un salto de línea
                System.out.println();
            }
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        // Realizar la búsqueda 7 veces
            System.out.println("Ingrese el valor a buscar: ");
            int searchValue = scanner.nextInt();

            // Medir y realizar la búsqueda en la LinkedList
            long startTimeLinkedList = System.nanoTime();
            boolean foundInLinkedList = linkedList.contains(searchValue);
            long endTimeLinkedList = System.nanoTime();
            System.out.println("Valor encontrado en LinkedList: " + foundInLinkedList + " en " + (endTimeLinkedList - startTimeLinkedList) + " nanosegundos.");

            // Medir y realizar la búsqueda en el BSTree
            long startTimeBSTree = System.nanoTime();
            boolean foundInBSTree = tree.find(searchValue);
            long endTimeBSTree = System.nanoTime();
            System.out.println("Valor encontrado en BSTree: " + foundInBSTree + " en " + (endTimeBSTree - startTimeBSTree) + " nanosegundos.");

        }
}

