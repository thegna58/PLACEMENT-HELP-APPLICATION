package com.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class StudentPanelController {
    @FXML
    private TextField questionField, nameField;

    @FXML
    private ListView<String> questionList;

    private final ObjectMapper mapper = new ObjectMapper();

    @FXML
    public void initialize() {
        loadQuestions();
    }

    @FXML
    public void loadQuestions() {
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

    @FXML
    public void askQuestion() {
        try {
            URL url = new URL("http://localhost:8080/questions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            Question q = new Question(null, nameField.getText(), questionField.getText(), 0);
            String json = mapper.writeValueAsString(q);
            conn.getOutputStream().write(json.getBytes());
            conn.getOutputStream().flush(); // ✅ Flush
            conn.getOutputStream().close(); // ✅ Close


            loadQuestions();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void upvoteSelected() {
        try {
            String selected = questionList.getSelectionModel().getSelectedItem();
            if (selected == null) return;
            Long id = Long.parseLong(selected.split(":")[0]);

            URL url = new URL("http://localhost:8080/questions/upvote/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.getOutputStream().flush(); // Ensure request is sent
            conn.getOutputStream().close(); // Close the stream
            loadQuestions();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static class Question {
        private Long id;
        private String title;
        private String content;
        private int upvotes;

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

        public String getName() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public int getUpvotes() {
            return upvotes;
        }
    }
}
