package dslabs;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.io.IOException;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.model.output.Response;


public class App1 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new RuntimeException("specify image");
        }

        var img = new ImageContent(jpegToBase64(args[0]), "image/jpeg");

        var model = LocalModel.getModel();
        UserMessage userMessage = UserMessage.from(
            TextContent.from("How many animals are there in the image?"),
            img
        );

        var resp = model.chat(userMessage);

        System.out.println("\n\nRESPONSE:\n\n");
        System.out.println(resp);
    }

    public static String jpegToBase64(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return Base64.getEncoder().encodeToString(bytes);
    }
}
