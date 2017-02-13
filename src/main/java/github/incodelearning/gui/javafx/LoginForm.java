package github.incodelearning.gui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * <p>
 * GridPane layout enables flexible grid of rows and columns. You can place controls in any cell in the grid and
 * you can make controls span cells as needed.
 * <p>
 * The scene is created with grid pane as root, which is common practice when working with layout containers. As
 * the window is resized, the nodes within the grid pane are resized according to their layout constraints. The grid
 * pane remains in the center and padding properties ensure the padding around the grid pane when you make the window
 * smaller.
 * <p>
 * If you do not set scene dimensions, the scene defaults to the minimum size needed to display its contents.
 */
public class LoginForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome Login Form");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // default top left of scene
        // gap properties manage spacing between rows and columns
        grid.setHgap(10);
        grid.setVgap(10);
        // padding manages spaces around edges of the grid pane
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        // CSS preferred over inline styles
        // scenetitle.setFont(Font.font("Ani", FontWeight.BOLD, 20));
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        // System.out.println(Font.getFamilies());

        Label username = new Label("User Name:");
        grid.add(username, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label password = new Label("Password:");
        grid.add(password, 0, 2);

        TextField passwordField = new TextField();
        grid.add(passwordField, 1, 2);

        grid.setGridLinesVisible(false);

        Button button = new Button("Sign in");
        // HBox layout pane with spacing of 10
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(button);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        actiontarget.setId("login-response");

        button.setOnAction(event -> {
            // actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Sign in buton pressed");
        });


        // with width 300, part of label user name is hidden
        Scene scene = new Scene(grid, 350, 275);
        primaryStage.setScene(scene);
        // just add the css file in the corresponding class folder, works in ide
        scene.getStylesheets().add(LoginForm.class.getResource("login.css").toExternalForm());

        primaryStage.show();
    }
}
