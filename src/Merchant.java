public abstract class Merchant implements Info {

    private  String name;

    private int money, potion;

    public Merchant(String name, int money, int potion) {
        this.money = money;
        this.potion = potion;
        this.name = name;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public int getPotion() {
        return potion;
    }

    public void setPotion(int potion) {
        this.potion = potion;
    }

    @Override
    public void printInfo() {
        System.out.println("Спасибо что посетил меня. Мне будет тебя не хватать когда тебя убьют...");
    }
}
