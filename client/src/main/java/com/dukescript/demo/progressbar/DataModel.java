package com.dukescript.demo.progressbar;

import java.util.Timer;
import java.util.TimerTask;
import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.Property;

@Model(className = "Data", targetId = "", properties = {
    @Property(name = "percentage", type = double.class),
    @Property(name = "title", type = String.class)
    
})
final class DataModel {

    private static Data ui;

    /**
     * Called when the page is ready.
     */
    static void onPageLoad() throws Exception {
        ui = new Data(0.0, "Click here");
        ui.applyBindings();
    }

    @Function
    static void start(final Data data) {
        data.setTitle("Running");
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(data.getPercentage()>=99) timer.cancel();
                data.setPercentage(data.getPercentage()+1.0);                
            }
        }, 0, 200);
        
    }
}
