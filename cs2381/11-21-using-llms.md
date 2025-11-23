
# Using LLMs

## How to use LLM from app

- Embed the LLM in the app.
  - Use a library like Python's transformers; many clones in other languages.
  - Use llama.cpp as library.
- Call out to an API.
  - llama-server
  - VLLM
  - Remote API service

## Structured Data Problem

- int countAnimals(Picture picture);
- LanguageText countAnimals(LanguageText, Picture);

## Solutions

- Ask for structured data.
- Use a library like langchan4j that asks for structured data for us.

## Idea: Tool calling

Example: An AI weatherperson.

Question: What will the weather be like tomorrow?

We can give the language model access to "tools", or "functions" that
it can request we call before it gives its full answer.

System prompt:

You have access to the following tools:

- get_location() -> current location
- get_date() -> get today's date
- check_weather(location, date) -> weather for location and date

Example chat:

- System: You've got tools...
- User: What will the weather be like tomorrow?
- Assistant: do tool call get_location()
- User: tool response: Plymouth NH
- Assistant: do tool call get_date()
- User: tool response: 2025-11-21
- Assistant: do tool call check_weather(Plymouth NH, 2025-11-22)
- User: tool response: cold again
- Assistant: The weather tomorrow will be cold again. (snowman emoji)

You have access to the following tools:

- throw_water_balloon(target) - Use a robot arm to throw a water balloon
  at a target
- send_email()
- make_http_request()

## Agents

- An agent is a LLM set up with tool calling and stuff
  that runs periodically or continually trying to accomplish tasks
  autonomously.
