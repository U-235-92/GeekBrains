package aq.koptev.level2.lesson1;

public class Competition {

    public void doCompetition() {

        Obstacle track1 = new Track(new ObstacleDistance(100));
        Obstacle track2 = new Track(new ObstacleDistance(500));
        Obstacle track3 = new Track(new ObstacleDistance(1000));
        Obstacle track4 = new Track(new ObstacleDistance(3000));
        Obstacle track5 = new Track(new ObstacleDistance(5000));

        Obstacle wall1 = new Wall(new ObstacleHeight(50));
        Obstacle wall2 = new Wall(new ObstacleHeight(80));
        Obstacle wall3 = new Wall(new ObstacleHeight(110));
        Obstacle wall4 = new Wall(new ObstacleHeight(200));
        Obstacle wall5 = new Wall(new ObstacleHeight(250));

        Activable robot1 = new Robot("RK-2500/170", "Roga-kopita Inc.", new PhysicCharacteristic(2500, 170), new ActiveStatus());
        Activable robot2 = new Robot("RRJ-Mk1", "Orion Gmbh", new PhysicCharacteristic(5500, 200), new ActiveStatus());
        Activable human1 = new Human("Ivan", Sex.MALE, new PhysicCharacteristic(10000, 300), new ActiveStatus());
        Activable human2 = new Human("Nastya", Sex.FEMALE, new PhysicCharacteristic(3000, 80), new ActiveStatus());
        Activable spaceCat = new Cat("Sirius", new PhysicCharacteristic(9000, 9000), new ActiveStatus());

        Activable[] activables = {robot1, robot2, human1, human2, spaceCat};
        Obstacle[] obstacles = {track1, track2, wall1, track3, wall2, wall3, track4, wall4, track5, wall5};

        System.out.println("Участники соревнований:");
        printCompetitionParticipants(activables);
        System.out.println("Препятсвия:");
        printCompetitionObstacles(obstacles);
        System.out.println("Старт полосы препятсвий!");
        startCompetition(obstacles, activables);
        System.out.println("Соревнования закончились!");
        System.out.println("Участники, успешно прошедшие полосу препятсвий:");
        printCompetitionWinners(activables);
   }

   private void printCompetitionParticipants(Activable[] activables) {
       for (Activable unit : activables) {
           System.out.println(unit);
       }
   }

   private void printCompetitionObstacles(Obstacle[] obstacles) {
       for (Obstacle obstacle : obstacles) {
           System.out.println(obstacle);
       }
   }

   private void printCompetitionWinners(Activable[] activables) {
       for(Activable unit : activables) {
           if(unit.isCanActive()) {
               System.out.println(unit);
           }
       }
   }

   private void startCompetition(Obstacle[] obstacles, Activable[] activables) {
       for(Activable unit : activables) {
           for (Obstacle obstacle : obstacles) {
               if(obstacle instanceof Wall) {
                   if(unit.canJump(obstacle.getSize())) {
                       unit.jump();
                   }
               } else if(obstacle instanceof Track) {
                   if(unit.canRun(obstacle.getSize())) {
                       unit.run();
                   }
               }
           }
       }
   }
}
