package com.manbirsinghjaspal.top10downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ParseApplications {
    private static final String TAG = "ParseApplications";
    private ArrayList<FeedEntry> applications;

    public ParseApplications() {
        this.applications = new ArrayList<>();
    }

    public ArrayList<FeedEntry> getApplications() {
        return applications;
    }

    public boolean parse(String xmlData) {
        boolean status = true;
        FeedEntry currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance(); //These lines of code make sense of the XML code for us.
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData)); //String Red
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) { //To check if we are at the ned of the document.
                String tagName = xpp.getName(); //Checking to see inside which tag is it. or the getName() method return null if the parser isnt insidse a tag;
                switch (eventType) {
                    case XmlPullParser.START_TAG: //to check if the parser is at the start of a tag.
                        Log.d(TAG, "parse:  Starting tag for: " + tagName);
                        if ("entry".equalsIgnoreCase(tagName)) { //checking if we are inside the entry tag.
                            inEntry = true;
                            currentRecord = new FeedEntry();
                        }
                        break;

                    case XmlPullParser.TEXT: //checks if there is data in the xml
                        textValue = xpp.getText(); //retrieves the text to text value
                        break;

                    case XmlPullParser.END_TAG:
                        Log.d(TAG, "parse: Ending Tag for: " + tagName);
                        if (inEntry) {
                            if ("entry".equalsIgnoreCase(tagName)) {
                                applications.add(currentRecord);
                                inEntry = false;
                            } else if ("name".equalsIgnoreCase(tagName)) {
                                currentRecord.setName(textValue);
                            } else if ("artist".equalsIgnoreCase(tagName)) {
                                currentRecord.setArtist(textValue);
                            } else if ("releaseDate".equalsIgnoreCase(tagName)) {
                                currentRecord.setReleaseDate(textValue);
                            } else if ("summary".equalsIgnoreCase(tagName)) {
                                currentRecord.setSummary(textValue);
                            } else if ("image".equalsIgnoreCase(tagName)) {
                                currentRecord.setImagegURL(textValue);
                            }
                        }
                        break;

                        default:

                }
                eventType = xpp.next();
            }
            for (FeedEntry app: applications) {
                Log.d(TAG, "**************************");
                Log.d(TAG, app.toString());
            }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }

        return status;
    }
}
