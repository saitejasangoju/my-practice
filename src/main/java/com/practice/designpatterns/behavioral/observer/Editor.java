package com.practice.designpatterns.behavioral.observer;

import java.io.File;

public class Editor {
    
    public EventManager eventManager;
    private File file;
    
    public Editor() {
        this.eventManager = new EventManager("open", "save");
    }
    
    public void openFile(String filePath) {
        this.file = new File(filePath);
        eventManager.notify("open", file);
    }
    
    public void saveFile() throws Exception {
        if(this.file == null) {
            throw new Exception("Please open a file first.");
        }
        eventManager.notify("save", file);
    }

}
