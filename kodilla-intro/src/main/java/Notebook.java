public class Notebook {
    int weight;
    int price;
    int year;
    public Notebook(int weight, int price, int yearOfProcuction) {
        this.weight = weight;
        this.price = price;
        this.year = yearOfProcuction;
    }
    public void checkPrice() {
        if (this.price < 600) {
            System.out.println("This notebook is very cheap.");
        } else if (this.price >= 600 & this.price <= 1000 ){
            System.out.println("The price is good.");
        }else{
            System.out.println("This notebook is expensive.");
        }
    }
    public void checkWeight() {
        if (this.weight < 1000) {
            System.out.println("This notebook is light.");
        } else if (this.weight >= 2000 & this.weight <= 4000 ){
            System.out.println("This notebook is not very heavy.");
        }else{
            System.out.println("This notebook is very heavy.");
        }
    }

    public void checkPriceAndYear(int price, int year) {
        if (year >= 2020 & (price > 0 & price < 2000)) {
            System.out.println("This notebook is great - it is new and cheap.");
        } else if (year >= 2020 & price >= 2000){
            System.out.println("This notebook is new and quite expensive");
        } else if ((year < 2020 & year >= 1981) & price >= 2000){
            System.out.println("This notebook is rather old and expensive");
        } else if ((year < 2020 & year >= 1981) & (price > 0 & price < 2000)){
            System.out.println("This notebook is rather old but at least is cheap");
        } else{
            System.out.println("In this year notebook was not even yet invented");
        }
    }
}
