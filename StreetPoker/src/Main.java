import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            BusinessLogic poker = new BusinessLogic();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the number of players");
            int numPlayers = scanner.nextInt();
            scanner.nextLine();

            for (int i=1;i<= numPlayers;i++){
                System.out.println("Enter the name of players");
                String playerName = scanner.nextLine();
                Player player = new Player(playerName);
                poker.addPlayer(player);
            }


//            Player players1= new Player("kenya");
//            Player players3= new Player("su");
//            Player players2= new Player("uk");
//            Player players4= new Player("diz");
//            Player players5= new Player("nuts");
//
//            poker.addPlayer(players1);
//            poker.addPlayer(players2);
//            poker.addPlayer(players3);
//            poker.addPlayer(players4);
//            poker.addPlayer(players5);


            poker.startGame();



    }
}