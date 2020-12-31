package beans;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

/**
 *
 * @author Anghel Leonard
 */
public class Registration implements Serializable {        

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        
        String flowId = "registration";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();

        flowBuilder.returnNode("taskFlowReturnIndex").fromOutcome("/index");
        flowBuilder.returnNode("taskFlowReturnDone").fromOutcome("#{registrationBean.returnValue}");                
        
        return flowBuilder.getFlow();
    }
}
