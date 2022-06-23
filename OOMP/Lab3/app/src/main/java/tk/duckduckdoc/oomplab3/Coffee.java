package tk.duckduckdoc.oomplab3;

public class Coffee extends Drink {
    protected boolean isSweet;

    public Coffee(String name, int price, int volume, boolean isSweet) {
        super(name, price, volume);
        this.isSweet = isSweet;
    }

    public String toString(){
        return "name=" + this.name + ", price=" + this.price + ", volume=" + this.volume + ", isSweet=" + this.isSweet;
    }

    public void setPrice(int price){
        if(price < 10){
            this.price = 10;
        }else{
            super.setPrice(price);
        }
    }
}
