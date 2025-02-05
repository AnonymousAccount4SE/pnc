/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2014-2022 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.pnc.remotecoordinator.builder;

import org.jboss.pnc.model.User;
import org.jboss.pnc.spi.coordinator.RemoteBuildTask;
import org.jboss.pnc.spi.exception.RemoteRequestException;
import org.jboss.pnc.spi.exception.ScheduleException;
import org.jboss.util.graph.Graph;

public interface RexBuildScheduler {

    /**
     *
     * @param buildGraph
     * @param user
     * @param buildConfigSetRecordId group recordId or null if it is not a group build
     * @throws ScheduleException
     */
    void startBuilding(Graph<RemoteBuildTask> buildGraph, User user, Long buildConfigSetRecordId)
            throws ScheduleException;

    void cancel(String taskId) throws RemoteRequestException;
}
