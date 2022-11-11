package controller.databasecontroller;

import model.Hotel;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class QueryToFile {
    private Query dataBaseQuery;

    public QueryToFile(Query dataBaseQuery) {
        this.dataBaseQuery = dataBaseQuery;
    }

    public void convertToFile(String dbPath) throws Exception {
        File file = new File(dbPath);
        FileOutputStream fos = new FileOutputStream(file);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Campo1;Campo2;...;CampoN\n");

        for (Object object : dataBaseQuery.getObjectList("name")) {
            stringBuilder.append(((Hotel) object).getName() + ";" + ((Hotel) object).getName() + ";...;"
                    + ((Hotel) object).getLocation() + "\n");
        }

        byte finalString[] = stringBuilder.toString().getBytes(StandardCharsets.UTF_8);

        fos.write(finalString);
        fos.close();
    }
}
