package lesson1.homework.participant;

import lesson1.homework.obstacle.Obstacle;

public interface Participant extends Jumper, Runner {

    default boolean doIt(Obstacle obstacle) {
        return doAction(obstacle);
    }

    private boolean doAction(Obstacle obstacle) {
        return obstacle.passObstacleBy(this);
    }

}
