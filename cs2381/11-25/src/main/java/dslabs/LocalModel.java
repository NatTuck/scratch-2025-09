package dslabs;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class LocalModel {
  static ChatModel getModel() {
    return OpenAiChatModel
      .builder()
      .baseUrl("http://localhost:8080/v1")
      .apiKey("none")
      .modelName("any")
      .logRequests(true)
      .logResponses(true)
      .build();
  }
}
