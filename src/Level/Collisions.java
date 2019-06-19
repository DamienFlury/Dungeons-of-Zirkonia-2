package Level;

import Objects.MovingGameEntity;

public class Collisions {

    public boolean checkWallRight(MovingGameEntity object1, BasicRoom walls) {
        for (int i = 0; i < walls.WallList.size(); i++) {
            if (object1.getRight().intersects(walls.WallList.get(i).getPosX(), walls.WallList.get(i).getPosY(), walls.WallList.get(i).getWidth(), walls.WallList.get(i).getHeight())) {
                return false;
            }

        }
        return true;
    }

    public boolean checkWallLeft(MovingGameEntity object1, BasicRoom walls) {
        for (int i = 0; i < walls.WallList.size(); i++) {
            if (object1.getLeft().intersects(walls.WallList.get(i).getPosX(), walls.WallList.get(i).getPosY(), walls.WallList.get(i).getWidth(), walls.WallList.get(i).getHeight())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWallUp(MovingGameEntity object1, BasicRoom walls) {
        for (int i = 0; i < walls.WallList.size(); i++) {
            if (object1.getTop().intersects(walls.WallList.get(i).getPosX(), walls.WallList.get(i).getPosY(), walls.WallList.get(i).getWidth(), walls.WallList.get(i).getHeight())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWallDown(MovingGameEntity object1, BasicRoom walls) {
        for (int i = 0; i < walls.WallList.size(); i++) {
            if (object1.getBottom().intersects(walls.WallList.get(i).getPosX(), walls.WallList.get(i).getPosY(), walls.WallList.get(i).getWidth(), walls.WallList.get(i).getHeight())) {
                return false;
            }
        }
        return true;
    }
}
