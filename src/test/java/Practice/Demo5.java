package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://blazedemo.com/reserve.php");
        int row_count = driver.findElements(By.xpath("//table[@class=\"table\"]//tbody/tr")).size();
        int column_count = driver.findElements(By.xpath("//table[@class=\"table\"]//th")).size();
        double[] arr = new double[row_count];
        System.out.println("Total number of rows "+row_count);
        System.out.println("Total number of column "+column_count);
        for(int row = 1;row<=row_count;row++){
                String price = driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[6]")).getText();
                String actual_price=price.substring(1);
                double price1 = Double.parseDouble(actual_price);
                System.out.println(price1);
                arr[row-1] = price1;
            }
        System.out.println("List of array element");
        for(double arr1:arr){
            System.out.println(arr1);
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[0]);
    }
}
