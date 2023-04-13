package info.config;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.*;
import org.openqa.selenium.support.*;


@Retention(RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@PageFactoryFinder(FindBy.FindByBuilder.class)
public @interface PageObject {

}
