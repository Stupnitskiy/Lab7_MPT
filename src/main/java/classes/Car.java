package classes;

import lombok.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

@AllArgsConstructor
public class Car {
    public enum carType {Economy, Business, Lux}

    @NotNull(message = "Select a car type")
    @Getter @Setter private carType driverCar;

    @javax.validation.constraints.NotEmpty(message = "Enter your car name")
    @Length(min = 4, message = "Is your car name really so short?")
    @Getter @Setter private String carName;

    @Pattern(regexp = "^([А-Я]{2})([0-9]{4})([А-Я]{2})$", message = "Number is invalid")
    @Getter @Setter private String carNumberplate;
}