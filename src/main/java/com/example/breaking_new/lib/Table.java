package com.example.breaking_new.lib;


import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Table {
    final private String url;
    private List entries;

    /**
     * constructor
     * @param url - link of xml website
     */
    public Table(String url){
        this.url = url;
        entries = null;
    }
    public java.lang.Object getTable() throws IOException {
        try {
            URL url = new URL(this.url);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(url));
            entries = feed.getEntries();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return entries;
        }


    }

}
