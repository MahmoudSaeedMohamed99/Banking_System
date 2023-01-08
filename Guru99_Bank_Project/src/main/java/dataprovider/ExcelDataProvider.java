package dataprovider;

import files.ReadExcelFileToDataProvider;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    private Object[][] data = null;

    @DataProvider(name = "LoginTestData")
    public Object[][] testData() {

        ReadExcelFileToDataProvider refd = new ReadExcelFileToDataProvider();
        data = refd.getExcelData();

        return data;
    }

}
