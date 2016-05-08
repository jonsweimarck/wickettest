package net.scatteredbits;

import org.apache.wicket.model.LoadableDetachableModel;

/**
 * Created by jons on 08/05/16.
 */
public class ReportModel extends LoadableDetachableModel<String>{

    private static int counter = 0;
    private String age;

    public void update(String newAge){
        age = newAge;
    }

    @Override
    protected String load() {
        return age + "_LOADED " + counter++;
    }
}
