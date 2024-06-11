public class NPC extends Characters{
    public NPC(int health, int power, int dexterity,int exp, int money, int potion, String name) {
        super(health, power, dexterity, exp, money, potion, name);
    }

    @Override
    public int doDamage() {
        if(getDexterity() * 5 > Math.random() * 100 ) return getPower();
        else return 0;
    }
    public void printInfo(){
        System.out.printf("%s здоровье: %d\n", getName(), getHealth());
    }
}
