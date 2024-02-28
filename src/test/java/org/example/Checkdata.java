package org.example;

import Data.Feed_data;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Checkdata extends BaseTest {

    @Test(enabled = true)
    void jsontoString() throws IOException {
        Feed_data feed_data = new Feed_data();
        List<HashMap<String, String>> hashMapList = feed_data.extractdata();
        indexpage.feedData(Feed_data.jsonData);
        indexpage.verify_feed_data(hashMapList);


    }
}
