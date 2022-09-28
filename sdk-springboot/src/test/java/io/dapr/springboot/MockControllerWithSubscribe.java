/*
 * Copyright 2022 The Dapr Authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package io.dapr.springboot;

import io.dapr.Topic;
import io.dapr.springboot.annotations.BulkSubscribe;
import org.springframework.web.bind.annotation.PostMapping;

public class MockControllerWithSubscribe {
  public static final String pubSubName = "mockPubSub";
  public static final String topicName = "mockTopic";
  public static final String bulkTopicName = "mockBulkTopic";
  public static final String bulkTopicNameV2 = "mockBulkTopicV2";
  public static final String subscribeRoute = "mockRoute";
  public static final String bulkSubscribeRoute = "mockBulkRoute";
  public static final String bulkSubscribeRouteV2 = "mockBulkRouteV2";
  public static final int maxBulkSubCount = 500;
  public static final int maxBulkSubAwaitDurationMs = 1000;

  @Topic(name = topicName, pubsubName = pubSubName)
  @PostMapping(path = subscribeRoute)
  public void handleMessages() {}

  @BulkSubscribe(maxBulkSubCount = maxBulkSubCount, maxBulkSubAwaitDurationMs = maxBulkSubAwaitDurationMs)
  @Topic(name = bulkTopicName, pubsubName = pubSubName)
  @PostMapping(path = bulkSubscribeRoute)
  public void handleBulkMessages() {}

  @BulkSubscribe(maxBulkSubCount = maxBulkSubCount, maxBulkSubAwaitDurationMs = maxBulkSubAwaitDurationMs)
  @Topic(name = bulkTopicNameV2, pubsubName = pubSubName, metadata = "{\"maxBulkSubAwaitDurationMs\": 5}")
  @PostMapping(path = bulkSubscribeRouteV2)
  public void handleBulkMessagesV2() {}
}
