package frc.lib;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;

public class JsonParser {

    public void parseJson(String path) {
        try {
            // Replace this with the path to your JSON file
            File jsonFile = new File(path);

            // Parse the JSON file
            parseJsonFile(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseJsonFile(File jsonFile) throws IOException {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON file into JsonNode tree structure
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        // Assuming your JSON is an array of objects
        if (rootNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) rootNode;

            // Iterate over each object in the array
            for (JsonNode node : arrayNode) {
                // Example: Extracting "Pulse Width (us)" and "Pattern" fields
                int pulseWidth = node.get("Pulse Width (us)").asInt();
                String pattern = node.get("Pattern").asText();

                // Do something with the extracted data
                System.out.println("Pulse Width: " + pulseWidth);
                System.out.println("Pattern: " + pattern);
                System.out.println("---------------------");
            }
        } else {
            System.out.println("JSON root is not an array.");
        }
    }
}
