/*
 * Copyright (C) 2011 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.ros.topic;

import java.net.URL;

import org.ros.node.server.SlaveIdentifier;

/**
 * @author damonkohler@google.com (Damon Kohler)
 */
public class PublisherIdentifier {

  private final SlaveIdentifier slaveIdentifier;
  private final TopicDefinition topicDefinition;

  public PublisherIdentifier(SlaveIdentifier slaveIdentifier, TopicDefinition topicDefinition) {
    this.slaveIdentifier = slaveIdentifier;
    this.topicDefinition = topicDefinition;
  }

  public SlaveIdentifier getSlaveIdentifier() {
    return slaveIdentifier;
  }

  public String getNodeName() {
    return slaveIdentifier.getName();
  }

  public URL getSlaveUrl() {
    return slaveIdentifier.getUrl();
  }

  public String getTopicName() {
    return topicDefinition.getName();
  }

  @Override
  public String toString() {
    return "PublisherIdentifier<" + slaveIdentifier.toString() + ", "
        + topicDefinition.toString() + ">";
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((slaveIdentifier == null) ? 0 : slaveIdentifier.hashCode());
    result = prime * result + ((topicDefinition == null) ? 0 : topicDefinition.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    PublisherIdentifier other = (PublisherIdentifier) obj;
    if (slaveIdentifier == null) {
      if (other.slaveIdentifier != null) return false;
    } else if (!slaveIdentifier.equals(other.slaveIdentifier)) return false;
    if (topicDefinition == null) {
      if (other.topicDefinition != null) return false;
    } else if (!topicDefinition.equals(other.topicDefinition)) return false;
    return true;
  }

}