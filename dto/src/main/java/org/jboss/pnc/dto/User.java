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
package org.jboss.pnc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import org.jboss.pnc.common.validator.NoHtml;
import org.jboss.pnc.dto.validation.groups.WhenCreatingNew;
import org.jboss.pnc.dto.validation.groups.WhenUpdating;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * A PNC user.
 *
 * @author Jakub Bartecek &lt;jbartece@redhat.com&gt;
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
@JsonDeserialize(builder = User.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements DTOEntity {

    /**
     * ID of the user.
     */
    @NotNull(groups = WhenUpdating.class)
    @Null(groups = WhenCreatingNew.class)
    @NoHtml
    protected final String id;

    /**
     * Username of the user.
     */
    @NoHtml
    protected final String username;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
    }
}
