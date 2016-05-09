package net.scatteredbits;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ReportPage extends WebPage {
	private static final long serialVersionUID = 1L;

    private IModel<Color> colorModel = new Model<Color>();
    private IModel<Age> ageModel = new Model<Age>();

	public ReportPage(final PageParameters parameters) {
		super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();


        ReportModel reportModel = new ReportModel(colorModel, ageModel);

        final Label label = new Label("report", reportModel);
        label.setOutputMarkupId(true); // To be able to update with Ajax

        ParameterPanel paramPanel = new ParameterPanel("paramPanel", colorModel, ageModel, label);
        add(paramPanel);



//        final Button button = new Button("ajaxButton");
//        button.add(new AjaxEventBehavior("onclick") {
//            @Override
//            protected void onEvent(final AjaxRequestTarget target) {
//                System.out.println("Event");
//                target.add(label);
//            }
//        });
//
//        add(button);

        add(label);
    }
}
