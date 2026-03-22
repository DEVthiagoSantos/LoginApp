package org.example.login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.VitrineApp;

import javax.swing.*;

public class LoginApp extends Application {

    private AnchorPane pane;
    private TextField txLogin;
    private PasswordField passwordField;
    private Button btEnter, btSair;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initListeners();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        // Remove a opção de maximizar a tela
        stage.setResizable(false);
        // Da um titulo para a tela
        stage.setTitle("Login");
        stage.show();
        initLayout();
        LoginApp.stage = stage;
    }

    private void initLayout() {
        txLogin .setLayoutX((pane.getWidth() -
                txLogin.getWidth()) / 2);
        txLogin.setLayoutY(50);

        passwordField .setLayoutX((pane.getWidth() -
                passwordField.getWidth()) / 2);
        passwordField.setLayoutY(100);

        btEnter.setLayoutX((pane.getWidth() -
                btEnter.getWidth()) / 2);
        btEnter.setLayoutY(150);

        btSair.setLayoutX((pane.getWidth() -
                btSair.getWidth()) / 2);
        btSair.setLayoutY(200);
    }

    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        pane.setStyle("""
                -fx-background-color: linear-gradient(
                from 0% 0% to 100% 100%, blue 0%, silver 100%);""");
        txLogin = new TextField();
        txLogin.setPromptText("Digite seu nome");
        passwordField = new PasswordField();
        passwordField.setPromptText("Digite sua senha");
        btEnter = new Button();
        btEnter.setText("Login");
        btSair = new Button();
        btSair.setText("Sair");
        pane.getChildren().addAll(txLogin, passwordField, btEnter, btSair);
    }

    private void initListeners() {
        btSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fecharAplicacao();
            }
        });

        btEnter.setOnAction(new  EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                logar();
            }
        });
    }

    private void logar() {

        if (txLogin.getText().equals("entaoth")
                && passwordField.getText().equals("senha")) {
            try {
                new VitrineApp().start(new Stage());
                LoginApp.stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null,
                    "Login ou senha incorretos",
                    "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fecharAplicacao() {
        System.exit(0);
    }

    public static void main(String[] args) {

        launch(args);
    }

}