public class FirstClass {
    public static void main(String[] args) {

        String myFirstStringText = "Hello from FirstClass!";
        System.out.println(myFirstStringText);

        Notebook notebook = new Notebook(600,1000, 2010);
        System.out.println(notebook.weight + " " + notebook.price);
        notebook.checkPrice();

        Notebook heavyNotebook = new Notebook(2000, 1500,2020);
        System.out.println(heavyNotebook.weight + " " + heavyNotebook.price);
        heavyNotebook.checkPrice();

        Notebook oldNotebook = new Notebook(1200, 500, 2023);
        System.out.println(oldNotebook.weight + " " + oldNotebook.price);
        oldNotebook.checkPrice();

        notebook.checkPriceAndYear(2000,1981);

    }
}
