package PojoWorking2;

import java.util.List;

public class Courses {

    private List <WebAutomation> webAutomation;
    private List <Api> api;
    private List <Mobile> mobile;

    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(WebAutomation webAutomation) {
        this.webAutomation = (List<WebAutomation>) webAutomation;
    }

    public List<Api> getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = (List<Api>) api;
    }

    public Mobile getMobile() {
        return (Mobile) mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = (List<Mobile>) mobile;
    }


}
