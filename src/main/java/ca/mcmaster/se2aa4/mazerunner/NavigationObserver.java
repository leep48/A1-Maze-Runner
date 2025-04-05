package ca.mcmaster.se2aa4.mazerunner;

public interface NavigationObserver {
    public void update(RightHandMove move, Position currentPosition);
}
