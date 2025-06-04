package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class MainApp extends Application {
    private final ListView<String> questionList = new ListView<>();
    private final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Set up the text fields with better styling
        TextField questionField = new TextField();
        questionField.setPromptText("Type your question...");
        questionField.setStyle("-fx-background-color: #ffb6c1; -fx-text-fill: #000000; -fx-font-size: 14px; -fx-padding: 10px; -fx-border-radius: 15px;");
        
        TextField nameField = new TextField();
        nameField.setPromptText("Your name...");
        nameField.setStyle("-fx-background-color: #ffb6c1; -fx-text-fill: #000000; -fx-font-size: 14px; -fx-padding: 10px; -fx-border-radius: 15px;");
        
        // Set up the buttons with rounded corners and hover effects
        Button askBtn = new Button("Ask");
        askBtn.setStyle("-fx-background-color: #ff1493; -fx-text-fill: white; -fx-font-size: 14px; -fx-border-radius: 10px; -fx-padding: 10px;");
        Button refreshBtn = new Button("Refresh");
        refreshBtn.setStyle("-fx-background-color: #ff1493; -fx-text-fill: white; -fx-font-size: 14px; -fx-border-radius: 10px; -fx-padding: 10px;");
        Button upvoteBtn = new Button("Upvote Selected");
        upvoteBtn.setStyle("-fx-background-color: #ff1493; -fx-text-fill: white; -fx-font-size: 14px; -fx-border-radius: 10px; -fx-padding: 10px;");
        
        askBtn.setOnAction(e -> askQuestion(nameField.getText(), questionField.getText()));
        refreshBtn.setOnAction(e -> loadQuestions());
        upvoteBtn.setOnAction(e -> upvoteSelected());

        // Create a scrollable list view for questions
        questionList.setStyle("-fx-background-color: #ffe4e1; -fx-border-radius: 10px;");
        ScrollPane scrollPane = new ScrollPane(questionList);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(200);

        // Create a VBox layout with padding and spacing for alignment
        VBox layout = new VBox(20, questionField, nameField, askBtn, refreshBtn, scrollPane, upvoteBtn);
        layout.setStyle("-fx-background-color: #ffb6c1; -fx-padding: 20px;");
        layout.setAlignment(Pos.CENTER);
        
        // Set up the scene
        Scene scene = new Scene(layout, 500, 400);
        scene.setFill(Color.PINK);
        stage.setScene(scene);
        stage.setTitle("Student Panel");
        stage.show();

        loadQuestions();
    }

    private void loadQuestions() {
        try {
            URL url = new URL("http://localhost:8080/questions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            List<Question> questions = Arrays.asList(mapper.readValue(conn.getInputStream(), Question[].class));
            questionList.getItems().clear();
            for (Question q : questions) {
                questionList.getItems().add(q.getId() + ": " + q.getName() + " - " + q.getContent() + " (Upvotes: " + q.getUpvotes() + ")");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void askQuestion(String title, String content) {
        try {
            URL url = new URL("http://localhost:8080/questions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            Question q = new Question(null, title, content, 0);
            String json = mapper.writeValueAsString(q);
            conn.getOutputStream().write(json.getBytes());
            conn.getOutputStream().flush(); // ✅ Flush
            conn.getOutputStream().close(); // ✅ Close
            System.out.println("Response Code: " + conn.getResponseCode());

            loadQuestions();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void upvoteSelected() {
        try {
            String selected = questionList.getSelectionModel().getSelectedItem();
            if (selected == null) return;
            Long id = Long.parseLong(selected.split(":")[0]);

            URL url = new URL("http://localhost:8080/questions/upvote/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true); // ✅ Needed to allow writing, even if body is empty
            conn.getOutputStream().write(new byte[0]);
            conn.getOutputStream().flush(); // Ensure request is sent
            conn.getOutputStream().close(); // Close the stream
            System.out.println("Upvote Response Code: " + conn.getResponseCode());
            loadQuestions();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static class Question {
        public Long id;
        public String title;
        public String content;
        public int upvotes;

        public Question() {}
        public Question(Long id, String title, String content, int upvotes) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.upvotes = upvotes;
        }

        public Long getId() {
            return id;
        }

        public int getUpvotes() {
            return upvotes;
        }

        public String getName() {
            return title;
        }

        public String getContent() {
            return content;
        }
    }
}
