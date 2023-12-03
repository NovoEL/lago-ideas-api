package xyz.lagosoft.ideas.Projects.dto;

import com.google.common.base.Splitter;

import java.util.List;

public class SideProjectDTO {

    private String coCreatorNames;

    private String title;

    private String tagline;

    private String imageUrl;

    private String problem;

    private String solution;

    private String apiSlugs;

    private Integer hoursToBuild;

    private String demoUrl;

    private String repoUrl;

    private String stackSlugs;

    private Boolean isJamstack;

    public String getCoCreatorNames() {
        return coCreatorNames;
    }

    public void setCoCreatorNames(String coCreatorNames) {
        this.coCreatorNames = coCreatorNames;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getApiSlugs() {
        return apiSlugs;
    }

    public void setApiSlugs(String apiSlugs) {
        this.apiSlugs = apiSlugs;
    }

    public Integer getHoursToBuild() {
        return hoursToBuild;
    }

    public void setHoursToBuild(Integer hoursToBuild) {
        this.hoursToBuild = hoursToBuild;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public String getStackSlugs() {
        return stackSlugs;
    }

    public void setStackSlugs(String stackSlugs) {
        this.stackSlugs = stackSlugs;
    }

    public Boolean getJamstack() {
        return isJamstack;
    }

    public void setJamstack(Boolean jamstack) {
        isJamstack = jamstack;
    }

    public List<String> getCoCreatorNameList() {
        return Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList(coCreatorNames);
    }

    public List<String> getAPISlugList() {
        return Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList(apiSlugs);
    }

    public List<String> getStackSlugList() {
        return Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList(stackSlugs);
    }
}
