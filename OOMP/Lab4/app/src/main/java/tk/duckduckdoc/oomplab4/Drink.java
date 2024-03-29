package tk.duckduckdoc.oomplab4;

public class Drink extends Food {
    protected int volume;

    public Drink(String name, int price, int volume){
        super(name, price);
        this.volume = volume;
    }

    public String toString(){
        return "name=" + this.name + ", price=" + this.price + ", volume=" + this.volume;
    }

    public void setPrice(int price){
        if(price < 5){
            this.price = 5;
        }else{
            this.price = price;
        }
    }
}
