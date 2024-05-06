package com.test.automation.api.pojo;

import java.util.List;
import lombok.Data;

@Data
public class MessageResponse {
    String id;
    String threadId;
    List<Labels> labelIds;
}
