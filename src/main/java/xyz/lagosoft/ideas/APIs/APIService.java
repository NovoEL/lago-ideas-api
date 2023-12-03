package xyz.lagosoft.ideas.APIs;

import java.util.List;

public interface APIService {

    List<AwesomeAPI> retrieveAllAPIs();

    List<AwesomeAPI> retrieveAPIsByCategory(String slug);

    AwesomeAPI retrieveAPI(String slug);

    List<AwesomeAPI> retrieveAPIsBySlugs(List<String> slugs);

}
