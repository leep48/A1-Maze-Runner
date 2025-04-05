package ca.mcmaster.se2aa4.mazerunner;

public interface AutoNavigator {
    public void generatePath();
    public String getGeneratedPath();
    public void addObserver(NavigationObserver observer);
}
