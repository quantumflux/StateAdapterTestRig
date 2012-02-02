package com.mig.panasonic.test.statechangemanagement;

/** @author Alis
 * 
 *         Defines the available states for each stateful item */
public class StateDefinitions {

    public static enum StateSetName {

        DASHBOARD(new StateName[] { StateName.HIDDEN, StateName.SHOWN }), CONTENT(new StateName[] { StateName.HOME, StateName.MOVIE, StateName.MOVIE_DETAIL, StateName.BOOK, StateName.BOOK_DETAIL }), NAVBAR(new StateName[] { StateName.HIDDEN,
                StateName.SHOWN });

        private StateName[] states;

        StateSetName(StateName[] states) {

            this.states = states.clone();

        }

        public StateName[] getStates() {

            return this.states;

        }
        
        public StateName getState(int index){
            
            if (index < this.states.length && index >= 0){
                
                return this.states[index];
                
            } else {
                
                return null;
                
            }
            
        }

    }

    public static enum StateName {

        HIDDEN, SHOWN, HOME, MOVIE, MOVIE_DETAIL, BOOK, BOOK_DETAIL

    }

    public static enum GUIEventName {

        HIDE, SHOW, HOME, MOVIE, MOVIE_DETAIL, BOOK, BOOK_DETAIL

    }

}
