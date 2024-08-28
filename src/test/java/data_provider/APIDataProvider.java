package data_provider;

import org.testng.annotations.DataProvider;
import utilities.ExcelData;

import java.io.File;
import java.io.IOException;

public class APIDataProvider {
private ExcelData excelData;
private String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Userdata.xlsx";

@DataProvider(name = "Sheet1")

    public Object[][] apiTestUser(){
    excelData = new ExcelData(filePath);
    return excelData.readStringArrays("Sheet1");
}



    @DataProvider(name="UserNames")
    public Object[] getUserNames() throws IOException {

        excelData = new ExcelData(filePath);

        int rownum = excelData.getRowCount("Sheet1");

        String apidata[] = new String[rownum];

        for (int i = 1; i <= rownum; i++) {
            apidata[i - 1] = excelData.getCellData("Sheet1", i, 1);

        }

        return apidata;

    }
}
