package com.mig.panasonic.test.statechangemanagement;

/** @author Alis
 * 
 *         Class to encapsulate the data being passed as part of a raised event
 * 
 *         Currently this is the id of the item referred to by the event
 * 
 *         e.g. if the event is associated with a MOVIE_DETAIL event then the id will refer to the specific movie item selected */
public class GUIEventData {

    private String mReferencedItemId;

    public GUIEventData(String referencedItemId) {
        this.mReferencedItemId = referencedItemId;
    }

    public String getReferencedItemId() {
        return this.mReferencedItemId;
    }

}
