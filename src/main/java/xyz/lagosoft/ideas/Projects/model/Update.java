package xyz.lagosoft.ideas.Projects.model;

import xyz.lagosoft.ideas.Projects.dto.UpdateDTO;
import xyz.lagosoft.ideas.common.BaseEntityB;
import jakarta.persistence.Table;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Entity;

@Entity
@Table(name = "updates")
public class Update extends BaseEntityB {

    private Long projectId;

    private String title;

    private String imageUrl;

    private String body;

    public Update(UpdateDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

    public Update() {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
