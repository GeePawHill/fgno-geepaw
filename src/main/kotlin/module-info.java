module org.geepawhill {
    requires javafx.controls;
    requires java.desktop;
    requires kotlin.stdlib;
    requires tornadofx;

    opens org.geepawhill.plotter;
    opens org.geepawhill.plotter.ui;
    opens org.geepawhill.plotter.game;
}