public class SimpleArray {
    public static void main(String[] args) {

        String[] animals = new String[] {"monkey", "dog", "cat", "frog", "bird"};
        String animal = animals[3];
        System.out.println("Chosen animal is: " + animal );
        int numberOfAnimals = animals.length;
        System.out.println("My table with animals consists of " +numberOfAnimals + " elements(animals)");
    }
}
