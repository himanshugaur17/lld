package api;

import api.impl.DefaultShortningStrategy;
import api.impl.SQLUrlRepositoryImpl;

public class UrlShortner {

    private final IShortnerAlgo shortningStratey = new DefaultShortningStrategy();
    private final IUrlRepository urlRepository = new SQLUrlRepositoryImpl();

    public String shortenTheUrl(String longUrl) {
        String shortUrl = shortningStratey.shortenTheURL(longUrl);
        urlRepository.persistShortToLongUrlMapping(shortUrl, longUrl);
        return shortUrl;
    }

    public String getLongUrl(String tinyUrl) {
        return urlRepository.getLongUrl(tinyUrl);
    }
}
