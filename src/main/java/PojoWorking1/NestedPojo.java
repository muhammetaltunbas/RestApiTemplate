package PojoWorking1;

import java.util.List;

public class NestedPojo {

    private String domain;
    private String url;
    private List<CoursesNested> courses;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CoursesNested getCourses() {
        return (CoursesNested) courses;
    }

    public void setCourses(CoursesNested courses) {
        this.courses = (List<CoursesNested>) courses;
    }


}
