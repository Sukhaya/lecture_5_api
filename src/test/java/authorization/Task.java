package authorization;

//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Task {
    int id;
    String key;
    boolean hidden;
    String typeId;
    String summary;
    String priorityId;
    Boolean done;
    String assignee;
    String assigneeName;
    String avatarUrl;
    boolean hasCustomUserAvatar;
    boolean estimateStatisticRequired;
    Object estimateStatistic;
    String statusId;
    ArrayList<String> fixVersions;
    int projectId;

    @JsonCreator
    public Task(
            @JsonProperty("id") int id,
            @JsonProperty("key") String key,
            @JsonProperty("hidden") boolean hidden,
            @JsonProperty("typeId") String typeId,
            @JsonProperty("summary") String summary,
            @JsonProperty("priorityId") String priorityId,
            @JsonProperty("done") Boolean done,
            @JsonProperty("assignee") String assignee,
            @JsonProperty("assigneeName") String assigneeName,
            @JsonProperty("avatarUrl") String avatarUrl,
            @JsonProperty("hasCustomUserAvatar") boolean hasCustomUserAvatar,
            @JsonProperty("estimateStatisticRequired") boolean estimateStatisticRequired,
            @JsonProperty("estimateStatistic") Object estimateStatistic,
            @JsonProperty("statusId") String statusId,
            @JsonProperty("fixVersions") ArrayList<String> fixVersions,
            @JsonProperty("projectId") int projectId) {
        this.id = id;
        this.key = key;
        this.hidden = hidden;
        this.typeId = typeId;
        this.summary = summary;
        this.priorityId = priorityId;
        this.done = done;
        this.assignee = assignee;
        this.assigneeName = assigneeName;
        this.avatarUrl = avatarUrl;
        this.hasCustomUserAvatar = hasCustomUserAvatar;
        this.estimateStatisticRequired = estimateStatisticRequired;
        this.estimateStatistic = estimateStatistic;
        this.statusId = statusId;
        this.fixVersions = fixVersions;
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Task: {\n" +
                "id: " + id + ",\n" +
                "key: " + key + ",\n" +
                "hidden: " + hidden + ",\n" +
                "typeId: " + typeId + ",\n" +
                "summary: " + summary + ",\n" +
                "priorityId: " + priorityId + ",\n" +
                "done: " + done + ",\n" +
                "assignee: " + assignee + ",\n" +
                "assigneeName: " + assigneeName + ",\n" +
                "avatarUrl: " + avatarUrl + ",\n" +
                "hasCustomUserAvatar: " + hasCustomUserAvatar + ",\n" +
                "estimateStatisticRequired: " + estimateStatisticRequired + ",\n" +
                "estimateStatistic: " + estimateStatistic + ",\n" +
                "statusId: " + statusId + ",\n" +
                "fixVersions: " + fixVersions + ",\n" +
                "projectId: " + projectId + ",\n" +
                "}\n";
    }
}


