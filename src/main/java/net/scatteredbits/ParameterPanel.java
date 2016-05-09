package net.scatteredbits;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EnumChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import java.util.Arrays;

public class ParameterPanel extends Panel {

    private IModel<Color> colorModel;
    private IModel<Age> ageModel;
    private Component[] componentsToRerender;

	public ParameterPanel(String id, IModel<Color> colorModel, IModel<Age> ageModel, Component... componentsToRerender) {
		super(id);
        this.colorModel = colorModel;
        this.ageModel = ageModel;
        this.componentsToRerender = componentsToRerender;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();


        Form<?> form = new Form<Void>("form") {
            @Override
            protected void onSubmit() {
            }
        };

        form.add(new DropDownChoice<Color>("colors", colorModel, Arrays.asList(Color.values()), new EnumChoiceRenderer<Color>(this)));
        form.add(new DropDownChoice<Age>("ages", ageModel, Arrays.asList(Age.values()), new EnumChoiceRenderer<Age>(this)));

        final Button button = new AjaxButton("ajaxFormButton"){
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
//                super.onSubmit(target, form);
                if(componentsToRerender != null && componentsToRerender.length > 0) {
                    target.add(componentsToRerender);
                }
            }
        };

//        button.add(new AjaxEventBehavior("onclick") {
//            @Override
//            protected void onEvent(final AjaxRequestTarget target) {
//                System.out.println("Event");
//                if(componentsToRerender != null && componentsToRerender.length > 0) {
//                    target.add(componentsToRerender);
//                }
//            }
//        });

        form.add(button);

        add(form);
    }
}
