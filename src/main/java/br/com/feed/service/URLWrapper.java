package br.com.feed.service;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLWrapper {
    private URL url;

    public URLWrapper(String urlString) throws MalformedURLException {
        this.url = new URL(urlString);
    }

    public URLConnection openConnection() throws IOException {
        return this.url.openConnection();
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}