public class Main {

        public static void main(String[] args) {

            BusinessLogic poker = new BusinessLogic();

            Player players1= new Player("victor");
            Player players3= new Player("dubs");
            Player players2= new Player("Darren");
            Player players4= new Player("nigs");
            Player players5= new Player("diz");


            poker.startGame();
    }
}