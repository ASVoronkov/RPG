/*
Абстрактный класс:
От него наследуются противники и Игрок
поля:
 ***Integer:***
 =============
health;
power;
dexterity;
level;
exp;
money;
potion;
==============

***String:***
name

 */
public abstract class Characters implements Info {
   private int health;
    private final int power;
    private final int dexterity;
    private int level;
    private int exp;
    private int money;
    private int potion;

    private final String name;

    public String getName() {
        return name;
    }


    public Characters(int health, int power, int dexterity, int exp, int money, int potion,  String name) {
        this.health = health;
        this.power = power;
        this.dexterity = dexterity;
        this.level = exp / 100;
        this.exp = exp;
        this.money = money;
        this.potion = potion;
        this.name = name;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }



    public int getDexterity() {
        return dexterity;
    }



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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


    public abstract int doDamage();

    @Override
    public void printInfo() {

    }
}
