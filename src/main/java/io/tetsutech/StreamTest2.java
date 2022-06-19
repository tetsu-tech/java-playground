package io.tetsutech;

import java.util.Objects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StreamTest2 {
  public static void main(String[] args) {

  }
}

class Event {
  private final String eventName;
  private final ActorId actorId;
  private ObjectNode values;

  public Event(String eventName, ActorId actorId, ObjectNode values) {
    this.eventName = eventName;
    this.actorId = actorId;
    this.values = values;
  }

  public String getEventName() {
    return eventName;
  }

  public ActorId actorId() {
    return actorId;
  }

  public ObjectNode getValues() {
    return values;
  }

  public JsonNode path(String field) {
    return values.path(eventName).path(field);
  }
}

class ActorId {
  private static final String SEP = "_";
  private final String apiKey;
  private final String id;

  private ActorId(String apiKey, String id) {
    this.apiKey = apiKey;
    this.id = id;
  }

  public static ActorId of(String apiKey, String id) {
    return new ActorId(apiKey, id);
  }

  public static ActorId ofVisitorId(String apiKey, String visitorId) {
    return new ActorId(apiKey, "vis-" + visitorId);
  }

  public static ActorId deserialize(String idWithApiKey) {
    String[] result = idWithApiKey.split("_", 2);
    String apiKey = result[0];
    String id = result[1];

    return new ActorId(apiKey, id);
  }

  public String serialize() {
    return apiKey + SEP + id;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ActorId actorId = (ActorId) o;

    return Objects.equals(apiKey, actorId.apiKey)
        && Objects.equals(id, actorId.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiKey, id);
  }

  @Override
  public String toString() {
    return serialize();
  }
}
