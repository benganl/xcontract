package za.co.wyzetech.cms.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowState {
    String payload;
    String businessKey;
    String processId;
    // String event;
}
