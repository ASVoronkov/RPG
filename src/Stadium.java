import java.util.Scanner;

public class Stadium {
    private static Characters player = null;
    private static Characters npc = null;
    private final static Scanner sc = new Scanner(System.in);
    private static int count = 0;
    private static int round = 0;
    private static final PotionDealer pd = new PotionDealer("PotionDealer", 1000,100);


    public static void main(String[] args) {
        System.out.println("""
                Привет! Добро пожаловать в мир приключений.\s
                Вам предстоит провести неограниченное количество сражений с разбойниками.
                От боя к бою растут показатели противника.
                Ваш уровень тоже растет с увеличением опыта.
                Не забываем пользоваться зельем. Если зелья не достаточно всегда можно заглянуть на рынок и пополнить запас зелья.\s
                Удачи!""");
        crateCharacters();
        navigation();
        move(sc.next());


    }




    private static void move(String next) {
        switch (next) {
            case "1" -> battle();
            case "2" -> potion();
            case "3" -> bayPotion();
            case "4" -> {
                System.out.println("1.Закончить игру 2.Начать заново");
                youLose(sc.next());
            }
        }
    }

    private static void bayPotion() {
        if(player.getMoney() >= 100){
            player.setMoney(player.getMoney() - 100);
            player.setPotion(player.getPotion() + 1);
            pd.setMoney(pd.getMoney() + 100);
            pd.setPotion(pd.getPotion() - 1);
            System.out.println("вы купили 1 зелье. У вас теперь " + player.getPotion()+ "шт. зелья" );
        } else System.out.println("Недостаточно денег");
        navigation();
        move(sc.next());
    }


    private static void potion() {
        if (player.getPotion() > 0) {
            player.setHealth(player.getHealth() + 100);
            player.setPotion(player.getPotion() - 1);
        } else {
            System.out.println("Недостаточно зелья");
        }
        pd.printInfo();
        player.printInfo();
        navigation();

        move(sc.next());

    }

    private static void navigation() {
        if (player.getHealth() > 0) {
            System.out.println("\n1.В бой 2.Лечиться 3.На рынок 4.выход");
        }
    }

    private static void battle() {
        int playerHit;
        if(player.getLevel() > 1){
       playerHit = player.doDamage() + 10 * player.getLevel();}
        else {playerHit = player.doDamage();}
        player.setExp(player.getExp() + playerHit);
        npc.setHealth(npc.getHealth() - playerHit);
        int npcHit = npc.doDamage();
        player.setHealth(player.getHealth() - npcHit);
        player.setLevel(player.getExp() / 100);

        if (player.getHealth() <= 0) {
            player.setHealth(0);
            System.out.println("Вас побили...");
            System.out.println("1.Закончить игру 2.Начать заново");
             youLose(sc.next());
             return;

        }
        if (npc.getHealth() <= 0) {
            npc.setHealth(0);
            System.out.println("Противник номер " + count + " повержен");
            player.setMoney(player.getMoney() + npc.getMoney());
            crateCharacters();
            navigation();
            move(sc.next());
        }
        npc.printInfo();
++round;
        player.printInfo();
        navigation();
        move(sc.next());
    }

    private static void youLose(String choice) {

            if (choice.equals("1")){ theEnd();
                return;}
            if(choice.equals("2")) {
                count = 0;
                round = 0;
                npc.setHealth(0);
                player = null;
                crateCharacters();
                navigation();
                move(sc.next()); }

    }

    private static void theEnd() {
        System.out.println("END...");
        printFinalStat();
    }

    private static void printFinalStat() {
        System.out.printf("%s, вы провели %d раундов в %d битвах, заработали %d опыта",
                player.getName(), round, count, player.getExp());
    }

    private static void crateCharacters() {
        if (player == null) {

            System.out.println("введите имя_");
            player = new Player(100,10, 10, 0, 1000, 1, sc.next());
        }
        if (npc == null || npc.getHealth() == 0) {
            count++;
            npc = new NPC(100 + count * 10, 10,50 + count, 0, 100, count, "Злодей номер " + count);
        }
    }

}

