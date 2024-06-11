public abstract class Merchant implements Info {
    String name;
    int money, potion;

    public Merchant(String name, int money, int potion) {
        this.name = name;
        this.money = money;
        this.potion = potion;
    }

    @Override
    public void printInfo() {
        System.out.println("Спасибо что посетил меня. Мне будет тебя не хватать когда тебя убьют...");
    }
}
