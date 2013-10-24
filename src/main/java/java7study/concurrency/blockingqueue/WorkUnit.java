package java7study.concurrency.blockingqueue;

/**
 * User: jinyanhua
 * Date: 13-10-24
 * Time: 上午10:28
 */
public class WorkUnit {
    private String name;
    private Long planCostTime;
    private String content;

    public WorkUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPlanCostTime() {
        return planCostTime;
    }

    public void setPlanCostTime(Long planCostTime) {
        this.planCostTime = planCostTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
