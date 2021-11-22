import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.*;


/**
 * Допустимые значения (блок позитивных тестов):
 * <p>
 * Целые числа -2_147_483_648 до 2_147_483_647
 * <p>
 * Недопустимые значения (блок негативных тестов):
 * Целые числа менее -2_147_483_648;
 * Целые числа более 2_147_483_647;
 * Вещественные числа (3.1416);
 * Буквы и специальные символы
 * <p>
 * <p>
 * Классы эквивалентности допустимых значений:
 * (1) -2_147_483_648 (граничное значение);
 * (2) -2_147_483_647 (перед граничным значением);
 * (3) 2_147_483_647 (граничное значение);
 * (4) 2_147_483_646 (перед граничным значением);
 * (5) 0 (ноль);
 * <p>
 * <p>
 * Классы эквивалентности недопустимых значений:
 * (1) -2_147_483_649 (после граничного значения);
 * (2) 2_147_483_648 (после граничного значения);
 * (3) Вещественное число (3.1416)
 * (4) Буква латиница ("R")
 * (5) Буква кириллица ("П")
 * (6) Специальный символ ("&")
 *
 * Все комбинации 11 значений для четырех операций суммарно дают 484 теста
 */


public class CalculatorTest {


    private Iterator<Object[]> parseCsvData(String fileName) throws IOException
    {
        BufferedReader input = null;
        File file = new File(fileName);
        input = new BufferedReader(new FileReader(file));
        String line = null;

        //создали ArrayList data и в него кладем ArrayList-ы array
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        while ((line = input.readLine()) != null)
        {
            String in = line.trim();
            // поместили значения из файла в массив строк temp
            String[] temp = in.split(",");
            List<Object> arrray = new ArrayList<Object>();

            //помещаем значения в ArrayList array
            for(String s : temp)
            {
                arrray.add(s);
            }
            data.add(arrray.toArray());
                    }
        input.close();

        return data.iterator();
    }

    @DataProvider(name= "dataSummingValid")
    public Iterator<Object[]> testSummingValid() throws IOException
    {
        return parseCsvData(".\\src\\resources\\dataSummingValid.csv");
    }

    @DataProvider(name= "dataSubtractionValid")
    public Iterator<Object[]> testSubtractionData() throws IOException
    {
        return parseCsvData(".\\src\\resources\\dataSubtractionValid.csv");
    }

    @DataProvider(name= "dataMultiplicationValid")
    public Iterator<Object[]> testMultiplicationData() throws IOException
    {
        return parseCsvData(".\\src\\resources\\dataMultiplicationValid.csv");
    }

    @DataProvider(name= "dataDivisionValid")
    public Iterator<Object[]> testDivisionData() throws IOException
    {
        return parseCsvData(".\\src\\resources\\dataDivisionValid.csv");
    }

    @DataProvider(name= "dataNotValid")
    public Iterator<Object[]> testNotValidData() throws IOException
    {
        return parseCsvData(".\\src\\resources\\dataNotValid.csv");
    }


    //Блок позитивных тестов
    //Тесты с делением на ноль руинятся на этапе парсинга результата

    @Test(dataProvider="dataSummingValid")
    public void SummingPositiveTest(String firstValue,String secondValue,String result) throws Exception {

        Integer firstInt= Integer.parseInt(firstValue);
        Integer secondInt= Integer.parseInt(secondValue);;
        Double resultDbl= Double.parseDouble(result);

        System.out.println(firstValue+":"+secondValue+":"+result);

        Assert.assertEquals(resultDbl,Calculator.Summing(firstInt,secondInt));
        }

    @Test(dataProvider="dataSubtractionValid")
    public void SubtractionPositiveTest(String firstValue,String secondValue,String result) throws Exception {

        Integer firstInt= Integer.parseInt(firstValue);
        Integer secondInt= Integer.parseInt(secondValue);;
        Double resultDbl= Double.parseDouble(result);

        System.out.println(firstValue+":"+secondValue+":"+result);

        Assert.assertEquals(resultDbl,Calculator.Subtraction(firstInt,secondInt));
    }

    @Test(dataProvider="dataMultiplicationValid")
    public void MultiplicationPositiveTest(String firstValue,String secondValue,String result) throws Exception {

        Integer firstInt= Integer.parseInt(firstValue);
        Integer secondInt= Integer.parseInt(secondValue);;
        Double resultDbl= Double.parseDouble(result);

        System.out.println(firstValue+":"+secondValue+":"+result);

        Assert.assertEquals(resultDbl,Calculator.Multiplication(firstInt,secondInt));
    }

    @Test(dataProvider="dataDivisionValid")
    public void DivisionPositiveTest(String firstValue,String secondValue,String result) throws Exception {

        Integer firstInt= Integer.parseInt(firstValue);
        Integer secondInt= Integer.parseInt(secondValue);;
        Double resultDbl= Double.parseDouble(result);

        System.out.println(firstValue+":"+secondValue+":"+result);

        Assert.assertEquals(resultDbl,Calculator.Division(firstInt,secondInt));
    }

    //Блок негативных тестов
    //Все тесты руинятся из-за отсутствия результата в файле данных

    @Test(dataProvider="dataNotValid")
    public void SummingNegativeTest(String firstValue,String secondValue,String result) throws Exception {

        Integer firstInt= Integer.parseInt(firstValue);
        Integer secondInt= Integer.parseInt(secondValue);;
        Double resultDbl= Double.parseDouble(result);

        System.out.println(firstValue+":"+secondValue+":"+result);

        Assert.assertEquals(resultDbl,Calculator.Summing(firstInt,secondInt));
    }

    @Test(dataProvider="dataNotValid")
    public void SubtractionNegativeTest(String firstValue,String secondValue,String result) throws Exception {

        Integer firstInt= Integer.parseInt(firstValue);
        Integer secondInt= Integer.parseInt(secondValue);;
        Double resultDbl= Double.parseDouble(result);

        System.out.println(firstValue+":"+secondValue+":"+result);

        Assert.assertEquals(resultDbl,Calculator.Subtraction(firstInt,secondInt));
    }

    @Test(dataProvider="dataNotValid")
    public void MultiplicationNegativeTest(String firstValue,String secondValue,String result) throws Exception {

        Integer firstInt= Integer.parseInt(firstValue);
        Integer secondInt= Integer.parseInt(secondValue);;
        Double resultDbl= Double.parseDouble(result);

        System.out.println(firstValue+":"+secondValue+":"+result);

        Assert.assertEquals(resultDbl,Calculator.Multiplication(firstInt,secondInt));
    }

    @Test(dataProvider="dataNotValid")
    public void DivisionNegativeTest(String firstValue,String secondValue,String result) throws Exception {

        Integer firstInt= Integer.parseInt(firstValue);
        Integer secondInt= Integer.parseInt(secondValue);;
        Double resultDbl= Double.parseDouble(result);

        System.out.println(firstValue+":"+secondValue+":"+result);

        Assert.assertEquals(resultDbl,Calculator.Division(firstInt,secondInt));
    }

    }

