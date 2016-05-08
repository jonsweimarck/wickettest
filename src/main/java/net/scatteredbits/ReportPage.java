package net.scatteredbits;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Arrays;

public class ReportPage extends WebPage {
	private static final long serialVersionUID = 1L;

	private String selectedAge = "ALL";

	public ReportPage(final PageParameters parameters) {
		super(parameters);

		final ReportModel reportModel = new ReportModel();

		Form<?> form = new Form<Void>("form") {
			@Override
			protected void onSubmit() {

				System.out.println("dfgdfgdfgdfg : " + selectedAge);
				reportModel.update(selectedAge);
			}
		};


		DropDownChoice<String> ages = new DropDownChoice<String>(
				"ages",
				new PropertyModel<String>(this, "selectedAge"), Arrays.asList(new String[] {"ALL", "31-40", "41-50" }));

		form.add(ages);

		add(form);


		Label label = new Label("report", reportModel);

		add(label);

    }
}
