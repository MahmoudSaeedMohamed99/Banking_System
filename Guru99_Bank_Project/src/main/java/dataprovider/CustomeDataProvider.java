package dataprovider;


import org.testng.annotations.DataProvider;

public class CustomeDataProvider {

    @DataProvider(name = "New Customer Data")
    public Object[][] newCustomerData() {
        return new Object[][] {
                {"Mohamed", "male", "10-16-2013", "Jamnagar", "Jamnagar", "Gujarat", "516832", "8000439024", "Mohamed66@gmail.com", "12345_"}
        };
    }
}
