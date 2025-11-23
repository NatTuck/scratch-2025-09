package dslabs;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.io.IOException;

import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;


public class App {
    interface Counter {
        @UserMessage("How many {{what}} are in the image?")
        int getCount(@V("what") String what, @UserMessage ImageContent img);
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new RuntimeException("specify image");
        }

        var img = new ImageContent(jpegToBase64(args[0]), "image/jpeg");

        var model = LocalModel.getModel();
        var svc = AiServices.create(Counter.class, model);

        var resp = svc.getCount("animals", img);

        System.out.println("\n\nAnimal count = " + resp);

    }

    public static String jpegToBase64(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return Base64.getEncoder().encodeToString(bytes);
    }
}
