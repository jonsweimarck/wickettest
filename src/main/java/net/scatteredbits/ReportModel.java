package net.scatteredbits;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 * Created by jons on 08/05/16.
 */
public class ReportModel extends LoadableDetachableModel<String> {

    private static int counter = 0;
    private IModel<Color> colorModel;
    private IModel<Age> ageModel;

    public ReportModel(IModel<Color> colorModel, IModel<Age> ageModel){
        this.colorModel = colorModel;
        this.ageModel = ageModel;
    }

    @Override
    protected String load() {
        return colorModel.getObject() + "_" + ageModel.getObject() + "_LOADED " + counter++;
    }
}
