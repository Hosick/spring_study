package springbook.learningtest.factorybean;

public class Message {

  String text;

  private Message(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }

  public static Message newMessage(String text) {
    return newMessage(text);
  }
}
