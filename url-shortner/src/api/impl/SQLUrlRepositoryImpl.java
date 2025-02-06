package api.impl;

import java.util.HashMap;
import java.util.Map;

import api.IUrlRepository;

public class SQLUrlRepositoryImpl implements IUrlRepository {
    private Map<String, String> shortToActualMap = new HashMap<>();

    @Override
    public boolean persistShortToLongUrlMapping(String tinyUrl, String actualUrl) {
        shortToActualMap.put(tinyUrl, actualUrl);
        return true;
    }

    @Override
    public String getLongUrl(String tinyUrl) {
        return shortToActualMap.get(tinyUrl);
    }

}
