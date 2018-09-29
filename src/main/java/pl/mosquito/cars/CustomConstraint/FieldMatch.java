package pl.mosquito.cars.CustomConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = FieldMatchValidator.class)
@Retention(RUNTIME)
public @interface FieldMatch {
    String message() default "Field must match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String first();

    String second();

    //for multiple times

//    @Documented
//    @Target({TYPE, ANNOTATION_TYPE})
//    @interface List
//    {
//        FieldMatch value();
//    }


}
