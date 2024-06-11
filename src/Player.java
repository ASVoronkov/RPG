public class Player extends Characters {
    public Player(int health, int power, int dexterity, int exp, int money, int potion, String name) {
        super(health, power, dexterity, exp, money, potion, name);

    }

    @Override
    public int damage() {
        if (dexterity * 5 > Math.random() * 100) return power;
        else return 0;
    }

    public void printInfo() {
        System.out.printf("%s:\nЗдоровье %d ваш опыт: %d, зелий: %d  в кошельке %d монет.\n", name, health, exp, potion, money);
    }
}
