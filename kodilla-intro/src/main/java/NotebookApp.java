public class NotebookApp {
    public static void main(String[] args) {
        Notebook notebook = new Notebook(600, 1000, 2010);
        Notebook heavyNotebook = new Notebook(2000, 1500, 2020);
        Notebook oldNotebook = new Notebook(1200, 500, 2023);

        NotebookApp notebookApp = new NotebookApp();
        notebookApp.displayNotebookData(notebook);
        notebookApp.displayNotebookData(heavyNotebook);
        notebookApp.displayNotebookData(oldNotebook);

        notebook.checkPriceAndYear(2000, 1981);
    }

    private void displayNotebookData(Notebook notebook) {
        System.out.println(notebook.weight + " " + notebook.price);
        notebook.checkPrice();
    }
}