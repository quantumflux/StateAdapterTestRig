package com.mig.panasonic.test.statechangemanagement;

public class EventDefinitions {

    /**
     * 
     * @author Alis
     *
     * Enumerating the event type independent of the data to use to populate the resulting view - i.e. DETAIL_PAGE may mean
     * a movie page, a book page, a web page etc. dependent on context and the data sent through
     *
     */
    public static enum EventName {
        
        PRIMARY_CAROUSEL, SECONDARY_CAROUSEL, DETAIL_PAGE, MORE_EVENTS_HERE
        
    }
    
}
