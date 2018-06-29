package de.deeply.java_demo;


import de.deeply.Camera;
import de.deeply.CameraFactory;
import de.deeply.FaceProcessorBuilder;
import de.deeply.Processor;

import java.io.IOException;
import java.util.Scanner;

public class Demo {

    static
    {
        // loading deeply lib directly required on macos due to "Configuring System Integrity Protection"
        // (protects dlopen calls for rpath etc.)
        System.loadLibrary( "deeply" );
        System.loadLibrary( "deeply-java" );
    }


    public static void main(String[] args) {
        // Use the default camera of your device
        Camera camera = CameraFactory.Instance().CreateDefault();

        if ( camera == null ) {
            System.out.println( "No camera connected to your device!");
            System.exit( 1 );
        }

        // Create a processor to find faces in video streams, analyse gender, age and happiness
        Processor processor = new FaceProcessorBuilder().VideoAnalysis()
                                                        .SearchEyes( true )
                                                        .AnalyzeGender( true )
                                                        .AnalyzeAge( true )
                                                        .AnalyzeHappy( true )
                                                        .Build();

        // Create a simple listener to output the found faces to console.
        ContentListener contentListener = new ContentListener();
        // Set is as listener in the processor
        processor.SetOnContentListener( contentListener );

        // Set the processor as image listener in the camera
        camera.SetOnImageListener( processor );

        int seconds = 10;
        System.out.println( "Start processing for " + seconds + " seconds ...");

        // Start the camera
        camera.Start();

        // Do the processing for some seconds an put the main thread to sleep.
        // The listeners get notified about new images from the camera and new results form the processor.
        try {
            Thread.sleep( seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Don't forget to stop the camera
        camera.Stop();

        try {
            Thread.sleep( 100 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
