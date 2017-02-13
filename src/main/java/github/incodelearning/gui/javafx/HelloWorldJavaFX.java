package github.incodelearning.gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * <p>
 * Install openjfx (8u60) on linux-mint with openjdk 8u121.
 * <p>
 * cat /usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/lib/javafx.properties
 * <p>
 * Add /usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/lib/ext/jfxrt.jar to project classpath. In intelliJ, configure -
 * project defaults - project structure, in platform settings - SDKs, classpath tab, add the jar. In Documentation tab,
 * add url http://docs.oracle.com/javafx/2/api/ http://download.java.net/jdk8/jfxdocs.
 */
public class HelloWorldJavaFX extends Application {

    // this method is called when JavaFX application is started

    /**
     * <p>
     * A {@link Stage} is top level JavaFX container, created for you by JavaFX runtime. All displayed content must be
     * located inside a {@link Scene}.
     * <p>
     * A stage can display multiple scenes, just like a theater play. Similarly, a computer game may have a
     * menu scene, a game scene, a game over scene, and a high score scene.
     * <p>
     * Content of scene is represented as a hierarchical scene graph of nodes. Here, the root node is a
     * {@link StackPane}, a resizable layout node. The root node's size tracks the size of the scene
     * and changes when user resize the stage.
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // not awt button
        Button button = new Button();
        button.setText("Say 'Hello World' ");
        button.setOnAction(event -> System.out.println("Hello World!"));

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("JavaFX Hello World App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * <p>
     * The main method is not required for JavaFX JAR application is created with JavaFX packager tool. Swing
     * applications that embed JavaFX code require main method. It's also convenient to run in IDE or if you want to
     * pass command line arguments.
     *
     * @param args
     */
    public static void main(String[] args) {
        // launches JavaFX runtime and this application
        launch(args);
    }
}
