package de.deeply.java_demo;

import de.deeply.Content;
import de.deeply.Image;
import de.deeply.Object;
import de.deeply.Processor;

/**
 * Basic OnContentListener implementation to print results to console.
 */
public class ContentListener extends Processor.OnContentListener {

    /**
     * Implements the base listeners OnContent method.
     */
    public void OnContent(Content content, Image image) {

        System.out.println( "Found faces: " + content.GetObjectCount()
                            + " ( in " + content.GetInfoByKey( "ProcessingTime") + " s )"  );

        for( long i = 0; i < content.GetObjectCount(); ++i ) {

            Object o = content.GetObject( i );

            System.out.println( " Type: " +  o.GetType() + " Gender: " + o.GetAttributeByKey( "Gender")
                                                         + " Happy: " + o.GetRatingByKey( "Happy" ) );
        }
    }
}
