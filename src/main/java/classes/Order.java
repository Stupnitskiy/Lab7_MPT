package classes;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import javax.validation.constraints.*;
import javax.validation.*;
import org.hibernate.validator.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @NotNull(message = "Enter a date")
    @PastOrPresent(message = "Invalid date")
    @Getter @Setter private Calendar orderDate;

    @NotNull(message = "Enter a client")
    @Valid
    @Getter @Setter private Person person;

    @NotNull(message = "Enter a driver")
    @Valid
    @Getter @Setter private Driver driver;

    @NotNull(message = "Enter a price")
    @DecimalMin(value = "1", message = "Is it free?")
    @Getter @Setter private int finalPrice;

    @NotNull(message = "Enter an orderId")
    @Getter @Setter private UUID orderId;

    @Range(min = 1, max = 5, message = "Invalid value of mark")
    @Getter @Setter private int feedbackMark;

    @Getter @Setter private String comment;




}
