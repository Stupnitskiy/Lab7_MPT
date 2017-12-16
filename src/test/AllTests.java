import classes.Car;
import classes.Driver;
import classes.Order;
import classes.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.UUID;

public class AllTests {

    private Validator validator;
    Person person = new Person("sdsd@asd.com", "Anthony Stupnitskiy", "+38067-455-23-11");
    Car car = new Car(Car.carType.Economy, "Infinity", "АА3232АА");
    Driver driver = new Driver("Somebody Else", "+38067-455-33-22", car);

    @Before
    public void before() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testCar() {
        Car car = new Car();
        car.setDriverCar(null);
        car.setCarNumberplate("ЫВ3232ЫВ");
        car.setCarName("Infinity");
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        Assert.assertEquals(1, constraintViolations.size() );
        Assert.assertEquals("Select a car type", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testDriver() {
        Driver driver = new Driver();
        driver.setPhoneNumber("0974553322");
        driver.setFullName("Somebody Else");
        driver.setCar(car);
        Set<ConstraintViolation<Driver>> constraintViolations = validator.validate(driver);

        Assert.assertEquals(1, constraintViolations.size() );
        Assert.assertEquals("Number is invalid", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testOrder() {
        Order order = new Order();
        order.setComment("empty");
        order.setDriver(driver);
        order.setPerson(person);
        order.setFeedbackMark(4);
        order.setFinalPrice(1);
        order.setOrderDate(null);
        order.setOrderId(UUID.randomUUID());

        Set<ConstraintViolation<Order>> constraintViolations = validator.validate(order);

        Assert.assertEquals(1, constraintViolations.size() );
        Assert.assertEquals("Enter a date", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testPerson() {
        Person person = new Person();
        person.setEmail("sdsdasd.com");
        person.setFullName("Anthony Stupnitskiy");
        person.setPhoneNumber("+38067-455-23-11");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        Assert.assertEquals(1, constraintViolations.size() );
        Assert.assertEquals("Email is invalid", constraintViolations.iterator().next().getMessage());
    }
}
