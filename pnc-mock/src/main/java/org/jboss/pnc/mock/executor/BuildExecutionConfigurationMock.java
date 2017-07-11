/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
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

package org.jboss.pnc.mock.executor;

import org.jboss.pnc.model.SystemImageType;
import org.jboss.pnc.spi.executor.BuildExecutionConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:matejonnet@gmail.com">Matej Lazar</a>
 */
public class BuildExecutionConfigurationMock implements BuildExecutionConfiguration {

    private int id;
    private String buildContentId;
    private Integer userId;
    private String buildScript;
    private String name;
    private String scmRepoURL;
    private String scmRevision;
    private String originRepoURL;
    private boolean preBuildSyncEnabled;
    private String systemImageId;
    private String systemImageRepositoryUrl;
    private SystemImageType systemImageType;
    
    private Map<String, String> genericParameters;

    public static BuildExecutionConfiguration mockConfig() {
        BuildExecutionConfigurationMock mock = new BuildExecutionConfigurationMock();
        mock.setId(1);
        mock.setBuildScript("mvn install");
        mock.setScmRepoURL("http://www.github.com");
        mock.setScmRevision("1234567890");
        mock.setPreBuildSyncEnabled(false);
        mock.setSystemImageId("abcd1234");
        mock.setSystemImageRepositoryUrl("image.repo.url/repo");
        mock.setSystemImageType(SystemImageType.DOCKER_IMAGE);
        mock.setGenericParameters(new HashMap<>());
        
        return mock;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildContentId() {
        return buildContentId;
    }

    public void setBuildContentId(String buildContentId) {
        this.buildContentId = buildContentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBuildScript() {
        return buildScript;
    }

    public void setBuildScript(String buildScript) {
        this.buildScript = buildScript;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScmRepoURL() {
        return scmRepoURL;
    }

    public void setScmRepoURL(String scmRepoURL) {
        this.scmRepoURL = scmRepoURL;
    }

    public String getScmRevision() {
        return scmRevision;
    }

    public String getOriginRepoURL() {
        return originRepoURL;
    }

    public void setOriginRepoURL(String originRepoURL) {
        this.originRepoURL = originRepoURL;
    }

    public void setScmRevision(String scmRevision) {
        this.scmRevision = scmRevision;
    }

    public boolean isPreBuildSyncEnabled() {
        return preBuildSyncEnabled;
    }

    public void setPreBuildSyncEnabled(boolean preBuildSyncEnabled) {
        this.preBuildSyncEnabled = preBuildSyncEnabled;
    }

    public String getSystemImageId() {
        return systemImageId;
    }
    public void setSystemImageId(String systemImageId) {
        this.systemImageId = systemImageId;
    }
    public String getSystemImageRepositoryUrl() {
        return systemImageRepositoryUrl;
    }
    public void setSystemImageRepositoryUrl(String systemImageRepositoryUrl) {
        this.systemImageRepositoryUrl = systemImageRepositoryUrl;
    }
    public SystemImageType getSystemImageType() {
        return systemImageType;
    }

    @Override
    public boolean isPodKeptOnFailure() {
        return false;
    }

    public void setSystemImageType(SystemImageType systemImageType) {
        this.systemImageType = systemImageType;
    }

    @Override
    public Map<String, String> getGenericParameters() {
        return genericParameters;
    }
    
    public void setGenericParameters(Map<String, String> genericParameters) {
        this.genericParameters = genericParameters;
    }

}
