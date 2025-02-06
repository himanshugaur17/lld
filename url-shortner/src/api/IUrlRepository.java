package api;

public interface IUrlRepository {

    boolean persistShortToLongUrlMapping(String tinyUrl, String actualUrl);

    String getLongUrl(String tinyUrl);

}
