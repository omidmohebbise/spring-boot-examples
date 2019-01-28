package omid.spring.example.springexample.qulifire;

import org.springframework.stereotype.Component;

@Component
public class SimpleBean {
    public String attr1;
    public String attr2;


    public SimpleBean() {
    }

    public SimpleBean(String attr1, String attr2) {
        this.attr1 = attr1;
        this.attr2 = attr2;
    }



    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }
}


