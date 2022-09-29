/*
 * Copyright 2021 The Dapr Authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
limitations under the License.
*/

package io.dapr.springboot.domain;

import java.util.Map;

/**
 * Represents a single event from a bulk of messages sent by the message bus.
 * @param <T> Type of event.
 */
public class DaprBulkMessageEntry<T> {
  public String entryID;
  public T event;
  public String contentType;

  public Map<String, String> metadata;

  public DaprBulkMessageEntry() {
  }

  /**
   * Create a DaprBulkMessageEntry.
   * @param entryID unique identifier for the event.
   * @param event pubSub event.
   * @param contentType content type of the event.
   * @param metadata metadata for the event.
   */
  public DaprBulkMessageEntry(String entryID, T event, String contentType, Map<String, String> metadata) {
    this.entryID = entryID;
    this.event = event;
    this.contentType = contentType;
    this.metadata = metadata;
  }

  public String getEntryID() {
    return entryID;
  }

  public T getEvent() {
    return event;
  }

  public String getContentType() {
    return contentType;
  }

  public Map<String, String> getMetadata() {
    return metadata;
  }
}
