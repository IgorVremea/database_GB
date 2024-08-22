package presenter;

import model.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view){
        this.view = view;
        this.service = new Service();
    }
}
