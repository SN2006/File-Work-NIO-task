package app.controller;

import app.model.AppModel;
import app.util.Constants;
import app.view.AppView;

public class AppController {

    private final AppView appView = new AppView();
    private final AppModel appModel = new AppModel();

    public void run(){
        appView.getOutput(
                handleData(appView.selectAction())
        );
    }

    public String handleData(String selectedAction){
        String filename, content, newFilename;
        switch (selectedAction){
            case "1" -> {
                filename = filenameConversion(appView.getFilename());
                content = appView.getContent();
                return appModel.writeToFile(filename, content);
            }
            case "2" -> {
                filename = filenameConversion(appView.getFilename());
                return appModel.readFile(filename);
            }
            case "3" -> {
                filename = filenameConversion(appView.getFilename());
                return appModel.deleteFile(filename);
            }
            case "4" -> {
                filename = filenameConversion(appView.getFilename());
                newFilename = filenameConversion(appView.getNewFilename());
                return appModel.renameFile(filename, newFilename);
            }
            case "0" ->{
                return "Exit...";
            }
            default -> {
                return "You have chosen a non-existent option!";
            }
        }
    }

    private String filenameConversion(String filename){
        return Constants.BASE_PATH + filename + ".txt";
    }

}
