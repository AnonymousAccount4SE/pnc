package org.jboss.pnc.rest.restmodel;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.jboss.pnc.model.RepositoryConfiguration;
import org.jboss.pnc.rest.validation.groups.WhenCreatingNew;
import org.jboss.pnc.rest.validation.groups.WhenUpdating;
import org.jboss.pnc.rest.validation.validators.ScmUrl;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The REST entity that contains configuration of the SCM repositories.
 *
 * @author Jakub Bartecek
 */
@XmlRootElement(name = "RepositoryConfiguration")
public class RepositoryConfigurationRest implements GenericRestEntity<Integer> {

    @NotNull(groups = WhenUpdating.class)
    @Null(groups = WhenCreatingNew.class)
    private Integer id;

    @Getter
    @Setter
    @NotBlank(groups = {WhenUpdating.class, WhenCreatingNew.class})
    @ScmUrl(groups = {WhenUpdating.class, WhenCreatingNew.class} )
    private String internalScmRepoUrl;

    @Getter
    @Setter
    @ScmUrl(groups = {WhenUpdating.class, WhenCreatingNew.class} )
    private String externalScmRepoUrl;

    @Getter
    @Setter
    private boolean preBuildSyncEnabled;

    public RepositoryConfigurationRest() {
    }

    public RepositoryConfigurationRest(RepositoryConfiguration repositoryConfiguration) {
        this.id = repositoryConfiguration.getId();
        this.internalScmRepoUrl = repositoryConfiguration.getInternalScmRepoUrl();
        this.externalScmRepoUrl = repositoryConfiguration.getExternalScmRepoUrl();
        this.preBuildSyncEnabled = repositoryConfiguration.getPreBuildSyncEnabled();
    }

    /**
     * Gets Id.
     *
     * @return Id.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id id.
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public RepositoryConfiguration.Builder toDBEntityBuilder() {
        RepositoryConfiguration.Builder builder = RepositoryConfiguration.Builder.newBuilder()
                .id(id)
                .internalScmRepoUrl(internalScmRepoUrl)
                .externalScmRepoUrl(externalScmRepoUrl)
                .preBuildSyncEnabled(preBuildSyncEnabled);
        return builder;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepositoryConfigurationRest that = (RepositoryConfigurationRest) o;

        if (isPreBuildSyncEnabled() != that.isPreBuildSyncEnabled()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getInternalScmRepoUrl().equals(that.getInternalScmRepoUrl())) return false;
        return getExternalScmRepoUrl() != null ? getExternalScmRepoUrl().equals(that.getExternalScmRepoUrl()) : that.getExternalScmRepoUrl() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getInternalScmRepoUrl().hashCode();
        result = 31 * result + (getExternalScmRepoUrl() != null ? getExternalScmRepoUrl().hashCode() : 0);
        result = 31 * result + (isPreBuildSyncEnabled() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RepositoryConfigurationRest{" +
                "id=" + id +
                ", internalScmRepoUrl='" + internalScmRepoUrl + '\'' +
                ", externalScmRepoUrl='" + externalScmRepoUrl + '\'' +
                ", preBuildSyncEnabled=" + preBuildSyncEnabled +
                '}';
    }
}
