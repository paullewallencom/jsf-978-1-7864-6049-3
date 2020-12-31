package book.beans;

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
        flowBuilder.viewNode("no-tournament-id", "/" + flowId + "/notournament.xhtml");
        flowBuilder.viewNode("confirm-rg-id", "/" + flowId + "/confirm_rg.xhtml");
        flowBuilder.viewNode("confirm-wb-id", "/" + flowId + "/confirm_wb.xhtml");
        flowBuilder.viewNode("confirm-us-id", "/" + flowId + "/confirm_us.xhtml");
        flowBuilder.viewNode("confirm-ao-id", "/" + flowId + "/confirm_ao.xhtml");

        flowBuilder.returnNode("taskFlowReturnDone").fromOutcome("#{registrationBean.returnValue}");

        flowBuilder.switchNode("confirm-switch-id").
                defaultOutcome("no-tournament-id").
                switchCase().
                condition("#{registrationBean.tournamentName eq 'Roland Garros'}").fromOutcome("confirm-rg-id").
                switchCase().
                condition("#{registrationBean.tournamentName eq 'Wimbledon'}").fromOutcome("confirm-wb-id").
                switchCase().
                condition("#{registrationBean.tournamentName eq 'US Open'}").fromOutcome("confirm-us-id").
                switchCase().
                condition("#{registrationBean.tournamentName eq 'Australian Open'}").fromOutcome("confirm-ao-id");
        
        flowBuilder.initializer("#{registrationBean.tournamentInitialize(param['tournamentNameId'], param['tournamentPlaceId'])}");
        flowBuilder.finalizer("#{registrationBean.tournamentFinalize()}");

        return flowBuilder.getFlow();
    }
}
