package org.example;

import Data.Feed_data;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Checkdata extends BaseTest {

    @Test(enabled = true)
    void jsontoString() throws IOException {
        Feed_data feed_data = new Feed_data();//extraction of data is perform in this class.
        List<HashMap<String, String>> hashMapList = feed_data.extractdata();//transferring json into a list hashmap.
        indexpage.feedData(Feed_data.jsonData);//feedData method fill feed the data in text box.
        indexpage.verify_feed_data(hashMapList);//verification will be done between feeded data and the data the data present in jsndata file.



    }
}
