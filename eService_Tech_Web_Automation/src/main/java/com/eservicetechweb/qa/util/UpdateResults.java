package com.eservicetechweb.qa.util;


import com.google.gson.*;


import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Date;

public class UpdateResults {

    Date date = new Date();

    public void updateJson(int pass_tc, int fail_tc, int skip_tc) throws IOException, ParseException {
        JsonParser jsonParser = new JsonParser();
        Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + File.separator + "Results.json"));
        JsonObject mainObject = (JsonObject) obj;
        System.out.println("Existing json obj from file : " + mainObject);

        JsonObject newResultObj = new JsonObject();


        newResultObj.add("Passed TC", new Gson().toJsonTree(pass_tc));
        newResultObj.add("Failed TC", new Gson().toJsonTree(fail_tc));
        newResultObj.add("Skip TC", new Gson().toJsonTree(skip_tc));


        System.out.println("New record to be added " + newResultObj);

        mainObject.add(date.toString(), newResultObj);

//        ========================================================
//        Dont touch this code
//        ========================================================
//        JSONObject newResultObj = new JSONObject();
//
//        newResultObj.put("Passed TC", pass_tc);
//        newResultObj.put("Failed TC", fail_tc);
//        newResultObj.put("Skip TC", skip_tc);
//
//        JSONObject newRecord = new JSONObject();
//
//        newRecord.put("Record", newResultObj);

//   ========================================================

        FileWriter file = new FileWriter(System.getProperty("user.dir") + File.separator + "Results.json", false);
        file.write(String.valueOf(mainObject));
        file.flush();
        file.close();

    }
}


