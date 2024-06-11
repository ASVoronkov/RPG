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
    int health, power, dexterity, level, exp, money, potion;



    String name;

    public Characters(int health, int power, int dexterity,int exp, int money, int potion, String name) {
        this.health = health;
        this.power = power;
        this.dexterity = dexterity;
        this.level = exp / 100;
        this.exp = exp;
        this.money = money;
        this.potion = potion;
        this.name = name;
    }
    public abstract int damage();

    @Override
    public void printInfo() {

    }
}
