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
package org.jboss.pnc.spi.datastore.repositories;

import org.jboss.pnc.enums.ArtifactQuality;
import org.jboss.pnc.enums.RepositoryType;
import org.jboss.pnc.model.ProductMilestone;
import org.jboss.pnc.spi.datastore.repositories.api.Repository;

import java.util.EnumMap;

/**
 * Interface for manipulating {@link org.jboss.pnc.model.ProductMilestone} entity.
 */
public interface ProductMilestoneRepository extends Repository<ProductMilestone, Integer> {

    long countBuiltArtifactsInMilestone(Integer id);

    long countDeliveredArtifactsBuiltInThisMilestone(Integer id);

    long countDeliveredArtifactsBuiltInOtherMilestones(Integer id);

    long countDeliveredArtifactsBuiltByOtherProducts(Integer id);

    long countDeliveredArtifactsBuiltInNoMilestone(Integer id);

    long countDeliveredArtifactsNotBuilt(Integer id);

    EnumMap<ArtifactQuality, Long> getArtifactQualitiesCounts(Integer id);

    EnumMap<RepositoryType, Long> getRepositoryTypesCounts(Integer id);
}
