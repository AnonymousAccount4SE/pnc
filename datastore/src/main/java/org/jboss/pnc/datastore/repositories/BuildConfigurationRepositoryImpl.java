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
package org.jboss.pnc.datastore.repositories;

import org.jboss.pnc.common.json.moduleconfig.AlignmentConfig;
import org.jboss.pnc.datastore.repositories.internal.AbstractRepository;
import org.jboss.pnc.model.AlignStrategy;
import org.jboss.pnc.model.BuildConfiguration;
import org.jboss.pnc.spi.datastore.repositories.BuildConfigurationRepository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Map;

import static org.jboss.pnc.api.constants.Defaults.GLOBAL_SCOPE;

@Stateless
public class BuildConfigurationRepositoryImpl extends AbstractRepository<BuildConfiguration, Integer>
        implements BuildConfigurationRepository {

    private AlignmentConfig alignmentConfig;

    /**
     * @deprecated Created for CDI.
     */
    @Deprecated
    public BuildConfigurationRepositoryImpl() {
        super(BuildConfiguration.class, Integer.class);
    }

    @Inject
    public BuildConfigurationRepositoryImpl(AlignmentConfig alignmentConfig) {
        super(BuildConfiguration.class, Integer.class);
        this.alignmentConfig = alignmentConfig;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public BuildConfiguration save(BuildConfiguration buildConfiguration) {
        // Update or save need to set the default alignment parameters
        buildConfiguration.setDefaultAlignmentParams(
                alignmentConfig.getAlignmentParameters().get(buildConfiguration.getBuildType().toString()));

        // In case of null key, map the key to default value which is global scope (GLOBAL)
        Map<String, AlignStrategy> alignStrats = buildConfiguration.getAlignStrategies();
        if (alignStrats != null && alignStrats.containsKey(null)) {
            AlignStrategy def = alignStrats.remove(null);
            alignStrats.put(GLOBAL_SCOPE, def);
        }

        return super.save(buildConfiguration);
    }

    private boolean areParametersEqual(BuildConfiguration persisted, BuildConfiguration newBC) {
        if (persisted.getGenericParameters() == null && newBC.getGenericParameters() == null) {
            return true;
        }

        if (persisted.getGenericParameters() == null || newBC.getGenericParameters() == null) {
            return false;
        }

        return persisted.getGenericParameters().equals(newBC.getGenericParameters());
    }

}
